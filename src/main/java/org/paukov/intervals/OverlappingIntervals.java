package org.paukov.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class OverlappingIntervals {

  // Returns the free slots between the overlapping intervals.
  // Idea: Use the heap to track the end of the intervals.
  // Time: O(nlogn), Space: O(n).
  public static List<int[]> findFreeSlots(List<int[]> intervals){
    List<int[]> result = new ArrayList<>();

    // Sort intervals by the start time.
    Collections.sort(intervals, (a, b) -> a[0]-b[0]);

    // To track the finished intervals we need a min heap 'sorted' by the end time.
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[1]-b[1]);

    for (int i=0; i<intervals.size(); i++){
      // We keep adding the intervals that overlaps with the minHeap.peek()
      // to the heap. Once we detect a non-overlapped interval => we add it to the result.
      while(!minHeap.isEmpty() && minHeap.peek()[1] <= intervals.get(i)[0]){
        // We need the last interval in the heap to calculate the gap.
        // The heap has the overlapped intervals, so we need to remove them
        // until we have a gap and the heap only has one interval.
        if (minHeap.size()==1 && minHeap.peek()[1] != intervals.get(i)[0]){
          // Add the gap to the list
          result.add(new int[]{minHeap.peek()[1], intervals.get(i)[0]});
        }
        minHeap.poll();
      }
      // Add the new interval into the heap.
      minHeap.offer(intervals.get(i));
    }
    return result;
  }


  // Time: O(n*logn), Space: O(n).
  public static List<int[]> mergeToNonOverlapping(List<int[]> overlapped){
    if (overlapped.size() < 1) {
      return overlapped;
    }

    // Sort the overlapped intervals by the start time
    Collections.sort(overlapped, (a,b) -> a[0]-b[0]);

    // Use the stack implementation of the linked list
    LinkedList<int[]> stack = new LinkedList<>();

    // Insert the first interval.
    // We use the 'last' method to preserve the sorted order of the intervals.
    stack.offerLast(overlapped.get(0));

    for (int i=1; i<overlapped.size(); i++) {
      int[] topInterval = stack.peekLast();
      int[] current = overlapped.get(i);
      // We know that the topInterval should be before the current (because of sorting).
      if(topInterval[1] >= current[0]) { // Is overlapped?
        // Remove the top interval
        stack.pollLast();
        // Adjust the size of the new interval before its inserting into the list
        current[0] = Math.min(topInterval[0], current[0]);
        current[1] = Math.max(topInterval[1], current[1]);
      }
      stack.offerLast(current);
    }
    return stack;
  }
}

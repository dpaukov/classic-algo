package org.paukov.intervals;

import java.util.ArrayList;
import java.util.Collections;
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
      while(!minHeap.isEmpty() && minHeap.peek()[1] <= intervals.get(i)[0]){
        // we need the last interval in the heap to calculate the gap
        if (minHeap.size()==1 && minHeap.peek()[1] != intervals.get(i)[0]){
          // add the gap to the list
          result.add(new int[]{minHeap.peek()[1], intervals.get(i)[0]});
        }
        minHeap.poll();
      }
      minHeap.offer(intervals.get(i));
    }
    return result;
  }
}

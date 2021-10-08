package org.paukov.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Classic algorithms with the non-overlapping intervals represented by arrays:
 * [[x1, x2], [x3, x4], ...]
 */
public class NonOverlappingIntervals {

  public static List<int[]> insert(int[] interval, List<int[]> list){
    List<int[]> result = new ArrayList<>();
    int i = 0;

    // Insert all intervals before the new interval.
    while(i < list.size() &&  list.get(i)[1] < interval[0]){
      result.add(list.get(i));
      i++;
    }

    // Extend the new interval with the other existing overlapped intervals.
    while(i<list.size() && (list.get(i)[1] <= interval[1] || list.get(i)[0] <= interval[1])) {
      interval[0] = Math.min(interval[0], list.get(i)[0]);
      interval[1] = Math.max(interval[1], list.get(i)[1]);
      i++;
    }
    result.add(interval);

    // Add the rest of the intervals (if any).
    while(i<list.size()){
      result.add(list.get(i));
      i++;
    }

    return result;
  }
}

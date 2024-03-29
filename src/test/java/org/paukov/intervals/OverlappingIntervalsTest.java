package org.paukov.intervals;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OverlappingIntervalsTest {

  @Test
  void findFreeSlots_overlapping() {
    List<int[]> intervals = new ArrayList<>(
        asList(new int[]{2, 6}, new int[]{3, 8}, new int[]{3, 7}, new int[]{10, 15}));

    List<int[]> result = OverlappingIntervals.findFreeSlots(intervals);

    assertThat(result).containsExactly(new int[]{8, 10});
  }

  @Test
  void findFreeSlots_single() {
    List<int[]> intervals = new ArrayList<>(asList(new int[]{2, 6}));

    List<int[]> result = OverlappingIntervals.findFreeSlots(intervals);

    assertThat(result).isEmpty();
  }

  @Test
  void findFreeSlots_empty() {
    List<int[]> intervals = new ArrayList<>();

    List<int[]> result = OverlappingIntervals.findFreeSlots(intervals);

    assertThat(result).isEmpty();
  }

  @Test
  void findFreeSlots_non_overlapping() {
    List<int[]> intervals = new ArrayList<>(
        asList(new int[]{10, 15}, new int[]{6, 8}, new int[]{2, 4}, new int[]{20, 25}));

    List<int[]> result = OverlappingIntervals.findFreeSlots(intervals);

    assertThat(result).containsExactly(new int[]{4, 6}, new int[]{8, 10}, new int[]{15, 20});
  }

  @Test
  void mergeToNonOverlapping() {
    List<int[]> intervals = new ArrayList<>(
        asList(new int[]{2, 6}, new int[]{3, 8}, new int[]{3, 7}, new int[]{4, 5},
            new int[]{10, 15}));

    List<int[]> result = OverlappingIntervals.mergeToNonOverlapping(intervals);

    assertThat(result).containsExactly(new int[]{2, 8}, new int[]{10, 15});
  }

  @Test
  void mergeToNonOverlapping_single() {
    List<int[]> intervals = new ArrayList<>(asList(new int[]{2, 6}));

    List<int[]> result = OverlappingIntervals.mergeToNonOverlapping(intervals);

    assertThat(result).containsExactly(new int[]{2, 6});
  }

  @Test
  void mergeToNonOverlapping_two_overlapped() {
    List<int[]> intervals = new ArrayList<>(asList(new int[]{2, 6}, new int[]{5, 8}));

    List<int[]> result = OverlappingIntervals.mergeToNonOverlapping(intervals);

    assertThat(result).containsExactly(new int[]{2, 8});
  }

  @Test
  void mergeToNonOverlapping_two_overlapped_on_border() {
    List<int[]> intervals = new ArrayList<>(asList(new int[]{2, 6}, new int[]{6, 8}));

    List<int[]> result = OverlappingIntervals.mergeToNonOverlapping(intervals);

    assertThat(result).containsExactly(new int[]{2, 8});
  }

  @Test
  void mergeToNonOverlapping_two_non_overlapped() {
    List<int[]> intervals = new ArrayList<>(asList(new int[]{2, 6}, new int[]{7, 8}));

    List<int[]> result = OverlappingIntervals.mergeToNonOverlapping(intervals);

    assertThat(result).containsExactly(new int[]{2, 6}, new int[]{7, 8});
  }

  @Test
  void mergeToNonOverlapping_empty() {
    List<int[]> intervals = new ArrayList<>();

    List<int[]> result = OverlappingIntervals.mergeToNonOverlapping(intervals);

    assertThat(result).isEmpty();
  }

}
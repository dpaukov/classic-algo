package org.paukov.intervals;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NonOverlappingIntervalsTest {

  @Test
  void insert_into_empty_list() {
    List<int[]> result = NonOverlappingIntervals.insert(new int[]{1, 2}, new ArrayList<>());
    assertThat(result).containsOnly(new int[]{1, 2});
  }

  @Test
  void insert_before() {
    List<int[]> list = new ArrayList<>(asList(new int[]{5, 6}));

    List<int[]> result = NonOverlappingIntervals.insert(new int[]{1, 2}, list);

    assertThat(result).containsExactly(new int[]{1, 2}, new int[]{5, 6});
  }

  @Test
  void insert_after() {
    List<int[]> list = new ArrayList<>(asList(new int[]{1, 4}));

    List<int[]> result = NonOverlappingIntervals.insert(new int[]{10, 20}, list);

    assertThat(result).containsExactly(new int[]{1, 4}, new int[]{10, 20});
  }

  @Test
  void insert_middle() {
    List<int[]> list = new ArrayList<>(asList(new int[]{1, 4}, new int[]{6, 8}, new int[]{10, 15}));

    List<int[]> result = NonOverlappingIntervals.insert(new int[]{5, 9}, list);

    assertThat(result).containsExactly(new int[]{1, 4}, new int[]{5, 9}, new int[]{10, 15});
  }

  @Test
  void insert_all() {
    List<int[]> list = new ArrayList<>(
        asList(new int[]{2, 4}, new int[]{6, 8}, new int[]{10, 15}, new int[]{20, 25}));

    List<int[]> result = NonOverlappingIntervals.insert(new int[]{3, 20}, list);

    assertThat(result).containsExactly(new int[]{2, 25});
  }
}
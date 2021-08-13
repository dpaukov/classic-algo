package org.paukov.cyclesort;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CycleSortTest {

  @Test
  void sort_1() {
    int[] arr = new int[]{2, 3, 5, 1, 4, 0, 9, 6, 7, 8};
    CycleSort.sort(arr);
    assertThat(arr).isEqualTo(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
  }

  @Test
  void findCycles_1() {
    List<List<Integer>> cycles = CycleSort.findCycles(new int[]{0, 5, 6, 8, 7, 4, 9, 1, 3, 2});
    assertThat(cycles).containsExactly(
        Arrays.asList(0),
        Arrays.asList(5, 4, 7, 1),
        Arrays.asList(6, 9, 2),
        Arrays.asList(8, 3),
        Arrays.asList()
    );
  }

  @Test
  void findCycles_2() {
    List<List<Integer>> cycles = CycleSort.findCycles(new int[]{0, 1, 2, 3});
    assertThat(cycles).containsExactly(
        Arrays.asList(0),
        Arrays.asList(1),
        Arrays.asList(2),
        Arrays.asList(3),
        Arrays.asList()
    );
  }

  @Test
  void findCycles_3() {
    List<List<Integer>> cycles = CycleSort.findCycles(new int[]{3, 2, 1, 0});
    assertThat(cycles).containsExactly(
        Arrays.asList(3, 0),
        Arrays.asList(2, 1),
        Arrays.asList()
    );
  }

  @Test
  void findCycles_4() {
    List<List<Integer>> cycles = CycleSort.findCycles(new int[]{4, 3, 2, 1, 0});
    assertThat(cycles).containsExactly(
        Arrays.asList(4, 0),
        Arrays.asList(3, 1),
        Arrays.asList(2),
        Arrays.asList()
    );
  }

  @Test
  void findCycles_5() {
    List<List<Integer>> cycles = CycleSort.findCycles(new int[]{3, 0, 1, 2, 6, 4, 5});
    assertThat(cycles).containsExactly(
        Arrays.asList(3, 2, 1, 0),
        Arrays.asList(6, 5, 4),
        Arrays.asList()
    );
  }
}
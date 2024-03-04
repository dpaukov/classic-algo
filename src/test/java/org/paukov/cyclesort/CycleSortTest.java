package org.paukov.cyclesort;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

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
        asList(0),
        asList(5, 4, 7, 1),
        asList(6, 9, 2),
        asList(8, 3),
        asList()
    );
  }

  @Test
  void findCycles_2() {
    List<List<Integer>> cycles = CycleSort.findCycles(new int[]{0, 1, 2, 3});
    assertThat(cycles).containsExactly(
        asList(0),
        asList(1),
        asList(2),
        asList(3),
        asList()
    );
  }

  @Test
  void findCycles_3() {
    List<List<Integer>> cycles = CycleSort.findCycles(new int[]{3, 2, 1, 0});
    assertThat(cycles).containsExactly(
        asList(3, 0),
        asList(2, 1),
        asList()
    );
  }

  @Test
  void findCycles_4() {
    List<List<Integer>> cycles = CycleSort.findCycles(new int[]{4, 3, 2, 1, 0});
    assertThat(cycles).containsExactly(
        asList(4, 0),
        asList(3, 1),
        asList(2),
        asList()
    );
  }

  @Test
  void findCycles_5() {
    List<List<Integer>> cycles = CycleSort.findCycles(new int[]{3, 0, 1, 2, 6, 4, 5});
    assertThat(cycles).containsExactly(
        asList(3, 2, 1, 0),
        asList(6, 5, 4),
        asList()
    );
  }
}
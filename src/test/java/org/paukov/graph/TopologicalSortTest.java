package org.paukov.graph;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TopologicalSortTest {

  @Test
  void sort_1() {
    List<Integer> result = TopologicalSort.sort(5, new int[][]{
        new int[]{4, 2},
        new int[]{4, 3},
        new int[]{2, 0},
        new int[]{2, 1},
        new int[]{3, 1}});

    assertThat(result).containsExactly(4, 2, 3, 0, 1);
  }

  @Test
  void sort_2() {
    List<Integer> result = TopologicalSort.sort(7, new int[][]{
        new int[]{6, 4},
        new int[]{6, 2},
        new int[]{5, 3},
        new int[]{5, 4},
        new int[]{3, 0},
        new int[]{3, 1},
        new int[]{3, 2},
        new int[]{4, 1}});

    assertThat(result).containsExactly(5, 6, 3, 4, 0, 2, 1);
  }

  @Test
  void sort_cycle() {
    List<Integer> result = TopologicalSort.sort(6, new int[][]{
        new int[]{1, 0},
        new int[]{0, 2},
        new int[]{2, 4},
        new int[]{4, 1},
        new int[]{3, 2},
        new int[]{5, 4}});

    assertThat(result).isEmpty();
  }
}
package org.paukov.graph;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
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

  @Test
  void allSort_1() {
    List<List<Integer>> result = TopologicalSort.allSort(4,
        new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});

    assertThat(result).hasSize(2);
    assertThat(result).containsExactly(Arrays.asList(3, 2, 0, 1), Arrays.asList(3, 2, 1, 0));
  }

  @Test
  void allSort_2() {
    List<List<Integer>> result = TopologicalSort.allSort(6, new int[][]{
        new int[]{2, 5},
        new int[]{0, 5},
        new int[]{0, 4},
        new int[]{1, 4},
        new int[]{3, 2},
        new int[]{1, 3}});

    assertThat(result).hasSize(13);
    assertThat(result).containsExactly(
        Arrays.asList(0, 1, 3, 2, 4, 5),
        Arrays.asList(0, 1, 3, 2, 5, 4),
        Arrays.asList(0, 1, 3, 4, 2, 5),
        Arrays.asList(0, 1, 4, 3, 2, 5),
        Arrays.asList(1, 0, 3, 2, 4, 5),
        Arrays.asList(1, 0, 3, 2, 5, 4),
        Arrays.asList(1, 0, 3, 4, 2, 5),
        Arrays.asList(1, 0, 4, 3, 2, 5),
        Arrays.asList(1, 3, 0, 2, 4, 5),
        Arrays.asList(1, 3, 0, 2, 5, 4),
        Arrays.asList(1, 3, 0, 4, 2, 5),
        Arrays.asList(1, 3, 2, 0, 4, 5),
        Arrays.asList(1, 3, 2, 0, 5, 4));
  }

  @Test
  void allSort_3() {
    List<List<Integer>> result = TopologicalSort.allSort(3, new int[][]{
        new int[]{0, 1},
        new int[]{1, 2}});

    assertThat(result).hasSize(1);
    assertThat(result).containsExactly(
        Arrays.asList(0, 1, 2));
  }

  @Test
  void allSort_4() {
    List<List<Integer>> result = TopologicalSort.allSort(3, new int[][]{});

    assertThat(result).hasSize(6);
    assertThat(result).containsExactly(
        Arrays.asList(0, 1, 2),
        Arrays.asList(0, 2, 1),
        Arrays.asList(1, 0, 2),
        Arrays.asList(1, 2, 0),
        Arrays.asList(2, 0, 1),
        Arrays.asList(2, 1, 0));
  }
}
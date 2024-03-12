package org.paukov.backtracking;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ChildAndStaircaseTest {

  @Test
  void of_0() {
    List<List<Integer>> result = ChildAndStaircase.of(0);
    assertThat(result).containsExactly(new ArrayList<>());
  }

  @Test
  void of_1() {
    List<List<Integer>> result = ChildAndStaircase.of(1);
    assertThat(result).containsExactly(
        asList(1)
    );
  }

  @Test
  void of_2() {
    List<List<Integer>> result = ChildAndStaircase.of(2);
    assertThat(result).containsExactly(
        asList(1, 1),
        asList(2)
    );
  }

  @Test
  void of_6() {
    List<List<Integer>> result = ChildAndStaircase.of(6);
    assertThat(result).containsExactly(
        asList(1, 1, 1, 1, 1, 1),
        asList(1, 1, 1, 1, 2),
        asList(1, 1, 1, 2, 1),
        asList(1, 1, 1, 3),
        asList(1, 1, 2, 1, 1),
        asList(1, 1, 2, 2),
        asList(1, 1, 3, 1),
        asList(1, 2, 1, 1, 1),
        asList(1, 2, 1, 2),
        asList(1, 2, 2, 1),
        asList(1, 2, 3),
        asList(1, 3, 1, 1),
        asList(1, 3, 2),
        asList(2, 1, 1, 1, 1),
        asList(2, 1, 1, 2),
        asList(2, 1, 2, 1),
        asList(2, 1, 3),
        asList(2, 2, 1, 1),
        asList(2, 2, 2),
        asList(2, 3, 1),
        asList(3, 1, 1, 1),
        asList(3, 1, 2),
        asList(3, 2, 1),
        asList(3, 3)
    );
  }
}
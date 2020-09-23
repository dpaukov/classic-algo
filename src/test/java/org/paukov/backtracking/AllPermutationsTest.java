package org.paukov.backtracking;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

final class AllPermutationsTest {

  @Test
  public void test_permutations_of_0() {
    List<int[]> result = AllPermutations.of(0);
    assertThat(result).hasSize(1);
    assertThat(result.get(0)).isEqualTo(new int[]{});
  }

  @Test
  public void test_permutations_of_3() {
    List<int[]> result = AllPermutations.of(3);
    assertThat(result).hasSize(6);
    assertThat(result.get(0)).isEqualTo(new int[]{1, 2, 3});
    assertThat(result.get(1)).isEqualTo(new int[]{1, 3, 2});
    assertThat(result.get(2)).isEqualTo(new int[]{2, 1, 3});
    assertThat(result.get(3)).isEqualTo(new int[]{2, 3, 1});
    assertThat(result.get(4)).isEqualTo(new int[]{3, 1, 2});
    assertThat(result.get(5)).isEqualTo(new int[]{3, 2, 1});
  }
}
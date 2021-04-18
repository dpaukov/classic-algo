package org.paukov.partition;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public final class ThreeWayPartitioningTest {

  @Test
  public void test_run() {
    int[] array = new int[]{20, 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
    ThreeWayPartitioning.Pair pair = ThreeWayPartitioning.run(array, 0, array.length - 1);

    assertThat(pair.lt).isEqualTo(7);
    assertThat(pair.gt).isEqualTo(9);
    assertThat(array).isEqualTo(new int[]{1, 14, 5, 4, 2, 1, 3, 20, 20, 20, 98, 87, 32, 54});
  }

  @Test
  public void test_run_all_duplicates_values() {
    int[] array = new int[]{1, 1, 1, 1, 1, 1};
    ThreeWayPartitioning.Pair pair = ThreeWayPartitioning.run(array, 0, array.length - 1);

    assertThat(pair.lt).isEqualTo(0);
    assertThat(pair.gt).isEqualTo(5);
    assertThat(array).isEqualTo(new int[]{1, 1, 1, 1, 1, 1});
  }

  @Test
  public void test_run_two_values() {
    int[] array = new int[]{0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    ThreeWayPartitioning.Pair pair = ThreeWayPartitioning.run(array, 0, array.length - 1);

    assertThat(pair.lt).isEqualTo(0);
    assertThat(pair.gt).isEqualTo(7);
    assertThat(array).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1});
  }

  @Test
  public void test_run_dutch_flag() {
    int[] array = new int[]{0, 1, 0, 2, 0, 1, 0, 2, 2, 2, 0, 1, 1, 2, 1, 0, 2, 2, 0, 0, 1, 1, 1, 2,
        2, 1, 0};
    ThreeWayPartitioning.Pair pair = ThreeWayPartitioning.run(array, 0, array.length - 1);

    assertThat(pair.lt).isEqualTo(0);
    assertThat(pair.gt).isEqualTo(8);
    assertThat(array).isEqualTo(
        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 2, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 2, 1});
  }

  @Test
  public void test_run_empty() {
    int[] array = new int[]{};
    ThreeWayPartitioning.Pair pair = ThreeWayPartitioning.run(array, 0, array.length - 1);

    assertThat(pair.lt).isEqualTo(0);
    assertThat(pair.gt).isEqualTo(-1);
    assertThat(array).isEmpty();
  }

  @Test
  public void test_run_one_element() {
    int[] array = new int[]{1};
    ThreeWayPartitioning.Pair pair = ThreeWayPartitioning.run(array, 0, array.length - 1);

    assertThat(pair.lt).isEqualTo(0);
    assertThat(pair.gt).isEqualTo(0);
    assertThat(array).isEqualTo(new int[]{1});
  }

  @Test
  public void test_run_unique_element() {
    int[] array = new int[]{10, 1, 3, 4, 5, 7, 11, 15, 16, 15, 18};
    ThreeWayPartitioning.Pair pair = ThreeWayPartitioning.run(array, 0, array.length - 1);

    assertThat(pair.lt).isEqualTo(5);
    assertThat(pair.gt).isEqualTo(5);
    assertThat(array).isEqualTo(new int[]{1, 3, 4, 5, 7, 10, 15, 16, 15, 18, 11});
  }
}

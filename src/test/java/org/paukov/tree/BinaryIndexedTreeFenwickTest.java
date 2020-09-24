package org.paukov.tree;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.paukov.tree.BinaryIndexedTreeFenwick.createIntSumBIT;
import static org.paukov.tree.BinaryIndexedTreeFenwick.createPrefixMinBIT;

import org.junit.jupiter.api.Test;

final class BinaryIndexedTreeFenwickTest {

  @Test
  void createIntSumBIT_0() {
    BinaryIndexedTreeFenwick<Integer> bit = createIntSumBIT(asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(bit.queryCumulative(0)).isEqualTo(1);
  }

  @Test
  void createIntSumBIT_1() {
    BinaryIndexedTreeFenwick<Integer> bit = createIntSumBIT(asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(bit.queryCumulative(1)).isEqualTo(3);
  }

  @Test
  void createIntSumBIT_2() {
    BinaryIndexedTreeFenwick<Integer> bit = createIntSumBIT(asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(bit.queryCumulative(2)).isEqualTo(6);
  }

  @Test
  void createIntSumBIT_3() {
    BinaryIndexedTreeFenwick<Integer> bit = createIntSumBIT(asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(bit.queryCumulative(3)).isEqualTo(10);
  }

  @Test
  void createIntSumBIT_4() {
    BinaryIndexedTreeFenwick<Integer> bit = createIntSumBIT(asList(1, 2, 3, 4, -3, 6, 7));
    assertThat(bit.queryCumulative(4)).isEqualTo(7);
  }

  @Test
  void createIntSumBIT_5() {
    BinaryIndexedTreeFenwick<Integer> bit = createIntSumBIT(asList(1, 2, 3, 4, -3, -2, 7));
    assertThat(bit.queryCumulative(5)).isEqualTo(5);
  }

  @Test
  void createIntSumBIT_6() {
    BinaryIndexedTreeFenwick<Integer> bit = createIntSumBIT(asList(1, 2, 3, 4, 0, 0, 7));
    assertThat(bit.queryCumulative(6)).isEqualTo(17);
  }

  @Test
  void addIntSumBIT_4() {
    BinaryIndexedTreeFenwick<Integer> bit = createIntSumBIT(asList(1, 2, 3, 4, 0, 0, 7));
    assertThat(bit.queryCumulative(6)).isEqualTo(17);
    bit.add(2, -7);
    assertThat(bit.queryCumulative(6)).isEqualTo(10);
  }

  @Test
  void range_2_5() {
    BinaryIndexedTreeFenwick<Integer> bit = createIntSumBIT(asList(1, 2, 3, 4, 5, 6, 7));
    Integer result = bit.queryCumulative(5) - bit.queryCumulative(1);
    assertThat(result).isEqualTo(18);
  }

  @Test
  void addIntPrefixMinBIT() {
    BinaryIndexedTreeFenwick<Integer> bit = createPrefixMinBIT(asList(1, 2, 3, 4, 0, 0, 7));
    assertThat(bit.queryCumulative(3)).isEqualTo(1);
    bit.add(2, -7);
    assertThat(bit.queryCumulative(3)).isEqualTo(-7);
  }
}
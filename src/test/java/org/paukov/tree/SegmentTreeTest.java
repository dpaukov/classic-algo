package org.paukov.tree;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.paukov.tree.SegmentTree.createIntMaxTree;
import static org.paukov.tree.SegmentTree.createIntMinTree;
import static org.paukov.tree.SegmentTree.createIntSumTree;

import org.junit.jupiter.api.Test;

final class SegmentTreeTest {

  @Test
  void createIntSumTree_0_6() {
    SegmentTree<Integer> segmentTree = createIntSumTree(asList(1, 2, 3, 4, 5, 6, 7));

    assertThat(segmentTree.queryRange(0, 6)).isEqualTo(28);
  }

  @Test
  void createIntSumTree_0_2() {
    SegmentTree<Integer> segmentTree = createIntSumTree(asList(1, 2, 3, 4, 5, 6, 7));

    assertThat(segmentTree.queryRange(0, 2)).isEqualTo(6);
  }

  @Test
  void createIntSumTree_2_4() {
    SegmentTree<Integer> segmentTree = createIntSumTree(asList(1, 2, 3, 4, 5, 6, 7));

    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(12);
  }

  @Test
  void updateIntSumTree() {
    SegmentTree<Integer> segmentTree = createIntSumTree(asList(1, 2, 3, 4, 5, 6, 7));

    segmentTree.update(0, 100);
    segmentTree.update(3, 1000);

    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(1008);
  }

  @Test
  void createIntMinTree_0_6() {
    SegmentTree<Integer> segmentTree = createIntMinTree(asList(1, 2, 3, 4, 5, 6, 7));

    assertThat(segmentTree.queryRange(0, 6)).isEqualTo(1);
  }

  @Test
  void createIntMinTree_0_2() {
    SegmentTree<Integer> segmentTree = createIntMinTree(asList(1, 2, 3, 4, 5, 6, 7));

    assertThat(segmentTree.queryRange(0, 2)).isEqualTo(1);
  }

  @Test
  void createIntMinTree_2_4() {
    SegmentTree<Integer> segmentTree = createIntMinTree(asList(1, 2, 3, 4, 5, 6, 7));

    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(3);
  }

  @Test
  void updateIntMinTree() {
    SegmentTree<Integer> segmentTree = createIntMinTree(asList(1, 2, 3, 4, 5, 6, 7));

    segmentTree.update(1, -30);
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(3);

    segmentTree.update(3, -100);
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(-100);
  }

  @Test
  void createIntMaxTree_0_6() {
    SegmentTree<Integer> segmentTree = createIntMaxTree(asList(1, 2, 3, 4, 5, 6, 7));

    assertThat(segmentTree.queryRange(0, 6)).isEqualTo(7);
  }

  @Test
  void createIntMaxTree_0_2() {
    SegmentTree<Integer> segmentTree = createIntMaxTree(asList(1, 2, 3, 4, 5, 6, 7));

    assertThat(segmentTree.queryRange(0, 2)).isEqualTo(3);
  }

  @Test
  void createIntMaxTree_2_4() {
    SegmentTree<Integer> segmentTree = createIntMaxTree(asList(1, 2, 3, 4, 5, 6, 7));

    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(5);
  }

  @Test
  void updateIntMaxTree() {
    SegmentTree<Integer> segmentTree = createIntMaxTree(asList(1, 2, 3, 4, 5, 6, 7));

    segmentTree.update(1, 1000);
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(5);

    segmentTree.update(3, 1000);
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(1000);
  }
}
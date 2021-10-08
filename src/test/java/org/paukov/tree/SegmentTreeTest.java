package org.paukov.tree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

final class SegmentTreeTest {

  @Test
  void createIntSumTree_0_6() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntSumTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(segmentTree.queryRange(0, 6)).isEqualTo(28);
  }

  @Test
  void createIntSumTree_0_2() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntSumTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(segmentTree.queryRange(0, 2)).isEqualTo(6);
  }

  @Test
  void createIntSumTree_2_4() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntSumTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(12);
  }

  @Test
  void updateIntSumTree() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntSumTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    segmentTree.update(0, 100);
    segmentTree.update(3, 1000);
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(1008);
  }

  @Test
  void createIntMinTree_0_6() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntMinTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(segmentTree.queryRange(0, 6)).isEqualTo(1);
  }

  @Test
  void createIntMinTree_0_2() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntMinTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(segmentTree.queryRange(0, 2)).isEqualTo(1);
  }

  @Test
  void createIntMinTree_2_4() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntMinTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(3);
  }

  @Test
  void updateIntMinTree() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntMinTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    segmentTree.update(1, -30);
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(3);
    segmentTree.update(3, -100);
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(-100);
  }

  @Test
  void createIntMaxTree_0_6() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntMaxTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(segmentTree.queryRange(0, 6)).isEqualTo(7);
  }

  @Test
  void createIntMaxTree_0_2() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntMaxTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(segmentTree.queryRange(0, 2)).isEqualTo(3);
  }

  @Test
  void createIntMaxTree_2_4() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntMaxTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(5);
  }

  @Test
  void updateIntMaxTree() {
    SegmentTree<Integer> segmentTree = SegmentTree
        .createIntMaxTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    segmentTree.update(1, 1000);
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(5);
    segmentTree.update(3, 1000);
    assertThat(segmentTree.queryRange(2, 4)).isEqualTo(1000);
  }
}
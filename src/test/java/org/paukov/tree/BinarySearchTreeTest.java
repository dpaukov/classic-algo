package org.paukov.tree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

final class BinarySearchTreeTest {

  @Test
  public void test_add_search_binary_tree() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.add(15, 6);
    tree.add(16, 7);
    tree.add(12, 8);
    tree.add(10, 9);
    tree.add(13, 11);
    tree.add(14, 11);
    tree.add(15, 60);

    assertThat(tree.search(12)).isEqualTo(8);
    assertThat(tree.search(16)).isEqualTo(7);
    assertThat(tree.search(10)).isEqualTo(9);
    assertThat(tree.search(13)).isEqualTo(11);
    assertThat(tree.search(14)).isEqualTo(11);
    assertThat(tree.search(15)).isEqualTo(60);
    assertThat(tree.search(11)).isNull();
    assertThat(tree.search(20)).isNull();
  }
}
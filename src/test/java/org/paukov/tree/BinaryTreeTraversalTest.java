package org.paukov.tree;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.paukov.tree.BinaryTreeTraversal.TreeNode;

final class BinaryTreeTraversalTest {

  TreeNode createTestTree() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(7);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);
    return root;
  }

  @Test
  void inorder() {
    TreeNode root = createTestTree();

    List<Integer> expected = new ArrayList<>();
    BinaryTreeTraversal.inorder(root, expected);

    assertThat(expected).containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
  }

  @Test
  void preorder() {
    TreeNode root = createTestTree();

    List<Integer> expected = new ArrayList<>();
    BinaryTreeTraversal.preorder(root, expected);

    assertThat(expected).containsExactly(5, 3, 2, 1, 4, 7, 6, 8);
  }

  @Test
  void postorder() {
    TreeNode root = createTestTree();

    List<Integer> expected = new ArrayList<>();
    BinaryTreeTraversal.postorder(root, expected);

    assertThat(expected).containsExactly(1, 2, 4, 3, 6, 8, 7, 5);
  }

  @Test
  void inorderIterative() {
    TreeNode root = createTestTree();

    List<Integer> expected = new ArrayList<>();
    BinaryTreeTraversal.inorderIterative(root, expected);

    assertThat(expected).containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
  }

  @Test
  void preorderIterative() {
    TreeNode root = createTestTree();

    List<Integer> expected = new ArrayList<>();
    BinaryTreeTraversal.preorderIterative(root, expected);

    assertThat(expected).containsExactly(5, 3, 2, 1, 4, 7, 6, 8);
  }

  @Test
  void postorderIterative2Stacks() {
    TreeNode root = createTestTree();

    List<Integer> expected = new ArrayList<>();
    BinaryTreeTraversal.postorderIterative2Stacks(root, expected);

    assertThat(expected).containsExactly(1, 2, 4, 3, 6, 8, 7, 5);
  }

  @Test
  void postorderIterative1Stack() {
    TreeNode root = createTestTree();

    List<Integer> expected = new ArrayList<>();
    BinaryTreeTraversal.postorderIterative1Stack(root, expected);

    assertThat(expected).containsExactly(1, 2, 4, 3, 6, 8, 7, 5);
  }

  @Test
  void bfs() {
    TreeNode root = createTestTree();

    List<Integer> expected = new ArrayList<>();
    BinaryTreeTraversal.bfs(root, expected);

    assertThat(expected).containsExactly(5, 3, 7, 2, 4, 6, 8, 1);
  }

  @Test
  void bfsByLevels() {
    TreeNode root = createTestTree();

    List<List<Integer>> expected = new ArrayList<>();
    BinaryTreeTraversal.bfsByLevels(root, expected);

    assertThat(expected).containsExactly(
        asList(5),
        asList(3, 7),
        asList(2, 4, 6, 8),
        asList(1));
  }
}
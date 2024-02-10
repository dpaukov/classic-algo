package org.paukov.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {

  /*================ Recursive traversals ===================*/

  static void inorder(TreeNode root, List<Integer> output) {
    if (root == null) {
      return;
    }
    inorder(root.left, output);
    output.add(root.val);
    inorder(root.right, output);
  }

  static void preorder(TreeNode root, List<Integer> output) {
    if (root == null) {
      return;
    }
    output.add(root.val);
    preorder(root.left, output);
    preorder(root.right, output);
  }

  static void postorder(TreeNode root, List<Integer> output) {
    if (root == null) {
      return;
    }
    postorder(root.left, output);
    postorder(root.right, output);
    output.add(root.val);
  }

  /*================ Iterative traversals ===================*/

  static void bfs(TreeNode root, List<Integer> output) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll(); // Retrieves and removes the head from the queue.
      output.add(node.val);
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
  }

  static void bfsByLevels(TreeNode root, List<List<Integer>> output) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll(); // Retrieves and removes the head from the queue.
        level.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      output.add(level);
    }
  }

  static void inorderIterative(TreeNode root, List<Integer> output) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;

    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      output.add(node.val);
      node = node.right;
    }
  }

  static void preorderIterative(TreeNode root, List<Integer> output) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      output.add(node.val);
      // We need to put the right node first to the stack so the left node
      // will be on the top of the stack.
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
  }

  static void postorderIterative2Stacks(TreeNode root, List<Integer> output) {
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(root);

    while (!stack1.isEmpty()) {
      TreeNode node = stack1.pop();
      stack2.push(node);
      if (node.left != null) {
        stack1.push(node.left);
      }
      if (node.right != null) {
        stack1.push(node.right);
      }
    }

    // the second stack contains the result in the reverse order.
    while (!stack2.isEmpty()) {
      output.add(stack2.pop().val);
    }
  }

  // https://www.youtube.com/watch?v=xLQKdq0Ffjg
  static void postorderIterative1Stack(TreeNode root, List<Integer> output) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (!stack.isEmpty() || current != null) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      if (stack.peek().right != null) {
        current = stack.peek().right;
        continue;
      }

      TreeNode node = stack.pop();
      output.add(node.val);

      while (!stack.isEmpty() && node == stack.peek().right) {
        node = stack.pop();
        output.add(node.val);
      }
    }
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}

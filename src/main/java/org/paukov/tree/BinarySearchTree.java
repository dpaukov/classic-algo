package org.paukov.tree;

import java.util.Objects;

/**
 * Simple implementation of an unbalanced binary search tree (BST) map.
 */
public class BinarySearchTree {

  private Node root = null;

  public void add(Integer key, Integer value) {
    root = add(key, value, root, null);
  }

  public Integer search(Integer key) {
    Node node = search(root, key);
    if (node == null) {
      return null;
    }
    return node.value;
  }

  private Node add(Integer key, Integer value, Node node, Node parent) {
    if (node == null) {
      return new Node(key, value, null, null, parent);
    }

    if (Objects.equals(node.key, key)){
      node.value = value; // update the existing value
      return node;
    }

    if (key < node.key) {
      node.left = add(key, value, node.left, node);
    } else  {
      node.right = add(key, value, node.right, node);
    }
    return node;
  }

  private Node search(Node node, Integer key) {
    if (node == null || node.key.equals(key)) {
      return node;
    }
    if (key < node.key) {
      return search(node.left, key);
    } else {
      return search(node.right, key);
    }
  }

  private static class Node {

    Integer key;
    Integer value;
    Node left;
    Node right;
    Node parent;

    public Node(Integer key, Integer value, Node left, Node right, Node parent) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }
  }
}

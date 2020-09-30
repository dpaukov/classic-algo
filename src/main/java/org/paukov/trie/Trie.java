package org.paukov.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 208. Implement Trie (Prefix Tree) (Medium).
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {

  Node root = new Node((char) 0);

  public void insert(String word) {
    if (word == null || word.isEmpty()) {
      return;
    }
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char key = word.charAt(i);
      Node child = node.getChild(key);
      if (child == null) {
        child = new Node(key);
      }
      node.setChild(key, child);
      node = child;
    }
    node.end = true;
  }

  public boolean search(String word) {
    if (word == null || word.isEmpty()) {
      return false;
    }
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char key = word.charAt(i);
      Node child = node.getChild(key);
      if (child == null) {
        return false;
      }
      node = child;
    }

    return node.end;
  }

  public boolean startsWith(String prefix) {
    if (prefix==null || prefix.isEmpty()){
      return false;
    }
    Node node = root;
    for (int i=0; i<prefix.length(); i++){
      char key = prefix.charAt(i);
      Node child = node.getChild(key);
      if (child == null){
        return false;
      }
      node = child;
    }
    return true;
  }

  /**
   * Returns all string that starts from a specific prefix in this trie.
   */
  public List<String> listStartsWith(String prefix) {
    if (prefix == null || prefix.isEmpty()) {
      return toList(root);
    }
    List<String> result = new ArrayList<>();

    Node node = root;
    for (int i = 0; i < prefix.length(); i++) {
      char key = prefix.charAt(i);
      Node child = node.getChild(key);
      if (child == null) {
        return result; //empty
      }
      node = child;
    }

    List<String> suffixes = toList(node);
    String pre = prefix.substring(0, prefix.length() - 1);
    for (String s : suffixes) {
      result.add(pre + s);
    }
    return result;
  }

  List<String> toList(Node node) {
    List<String> result = new ArrayList<>();
    for (Node child : node.children) {
      if (child != null) {
        List<String> suffixes = toList(child);
        for (String s : suffixes) {
          result.add((node != root ? node.key : "") + s);
        }
      }
    }
    if (node.end) {
      result.add("" + node.key);
    }
    return result;
  }

  static class Node {

    char key;
    Node[] children = new Node[128];
    boolean end = false;

    Node(char key) {
      this.key = key;
    }

    void setChild(char key, Node node) {
      children[key] = node;
    }

    Node getChild(char key) {
      return children[key];
    }
  }
}

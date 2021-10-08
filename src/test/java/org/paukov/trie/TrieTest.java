package org.paukov.trie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TrieTest {

  @Test
  void test() {
    Trie trie = new Trie();
    trie.insert("apple");
    assertThat(trie.search("apple")).isTrue();
    assertThat(trie.search("app")).isFalse();
    assertThat(trie.startsWith("app")).isTrue();

    trie.insert("app");

    assertThat(trie.search("app")).isTrue();
  }

  @Test
  void test_listStartWith() {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("applegood");
    trie.insert("app");
    trie.insert("apb");
    trie.insert("hello");
    assertThat(trie.listStartsWith("app")).containsExactly("applegood", "apple", "app");
  }

  @Test
  void test_listStartWith_empty_prefix() {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("applegood");
    trie.insert("app");
    trie.insert("apb");
    trie.insert("hello");
    assertThat(trie.listStartsWith(""))
        .containsExactly("apb", "applegood", "apple", "app", "hello");
  }

  @Test
  void test_listStartWith_no_strings() {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("applegood");
    trie.insert("app");
    trie.insert("apb");
    trie.insert("hello");
    assertThat(trie.listStartsWith("ab")).isEmpty();
  }
}
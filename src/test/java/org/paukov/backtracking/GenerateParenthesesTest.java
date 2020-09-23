package org.paukov.backtracking;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class GenerateParenthesesTest {

  @Test
  void of_0() {
    List<String> result = GenerateParentheses.of(0);
    assertThat(result).containsExactly("");
  }

  @Test
  void of_1() {
    List<String> result = GenerateParentheses.of(1);
    assertThat(result).containsExactly("()");
  }

  @Test
  void of_3() {
    List<String> result = GenerateParentheses.of(3);
    assertThat(result).containsExactly("((()))", "(()())", "(())()", "()(())", "()()()");
  }
}
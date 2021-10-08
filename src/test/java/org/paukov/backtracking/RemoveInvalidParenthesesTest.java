package org.paukov.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.Test;

class RemoveInvalidParenthesesTest {

  @Test
  void of_1() {
    Set<String> result = RemoveInvalidParentheses.of("()())()");
    assertThat(result).containsOnly("()()()", "(())()");
  }

  @Test
  void of_2() {
    Set<String> result = RemoveInvalidParentheses.of("(a)())()");
    assertThat(result).containsOnly("(a)()()", "(a())()");
  }

  @Test
  void of_3() {
    Set<String> result = RemoveInvalidParentheses.of(")(");
    assertThat(result).containsOnly("");
  }
}
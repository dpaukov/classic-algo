package org.paukov.backtracking;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LetterCombinationsPhoneNumberTest {

  @Test
  void of() {
    List<String> result = LetterCombinationsPhoneNumber.of("23");
    assertThat(result).containsExactly("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
  }
}
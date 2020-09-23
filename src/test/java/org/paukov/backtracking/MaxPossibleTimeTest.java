package org.paukov.backtracking;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MaxPossibleTimeTest {

  @Test
  void of_1925() {
    String result = MaxPossibleTime.of(Arrays.asList(1, 9, 2, 5));
    assertThat(result).isEqualTo("21:59");
  }

  @Test
  void of_1122() {
    String result = MaxPossibleTime.of(Arrays.asList(1, 1, 2, 2));
    assertThat(result).isEqualTo("22:11");
  }

  @Test
  void of_null() {
    String result = MaxPossibleTime.of(Arrays.asList(8, 9, 4, 5));
    assertThat(result).isNull();
  }
}
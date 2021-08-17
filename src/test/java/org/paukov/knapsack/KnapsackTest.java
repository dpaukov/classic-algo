package org.paukov.knapsack;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.paukov.knapsack.Knapsack.StringItem;

class KnapsackTest {

  @Test
  void getBestSelection() {
    StringItem[] items = new StringItem[]{
        new StringItem("red", 5, 60),
        new StringItem("green", 3, 50),
        new StringItem("blue", 4, 70),
        new StringItem("yellow", 2, 30),
        new StringItem("white", 1, 10),
    };
    Knapsack<StringItem, String> knapsack = new Knapsack<>(items, 7);

    List<StringItem> result = knapsack.getBestSelection();

    assertThat(result).containsExactly(items[2], items[1]);
  }
}
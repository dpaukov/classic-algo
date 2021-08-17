package org.paukov.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for resolving 0/1 knapsack problems.
 * <p>
 * https://en.wikipedia.org/wiki/Knapsack_problem
 */
public class Knapsack<O extends Knapsack.Item<T>, T> {

  O[] items;
  int capacity;

  public Knapsack(O[] objects, int capacity) {
    this.items = objects;
    this.capacity = capacity;
  }

  public List<O> getBestSelection() {
    // Value matrix
    int[][] value = new int[items.length + 1][capacity + 1];

    // Selected items matrix
    boolean[][] isSelected = new boolean[items.length + 1][capacity + 1];

    for (int i = 0; i <= items.length; i++) {
      for (int j = 0; j <= capacity; j++) {
        if (i == 0 || j == 0) {
          value[i][j] = 0;
        } else {
          if (items[i - 1].weight <= j) {
            int withoutCurrentItem = value[i - 1][j];
            int withCurrentItem = value[i - 1][j - items[i - 1].weight] + items[i - 1].value;
            if (withCurrentItem >= withoutCurrentItem) {
              value[i][j] = withCurrentItem;
              isSelected[i][j] = true;
            } else {
              value[i][j] = withoutCurrentItem;
              isSelected[i][j] = false;
            }
          } else {
            value[i][j] = value[i - 1][j];
            isSelected[i][j] = false;
          }
        }

      }
    }

    // Tracking back to find the selected items
    List<O> result = new ArrayList<>();
    int t = capacity;
    int k = items.length;
    while (t >= 0 && k >= 0) {
      if (isSelected[k][t]) {
        result.add(items[k - 1]);
        t = t - items[k - 1].weight;
      }
      k--;
    }
    return result;
  }

  static class Item<T> {

    T object;
    int weight;
    int value;

    public Item(T object, int weight, int value) {
      this.object = object;
      this.weight = weight;
      this.value = value;
    }

    @Override
    public String toString() {
      return "(" + object.toString() + ", w=" + weight + ", v=" + value + ")";
    }
  }

  static class StringItem extends Item<String> {

    StringItem(String object, int weight, int value) {
      super(object, weight, value);
    }
  }
}

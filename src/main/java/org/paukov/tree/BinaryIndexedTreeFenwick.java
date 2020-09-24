package org.paukov.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * General Binary Indexed Tree (Fenwick Tree) for calculating prefix/range cumulative operations in
 * O(logn) time complexity. Memory: O(n).
 * <p>
 * https://www.topcoder.com/community/competitive-programming/tutorials/binary-indexed-trees/
 * https://cp-algorithms.com/data_structures/fenwick.html
 *
 * @param <T> Type of the elements
 */
public class BinaryIndexedTreeFenwick<T> {

  private final ArrayList<T> array;
  private final int size;
  private final BinaryOperator<T> addOperator;

  private BinaryIndexedTreeFenwick(List<T> input,
      BinaryOperator<T> addOperator) {
    this.size = input.size();
    this.array = new ArrayList<>(size + 2);
    this.addOperator = addOperator;
    for (int i = 0; i < size + 2; i++) {
      array.add(null);
    }
    for (int i = 0; i < size; i++) {
      add(i, input.get(i));
    }
  }

  public static <T> BinaryIndexedTreeFenwick<T> of(List<T> input, BinaryOperator<T> addOperator) {
    return new BinaryIndexedTreeFenwick<>(input, addOperator);
  }

  /**
   * Creates a binary indexed tree for integer numbers.
   */
  public static BinaryIndexedTreeFenwick<Integer> createIntSumBIT(List<Integer> input) {
    return of(input, (a, b) -> {
      if (a == null && b == null) {
        return null;
      }
      if (a == null) {
        return b;
      }
      if (b == null) {
        return a;
      }
      return a + b;
    });
  }

  // Returns cumulative sum up in the range from 0 to i.
  public T queryCumulative(int pos) {
    int i = pos + 1;
    T result = null;
    while (i > 0) {
      result = addOperator.apply(result, array.get(i));
      i -= i & (-i);
    }
    return result;
  }

  // Adds value to a position i.
  public void add(int pos, T value) {
    int i = pos + 1;
    while (i <= size + 1) {
      array.set(i, addOperator.apply(array.get(i), value));
      i += i & (-i);
    }
  }
}

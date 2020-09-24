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
  private final BinaryOperator<T> binaryOperator;

  private BinaryIndexedTreeFenwick(List<T> input,
      BinaryOperator<T> binaryOperator) {
    this.size = input.size();
    this.array = new ArrayList<>(size + 2); // use indexing from 1. o element is ignored.
    this.binaryOperator = binaryOperator;
    for (int i = 0; i < size + 2; i++) {
      array.add(null);
    }
    for (int i = 0; i < size; i++) {
      add(i, input.get(i));
    }
  }

  /**
   * Creates a BIT and applies the specified binary operation. If you want an arbitrary range query
   * (from any i to any j) be supported you should use invertible operations like addition or
   * multiplication. Min/max can only support the original cumulative BIT query from 0 to i, not
   * range minimum queries (RMQ).
   * <p>
   * Details: https://stackoverflow.com/questions/31106459/how-to-adapt-fenwick-tree-to-answer-range-minimum-queries
   */
  public static <T> BinaryIndexedTreeFenwick<T> of(List<T> input,
      BinaryOperator<T> binaryOperator) {
    return new BinaryIndexedTreeFenwick<>(input, binaryOperator);
  }

  /**
   * Creates a binary indexed tree for SUM of the integer numbers.
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

  /**
   * Creates a binary indexed tree for Prefix MIN of the integer numbers. This tree does not support
   * range minimum queries (RMQ).
   */
  public static BinaryIndexedTreeFenwick<Integer> createPrefixMinBIT(List<Integer> input) {
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
      return Math.min(a, b);
    });
  }

  // Returns cumulative result up in the range from 0 to i.
  public T queryCumulative(int pos) {
    int i = pos + 1;
    T result = null;
    while (i > 0) {
      result = binaryOperator.apply(result, array.get(i));
      i -= i & (-i);
    }
    return result;
  }

  // Adds value to a position i.
  public void add(int pos, T value) {
    int i = pos + 1;
    while (i <= size + 1) {
      array.set(i, binaryOperator.apply(array.get(i), value));
      i += i & (-i);
    }
  }
}

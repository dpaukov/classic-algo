package org.paukov.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * General Segment Tree that updates and queries the data with log(n) time complexity.
 * Details: https://en.wikipedia.org/wiki/Segment_tree
 *          https://cp-algorithms.com/data_structures/segment_tree.html
 *
 * @param <T> Type of the elements.
 */
public class SegmentTree<T> {

  private final int size;
  private final ArrayList<T> array;
  private final BinaryOperator<T> operator;

  private SegmentTree(List<T> input, BinaryOperator<T> operator) {
    this.size = input.size();
    this.array = new ArrayList<>(size * 3);
    for (int i = 0; i < size * 3; i++) {
      array.add(null);
    }
    this.operator = operator;
    build(1, input, 0, size - 1);
  }

  /**
   * Creates a segment tree from the specified list using provided operation. The operation should
   * handle null values.
   */
  public static <T> SegmentTree<T> of(List<T> list, BinaryOperator<T> operator) {
    return new SegmentTree<>(list, operator);
  }

  /**
   * Creates a segment tree that stores integer values and let query sum of the elements int a
   * specific range.
   */
  public static SegmentTree<Integer> createIntSumTree(List<Integer> list) {
    return SegmentTree.of(list, (a, b) -> {
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
   * Creates a segment tree that stores integer values and let query minimum of the elements int a
   * specific range.
   */
  public static SegmentTree<Integer> createIntMinTree(List<Integer> list) {
    return SegmentTree.of(list, (a, b) -> {
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

  /**
   * Creates a segment tree that stores integer values and let query maximum of the elements int a
   * specific range.
   */
  public static SegmentTree<Integer> createIntMaxTree(List<Integer> list) {
    return SegmentTree.of(list, (a, b) -> {
      if (a == null && b == null) {
        return null;
      }
      if (a == null) {
        return b;
      }
      if (b == null) {
        return a;
      }
      return Math.max(a, b);
    });
  }

  /**
   * Updates an element in the tree with log(n) time complexity;
   *
   * @param pos   The position of the element to be updated. It should be withing the size of the
   *              original list.
   * @param value New value of the element;
   */
  public void update(int pos, T value) {
    update(1, 0, size - 1, pos, value);
  }

  /**
   * Returns an operation specific result from the tree for a given range.
   */
  public T queryRange(int start, int end) {
    return query(1, 0, size - 1, start, end);
  }

  private void build(int node, List<T> input, int l, int r) {
    if (l > r) {
      return;
    }
    if (l == r) {
      array.set(node, input.get(l));
      return;
    }
    int mid = (r + l) / 2;
    int left = node * 2;
    int right = left + 1;
    build(left, input, l, mid);
    build(right, input, mid + 1, r);
    T result = operator.apply(array.get(left), array.get(right));
    array.set(node, result);
  }

  private T query(int node, int l, int r, int start, int end) {
    if (start > end) {
      return null;
    }
    if (l == start && r == end) {
      return array.get(node);
    }
    int mid = (l + r) / 2;
    int left = node * 2;
    int right = left + 1;

    return operator.apply(
        query(left, l, mid, start, Math.min(end, mid)),
        query(right, mid + 1, r, Math.max(start, mid + 1), end)
    );
  }

  private void update(int node, int l, int r, int pos, T newValue) {
    if (l > r) {
      return;
    }
    if (l == r) {
      array.set(node, newValue);
      return;
    }
    int mid = (r + l) / 2;
    int left = node * 2;
    int right = left + 1;
    if (pos <= mid) {
      update(left, l, mid, pos, newValue);
    } else {
      update(right, mid + 1, r, pos, newValue);
    }
    T result = operator.apply(array.get(left), array.get(right));
    array.set(node, result);
  }
}

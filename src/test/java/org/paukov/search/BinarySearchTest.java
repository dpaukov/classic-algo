package org.paukov.search;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public final class BinarySearchTest {

  @Test
  void exactIndex_4_of_6() {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6};
    int index = BinarySearch.exactIndex(arr, 4);
    assertThat(index).isEqualTo(3);
  }

  @Test
  void exactIndex_4_of_5() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int index = BinarySearch.exactIndex(arr, 4);
    assertThat(index).isEqualTo(3);
  }

  @Test
  void exactIndex_2_of_5() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int index = BinarySearch.exactIndex(arr, 2);
    assertThat(index).isEqualTo(1);
  }

  @Test
  void exactIndex_insert_new_value_6() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int index = BinarySearch.exactIndex(arr, 6);
    assertThat(index).isEqualTo(arr.length); // index, where the value 6 should be inserted
  }

  @Test
  void exactIndex_insert_empty_new_value_6() {
    int[] arr = new int[]{};
    int index = BinarySearch.exactIndex(arr, 6);
    assertThat(index).isEqualTo(arr.length); // index, where the value 6 should be inserted
  }

  @Test
  void exactIndex_insert_new_value_35() {
    int[] arr = new int[]{10, 20, 30, 40, 50};
    int index = BinarySearch.exactIndex(arr, 35);
    assertThat(index).isEqualTo(3); // index, where the value 35 should be inserted
  }

  @Test
  void exactIndex_insert_new_value_5() {
    int[] arr = new int[]{10, 20, 30, 40, 50};
    int index = BinarySearch.exactIndex(arr, 5);
    assertThat(index).isEqualTo(0); // index, where the value 5 should be inserted
  }

  @Test
  void exactIndex_4_of_6_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6};
    int index = BinarySearch.exactIndex(arr, 4);
    assertThat(index).isEqualTo(8); // first occur of the value 4
  }

  @Test
  void exactIndex_4_of_5_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6};
    int index = BinarySearch.exactIndex(arr, 4);
    assertThat(index).isEqualTo(7); // first occur of the value 4
  }

  @Test
  void exactIndex_2_of_5_with_duplicates() {
    int[] arr = new int[]{1, 1, 1, 1, 1, 2, 3, 3, 3, 4, 5};
    int index = BinarySearch.exactIndex(arr, 2);
    assertThat(index).isEqualTo(5); // first occur of the value 2
  }

  @Test
  void exactIndex_insert_new_value_6_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5};
    int index = BinarySearch.exactIndex(arr, 6);
    assertThat(index).isEqualTo(arr.length); // index, where the value 6 should be inserted
  }

  @Test
  void exactIndex_insert_new_value_35_with_duplicates() {
    int[] arr = new int[]{10, 10, 20, 20, 20, 30, 30, 40, 40, 50, 50};
    int index = BinarySearch.exactIndex(arr, 35);
    assertThat(index).isEqualTo(7); // index, where the value 35 should be inserted
  }

  @Test
  void exactIndex_insert_new_value_29_with_duplicates() {
    int[] arr = new int[]{10, 10, 20, 20, 20, 30, 30, 40, 40, 50, 50};
    int index = BinarySearch.exactIndex(arr, 29);
    assertThat(index).isEqualTo(5); // index, where the value 35 should be inserted
  }

  @Test
  void exactIndex_insert_new_value_5_with_duplicates() {
    int[] arr = new int[]{10, 10, 15, 20, 20, 30, 30, 40, 50};
    int index = BinarySearch.exactIndex(arr, 5);
    assertThat(index).isEqualTo(0); // index, where the value 5 should be inserted
  }

  /////////////

  @Test
  void indexRightMost_4_of_6() {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6};
    int index = BinarySearch.indexRightMost(arr, 4);
    assertThat(index).isEqualTo(3);
  }

  @Test
  void indexRightMost_4_of_5() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int index = BinarySearch.indexRightMost(arr, 4);
    assertThat(index).isEqualTo(3);
  }

  @Test
  void indexRightMost_2_of_5() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int index = BinarySearch.indexRightMost(arr, 2);
    assertThat(index).isEqualTo(1);
  }

  @Test
  void indexRightMost_insert_new_value_6() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int index = BinarySearch.indexRightMost(arr, 6);
    assertThat(index)
        .isEqualTo(arr.length - 1); // the prev index, where the value 6 should be inserted
  }

  @Test
  void indexRightMost_insert_empty_new_value_6() {
    int[] arr = new int[]{};
    int index = BinarySearch.indexRightMost(arr, 6);
    assertThat(index)
        .isEqualTo(arr.length - 1); // the prev index, where the value 6 should be inserted
  }

  @Test
  void indexRightMost_insert_new_value_35() {
    int[] arr = new int[]{10, 20, 30, 40, 50};
    int index = BinarySearch.indexRightMost(arr, 35);
    assertThat(index).isEqualTo(2); // the prev index, where the value 35 should be inserted
  }

  @Test
  void indexRightMost_insert_new_value_5() {
    int[] arr = new int[]{10, 20, 30, 40, 50};
    int index = BinarySearch.indexRightMost(arr, 5);
    assertThat(index).isEqualTo(-1); // the prev index, where the value 5 should be inserted
  }

  @Test
  void indexRightMost_4_of_6_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6};
    int index = BinarySearch.indexRightMost(arr, 4);
    assertThat(index).isEqualTo(10); // last occur of the value 4
  }

  @Test
  void indexRightMost_4_of_5_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6};
    int index = BinarySearch.indexRightMost(arr, 4);
    assertThat(index).isEqualTo(9); // last occur of the value 4
  }

  @Test
  void indexRightMost_last_6_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6};
    int index = BinarySearch.indexRightMost(arr, 6);
    assertThat(index).isEqualTo(14); // last occur of the value 6
  }

  @Test
  void indexRightMost_2_of_5_with_duplicates() {
    int[] arr = new int[]{1, 1, 1, 1, 1, 2, 3, 3, 3, 4, 5};
    int index = BinarySearch.indexRightMost(arr, 2);
    assertThat(index).isEqualTo(5); // last occur of the value 2
  }

  @Test
  void indexRightMost_insert_new_value_6_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5};
    int index = BinarySearch.indexRightMost(arr, 6);
    assertThat(index)
        .isEqualTo(arr.length - 1); // the prev index, where the value 6 should be inserted
  }

  @Test
  void indexRightMost_insert_new_value_35_with_duplicates() {
    int[] arr = new int[]{10, 10, 20, 20, 20, 30, 30, 40, 40, 50, 50};
    int index = BinarySearch.indexRightMost(arr, 35);
    assertThat(index).isEqualTo(6); // the prev index, where the value 35 should be inserted
  }

  @Test
  void indexRightMost_insert_new_value_29_with_duplicates() {
    int[] arr = new int[]{10, 10, 20, 20, 20, 30, 30, 40, 40, 50, 50};
    int index = BinarySearch.indexRightMost(arr, 29);
    assertThat(index).isEqualTo(4); // the prev index, where the value 29 should be inserted
  }

  @Test
  void indexRightMost_insert_new_value_5_with_duplicates() {
    int[] arr = new int[]{10, 10, 15, 20, 20, 30, 30, 40, 50};
    int index = BinarySearch.indexRightMost(arr, 5);
    assertThat(index).isEqualTo(-1); // the prev index, where the value 5 should be inserted
  }

  //////////////

  @Test
  void exactIndexIfFound_4_of_6() {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6};
    int index = BinarySearch.indexIfFound(arr, 4);
    assertThat(index).isEqualTo(3);
  }

  @Test
  void exactIndexIfFound_4_of_5() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int index = BinarySearch.indexIfFound(arr, 4);
    assertThat(index).isEqualTo(3);
  }

  @Test
  void exactIndexIfFound_2_of_5() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int index = BinarySearch.indexIfFound(arr, 2);
    assertThat(index).isEqualTo(1);
  }

  @Test
  void exactIndexIfFound_insert_new_value_6() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int index = BinarySearch.indexIfFound(arr, 6);
    assertThat(index).isEqualTo(-1); // not found
  }

  @Test
  void exactIndexIfFound_empty_new_value_6() {
    int[] arr = new int[]{};
    int index = BinarySearch.indexIfFound(arr, 6);
    assertThat(index).isEqualTo(-1); // not found
  }

  @Test
  void exactIndexIfFound_insert_new_value_35() {
    int[] arr = new int[]{10, 20, 30, 40, 50};
    int index = BinarySearch.indexIfFound(arr, 35);
    assertThat(index).isEqualTo(-1); // not found
  }

  @Test
  void exactIndexIfFound_insert_new_value_5() {
    int[] arr = new int[]{10, 20, 30, 40, 50};
    int index = BinarySearch.indexIfFound(arr, 5);
    assertThat(index).isEqualTo(-1); // not found
  }

  @Test
  void exactIndexIfFound_4_of_6_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6};
    int index = BinarySearch.indexIfFound(arr, 4);
    assertThat(index).isEqualTo(8); // first occur of the value 4
  }

  @Test
  void exactIndexIfFound_4_of_5_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6};
    int index = BinarySearch.indexIfFound(arr, 4);
    assertThat(index).isEqualTo(7); // first occur of the value 4
  }

  @Test
  void exactIndexIfFound_2_of_5_with_duplicates() {
    int[] arr = new int[]{1, 1, 1, 1, 1, 2, 3, 3, 3, 4, 5};
    int index = BinarySearch.indexIfFound(arr, 2);
    assertThat(index).isEqualTo(5); // first occur of the value 2
  }

  @Test
  void exactIndexIfFound_insert_new_value_6_with_duplicates() {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5};
    int index = BinarySearch.indexIfFound(arr, 6);
    assertThat(index).isEqualTo(-1); // not found
  }

  @Test
  void exactIndexIfFound_insert_new_value_35_with_duplicates() {
    int[] arr = new int[]{10, 10, 20, 20, 20, 30, 30, 40, 40, 50, 50};
    int index = BinarySearch.indexIfFound(arr, 35);
    assertThat(index).isEqualTo(-1); // not found
  }

  @Test
  void exactIndexIfFound_insert_new_value_29_with_duplicates() {
    int[] arr = new int[]{10, 10, 20, 20, 20, 30, 30, 40, 40, 50, 50};
    int index = BinarySearch.indexIfFound(arr, 29);
    assertThat(index).isEqualTo(-1); // not found
  }

  @Test
  void exactIndexIfFound_insert_new_value_5_with_duplicates() {
    int[] arr = new int[]{10, 10, 15, 20, 20, 30, 30, 40, 50};
    int index = BinarySearch.indexIfFound(arr, 5);
    assertThat(index).isEqualTo(-1); // not found
  }
}
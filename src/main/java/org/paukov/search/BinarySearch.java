package org.paukov.search;

/**
 * This class demonstrates the binary search algorithms:
 *  - To find exact position of an element (even if it is absent).
 *  - To find right most index.
 *  - To find left most index.
 */
public class BinarySearch {

  // Returns the first occurrence of the target in the array, if it is present.
  // If the target is not present, it returns the position where the value can be inserted.
  public static int exactIndex(int[] arr, int target) {
    int lo = 0;
    int hi = arr.length;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (arr[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo;
  }

  // Returns the last occurrence of the target (right most index) in the array, if it is present.
  // If the target is not present, it returns the previous position where the value should be inserted.
  public static int indexRightMost(int[] arr, int target) {
    int lo = 0;
    int hi = arr.length;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (arr[mid] <= target) { // !difference from the exactIndex: less or equal.
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return hi - 1; // !difference from the exactIndex: return (hi-1) instead of lo.
  }

  // returns the first occurrence of the target (left most index) in the array, if it is present.
  // If the target is not present, it returns -1;
  public static int indexIfFound(int[] arr, int target) {
    int lo = 0;
    int hi = arr.length - 1; // !difference from the exactIndex: (length-1) instead of length.
    while (lo <= hi) { // !difference from the exactIndex: less or equal.
      int mid = lo + (hi - lo) / 2;
      if (arr[mid] == target) { // !difference: mid equal to target.
        return mid; // !difference: if found return mid;
      }
      if (arr[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid - 1; // !difference from the exactIndex: (mid-1) instead of mid.
      }
    }
    return -1; // !difference: not found return -1;
  }
}

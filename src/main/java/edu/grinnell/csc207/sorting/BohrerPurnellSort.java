package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using my own sorting algorithm.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Myles Bohrer-Purnell
 * @author ChatGPT
 */

public class BohrerPurnellSort<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered
   *   after sorting.
   */
  public BohrerPurnellSort(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**  Size of the run to be used for insertion sort. */
  private static final int RUN = 32;

  /**
   * Helper method to use insertion sort on an array.
   * @param arr starting array.
   * @param left left bound.
   * @param right right bound.
   */
  private void insertionSort(T[] arr, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      T key = arr[i];
      int j = i - 1;
      while (j >= left && this.order.compare(arr[j], key) > 0) {
        arr[j + 1] = arr[j];
        j--;
      } // while
      arr[j + 1] = key;
    } // for
  } // insertionSort()

  /**
   * Utility function to merge two subarrays arr[left...mid]
   * and arr[mid+1...right].
   * @param arr // starting array
   * @param left // left bound
   * @param mid // midpoint
   * @param right // right bound
   */
  private void merge(T[] arr, int left, int mid, int right) {
    // Find the sizes of two subarrays to be merged
    int len1 = mid - left + 1;
    int len2 = right - mid;

    // Create temporary arrays
    T[] leftArr = (T[]) new Object[len1];
    T[] rightArr = (T[]) new Object[len2];

    // Copy data to temp arrays
    System.arraycopy(arr, left, leftArr, 0, len1);
    System.arraycopy(arr, mid + 1, rightArr, 0, len2);

    // Merge the temp arrays back into the original array
    int i = 0;
    int j = 0;
    int k = left;
    while (i < len1 && j < len2) {
      if (this.order.compare(leftArr[i], rightArr[j]) <= 0) {
        arr[k] = leftArr[i];
        i++;
      } else {
        arr[k] = rightArr[j];
        j++;
      } // if/else
      k++;
    } // while

    // Copy the remaining elements of leftArr[], if any
    while (i < len1) {
      arr[k] = leftArr[i];
      i++;
      k++;
    } // while

    // Copy the remaining elements of rightArr[], if any
    while (j < len2) {
      arr[k] = rightArr[j];
      j++;
      k++;
    } // while
  } // merge()
  /**
   * Sort an array in place using Timesort.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 &lt; i &lt; values.length,
   *     order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    int n = values.length;

    // Step 1: Sort small chunks (runs) using insertion sort
    for (int i = 0; i < n; i += RUN) {
      insertionSort(values, i, Math.min(i + RUN - 1, n - 1));
    } // for

    // Step 2: Start merging runs
    for (int size = RUN; size < n; size = 2 * size) {
      // Merge runs in size 2*size
      for (int left = 0; left < n; left += 2 * size) {
        int mid = Math.min(n - 1, left + size - 1);
        int right = Math.min((left + 2 * size - 1), (n - 1));
        if (mid < right) {
          merge(values, left, mid, right);
        } // if
      } // for
    } // for
  } // sort(T[])
} // class Quicksorter

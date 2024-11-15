package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using merge sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 */

public class MergeSorter<T> implements Sorter<T> {
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
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Sorts the elements from two arrays into the original array.
   * @param values the original array.
   * @param leftHalf a sorted sub-array.
   * @param rightHalf a sorted sub-array.
   */
  public void mergeSort(T[] values, T[] leftHalf, T[] rightHalf) {
    int rightIndex = 0;
    int leftIndex = 0;
    int valIndex = 0;
    while (rightIndex < rightHalf.length || leftIndex < leftHalf.length) {
      if (rightIndex < rightHalf.length && leftIndex < leftHalf.length) {
        if (this.order.compare(leftHalf[leftIndex], rightHalf[rightIndex]) <= 0) {
          values[valIndex] = leftHalf[leftIndex];
          leftIndex++;
        } else {
          values[valIndex] = rightHalf[rightIndex];
          rightIndex++;
        } // if/else
      } else if (rightIndex >= rightHalf.length) {
        values[valIndex] = leftHalf[leftIndex];
        leftIndex++;
      } else {
        values[valIndex] = rightHalf[rightIndex];
        rightIndex++;
      } // if/else
      valIndex++;
    } // while
  } // mergeSort()

  /**
   * Sort an array in place using merge sort.
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
    if (values.length <= 1) {
      return;
    } // if
    int midpoint = values.length / 2;
    T[] leftHalf = (T[]) new Object[midpoint];
    T[] rightHalf = (T[]) new Object[values.length - midpoint];
    // create the right and left lists to sort
    for (int i = 0; i < midpoint; i++) {
      leftHalf[i] = values[i];
    } // for
    for (int i = midpoint; i < values.length; i++) {
      rightHalf[i - midpoint] = values[i];
    }
    sort(leftHalf);
    sort(rightHalf);

    mergeSort(values, leftHalf, rightHalf);
  } // sort(T[])
} // class MergeSorter

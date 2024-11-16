package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Random;

/**
 * Something that sorts using Quicksort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Myles Bohrer-Purnell
 */

public class Quicksorter<T> implements Sorter<T> {
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
  public Quicksorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Recursively quicksorts an array from a lower
   * bound to an upper bound of an array.
   * @param values // original array.
   * @param lb // lower bound of interest.
   * @param ub // upper bound of interest.
   */
  public void quicksort(T[] values, int lb, int ub) {
    if (ub - lb < 0) {
      return;
    } // if
    Random rand = new Random();
    int pivot = rand.nextInt(lb, ub + 1);
    T temp = values[lb];
    values[lb] = values[pivot];
    values[pivot] = temp;
    int i = lb + 1;
    int j = ub;
    while (i <= j) {
      if (this.order.compare(values[i], values[lb]) <= 0) {
        i++;
      } else if (this.order.compare(values[i], values[lb]) > 0) {
        temp = values[j];
        values[j] = values[i];
        values[i] = temp;
        j--;
      } // if/else
    } // while
    temp = values[j];
    values[j] = values[lb];
    values[lb] = temp;

    quicksort(values, lb, j - 1);
    quicksort(values, i, ub);
  } // quicksort

  /**
   * Sort an array in place using Quicksort.
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
    int ub = values.length - 1;
    int lb = 0;

    quicksort(values, lb, ub);
  } // sort(T[])
} // class Quicksorter

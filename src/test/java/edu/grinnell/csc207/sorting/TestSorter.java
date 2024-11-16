package edu.grinnell.csc207.sorting;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.util.ArrayUtils;

/**
 * Tests of Sorter objects. Please do not use this class directly.
 * Rather, you should subclass it and initialize stringSorter and
 * intSorter in a static @BeforeAll method.
 *
 * @author Myles Bohrer-Purnell
 * @uathor Samuel A. Rebelsky
 */
public class TestSorter {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  /**
   * The sorter we use to sort arrays of strings.
   */
  static Sorter<String> stringSorter = null;

  /**
   * The sorter we use to sort arrays of integers.
   */
  static Sorter<Integer> intSorter = null;

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Given a sorted array and a permutation of the array, sort the
   * permutation and assert that it equals the original.
   *
   * @param <T>
   *   The type of values in the array.
   * @param sorted
   *   The sorted array.
   * @param perm
   *   The permuted sorted array.
   * @param sorter
   *   The thing to use to sort.
   */
  public <T> void assertSorts(T[] sorted, T[] perm, Sorter<? super T> sorter) {
    T[] tmp = perm.clone();
    sorter.sort(perm);
    assertArrayEquals(sorted, perm,
      () -> String.format("sort(%s) yields %s rather than %s",
          Arrays.toString(tmp), 
          Arrays.toString(perm), 
          Arrays.toString(sorted)));
  } // assertSorts

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A fake test. I've forgotten why I've included this here. Probably
   * just to make sure that some test succeeds.
   */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  /**
   * Ensure that an array that is already in order gets sorted correctly.
   */
  @Test
  public void orderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that an array that is ordered backwards gets sorted correctly.
   */
  @Test
  public void reverseOrderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that a randomly permuted version of a moderate-sized
   * array sorts correctly.
   */
  @Test 
  public void permutedIntegersTest() { 
    int SIZE = 100; 
    if (null == intSorter) { 
      return; 
    } // if
    Integer[] original = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      original[i] = i;
    } // for
    Integer[] expected = original.clone();
    ArrayUtils.permute(original);
    assertSorts(expected, original, intSorter);
  } // permutedIntegers

  /**
   * Ensure that a one element array returns the same array.
   */
  @Test
  public void OneElementStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "foxtrot" };
    String[] expected = { "foxtrot" };
    assertSorts(expected, original, stringSorter);
  } // OneElementStringTest

  /**
   * Ensure that an array with all of the same elements sorts correctly.
   */
  @Test
  public void AllSameStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "a", "a", "a", "a", "a" };
    String[] expected = { "a", "a", "a", "a", "a" };
    assertSorts(expected, original, stringSorter);
  } // AllSameStringTest

  /**
   * Ensure that an array with all of the same elements sorts correctly.
   */
  @Test
  public void AllSameIntTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = { 1, 1, 1, 1, 1 };
    Integer[] expected = { 1, 1, 1, 1, 1 };
    assertSorts(expected, original, intSorter);
  } // AllSameIntTest

  /**
   * Ensure that an array with alternating ordering of larger-smaller
   * elements sorts correctly.
   */
  @Test
  public void AlternatingIntTest() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = { 10, 5, 11, 6, 12, 7, 13, 8, 14, 9, 15 };
    Integer[] expected = { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    assertSorts(expected, original, intSorter);
  } // AlternatingIntTest

  /**
   * Ensure that an array with two elements sorts correctly.
   */
  @Test
  public void TwoElementStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "b", "a" };
    String[] expected = { "a", "b" };
    assertSorts(expected, original, stringSorter);
  } // TwoElementStringTest
} // class TestSorter

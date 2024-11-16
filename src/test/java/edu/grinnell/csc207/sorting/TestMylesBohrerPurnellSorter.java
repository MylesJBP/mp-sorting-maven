package edu.grinnell.csc207.sorting;

import org.junit.jupiter.api.BeforeAll;

public class TestMylesBohrerPurnellSorter extends TestSorter{
  @BeforeAll
  static void setup() {
    stringSorter = new BohrerPurnellSort<String>((x,y) -> x.compareTo(y));
    intSorter = new BohrerPurnellSort<Integer>((x,y) -> x.compareTo(y));
  } // setup()
}

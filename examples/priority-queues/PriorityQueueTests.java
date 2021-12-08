/**
 * A generic set of priority queue tests (I hope).  Do not run these
 * tests directly.  Rather, subclass and implement setupInts and
 * setupStrings.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public abstract class PriorityQueueTests 
{
  /**
   * Create a priority queue of integers, using the standard ordering.
   */
  abstract PriorityQueue<Integer> ipq();

  /**
   * Create a priority queue of strings, using the standard ordering.
   */
  abstract PriorityQueue<String> spq();

  @Test
  void fakeTest()
  { 
    PriorityQueue<Integer> ints = ipq();
    assertEquals(1,1);
  } // fakeTest

  @Test
  void addOneElement()
  {
    PriorityQueue<Integer> ints = ipq();
    PriorityQueue<String> strs = spq();

    assertAll(() -> ints.add(5), 
              () -> strs.add("five"));
  } // addOneElement()

  @Test
  void trombones()
    throws Exception
  {
    PriorityQueue<Integer> instruments = ipq();
    instruments.add(76);
    assertEquals(instruments.peek(), 76);
    assertEquals(instruments.remove(), 76);
    assertTrue(instruments.isEmpty());
  } // trombones

  @Test
  void addToNonemptyPQ()
    throws Exception
  {
    PriorityQueue<Integer> numbers = ipq();
    numbers.add(5);
    numbers.add(100);
    assertEquals(numbers.peek(), 100);
    assertEquals(numbers.remove(), 100);
  } // addToNonempty
} // class PriorityQueueTests

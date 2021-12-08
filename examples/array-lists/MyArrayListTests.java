import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MyArrayListTests {
  @Test
  void testInvalidAddition() {
    ArrayList<String> a = new ArrayList<String>();
    assertThrows(IndexOutOfBoundsException.class,
                 () -> a.set(5, null));
  } // testInvalidAddition()
} // class MyArrayListTests


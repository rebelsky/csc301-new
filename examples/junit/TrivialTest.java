import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TrivialTest
{
  @Test
  void trivialTest()
  {
    System.err.println("trivialTest");
    assertTrue(false);
  } // trivialTest

  @Test
  void alternateTest()
  {
    assertTrue(true);
  } // alternateTest()
} // class TrivialTest


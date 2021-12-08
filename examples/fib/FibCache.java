import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Compute the nth Fibonacci number.
 */
public class FibCache implements Fib {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  ArrayList<BigInteger> cache = new ArrayList<BigInteger>(10);

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  // +---------------------+-----------------------------------------
  // | Implemented Methods |
  // +---------------------+

  public BigInteger fib(int n) {
    if (n <= 1) {
      return BigInteger.valueOf(n);
    } else {
      // Make sure that Fib is now big enough to hold element n.
      while (cache.size() < n+1) {
        cache.add(null);
      }
      // If the value is not already cached
      if ((n < cache.size()) && (cache.get(n) == null)) {
        // Compute and cache it
        cache.set(n, fib(n-1).add(fib(n-2)));
      }
      return cache.get(n);
    } 
  } // fib(n)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) {
    Fib.main(new FibCache(), args);
  } // main
} // class FibCache

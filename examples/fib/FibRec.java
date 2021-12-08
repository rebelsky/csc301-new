import java.math.BigInteger;

/**
 * Compute the nth Fibonacci number.
 */
public class FibRec implements Fib {

  // +---------------------+-----------------------------------------
  // | Implemented Methods |
  // +---------------------+

  public BigInteger fib(int n) {
    if (n <= 1) {
      return BigInteger.valueOf(n);
    } else {
      return fib(n-1).add(fib(n-2));
    }  
  } // fib(n)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) {
    Fib.main(new FibRec(), args);
  } // main
} // class FibRec

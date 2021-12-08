import java.math.BigInteger;

public class CSC301 {
  public static BigInteger fib(int n) {
    if (n <= 1) {
      return BigInteger.valueOf(n);
    } else {
      return fib(n-1).add(fib(n-2));
    }  
  } // fib(n)
} // class CSC301


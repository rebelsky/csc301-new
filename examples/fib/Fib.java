import java.math.BigInteger;

/**
 * Things that compute Fibonacci numbers.
 */
public interface Fib 
{
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public abstract BigInteger fib(int n);

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The number of repetitions we do to get an average.
   */
  static final int REPS = 1;

  // +----------------+----------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * A sample main.
   */
  public static void main(Fib f, String[] args) {
    long totalTime = 0;
    BigInteger result = BigInteger.ONE;
    f.fib(2);   // Hack; load code
    for (int i = 0; i < args.length; i++) {
      try {
        int n = Integer.parseInt(args[i]);
        long initiated = System.currentTimeMillis();
        for (int j = 0; j < REPS; j++) {
          result = f.fib(n);
        }
        long completed = System.currentTimeMillis();
        long elapsed = (completed - initiated)/REPS;
        System.out.println("fib(" + n + ") = " + result);
        System.out.println("  averaged " + elapsed + " milliseconds");
        totalTime += elapsed;
      } catch (Exception e) {
      }
    } // for
    System.out.println("Total computation: " + totalTime);
  } // main(String[])
} // interface Fib

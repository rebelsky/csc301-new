/**
 * Some "fun" examples of counting loops.
 */
public class LoopExamples {
  static int loopZero(int n) {
    int result = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        result += 1;
      } // for j
    } // for j
    return result;
  } // loopZero

  static int loopOne(int n) {
    int result = 0;
    for (int i = 1; i <= n; i *= 2) {
      for (int j = 1; j <= n; j++) {
        result += 1;
      } // for j
    } // for i
    return result;
  } // loopOne

  static int loopTwo(int n) {
    int result = 0;
    for (int i = 1; i <= n; i *= 2) {
      for (int j = 1; j <= i; j++) {
        result += 1;
      } // for j
    } // for i
    return result;
  } // loopTwo

  public static void main(String[] args) {
    int[] sizes = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 
                    160, 240, 320, 
                    330, 340, 350 };
    for (int size: sizes) {
      System.out.println(size + "," + loopZero(size));
    }
  } // main(String[])
} // LoopExamples


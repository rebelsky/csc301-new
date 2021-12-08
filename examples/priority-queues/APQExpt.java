/**
 * A quick and dirty experiment with APQs.
 */
public class APQExpt
{
  public static void main(String[] args) throws Exception {
    PriorityQueue<Integer> ints = new APQ<Integer>((x,y) -> x-y);
    // PriorityQueue<String> strs = new APQ<String>((x,y) -> x.compareTo(y));
    ints.add(5);
    ints.add(7);
    ints.add(5);
    ints.add(3);
    ints.add(-2);
  } // main(String[])
} // class APQExpt

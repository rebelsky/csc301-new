package csc301;

import java.util.Random;

/**
 * Experimenting with BSTs.
 * @author Samuel A. Rebelsky.
 */
public class BSTexperiments {
  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+

  /**
   * Print a separator (e.g., at the start or end of an experiment.
   */
  public static void separator() {
    System.out.println("---------------------------------------------");
  } // separator()

  /**
   * A quick exploration of StringInt trees.  Can we iterate them?
   * Do we get the kth elements?
   */
  public static void experiment01() {
    separator();
    System.out.println("Experiment 01: StringInt Trees");
    // Build the tree
    BST<String,Integer> bst1 = Utils301.randomStringIntTree(12);
    // Iterate the tree
    for (String key : bst1.keys()) {
      System.out.print(key + " ");
    }
    System.out.println();
    // Check the kth values
    for (int i = 0; i < bst1.size(); i++) {
      KVPair<String,Integer> pair = bst1.kthPair(i);
      System.out.println(i + ":" + pair.key() + ":" + pair.value());
    } // for
    // And we're done
    separator();
  } // experiment1()


  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) {
    experiment01();
  } // main(String[])

} // BSTexperiments

package csc301;

import java.util.Random;

/**
 * Analyzing BSTs.
 * @author Samuel A. Rebelsky.
 */
public class BSTanalyst {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) {
    System.out.println("size,height");
    for (int i = 0; i < 10; i++) {
      BST<String,Integer> bst = Utils301.randomStringIntTree(1024);
      System.out.println(bst.size() + "," + bst.height());
    } // for
  } // main(String[])

} // BSTanalyst

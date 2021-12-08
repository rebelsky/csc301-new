package csc301;

import java.util.Random;

/**
 * A quick and dirty experiment with Tries.
 */
public class TrieExpt {
  public static void main(String[] args) {
    Dict301<String,Integer> dict = new Trie301<Integer>();
    Random rand = new Random();

    for (int i = 0; i < args.length; i += 2) {
      String key = args[i+1];
      if (args[i].equals("s")) {
        int val = rand.nextInt();
        System.out.println("Setting " + key + " to " + val);
        dict.set(key,val);
      }
      else if (args[i].equals("g")) {
        System.out.println("Getting " + key + ": " + dict.get(key));
      }
      else {
        System.err.println("Invalid command: '" + args[i] + "'");
      }
    } //
  } // main
} // TrieExpt

package csc301;

import java.util.Random;

/**
 * Some assorted utility procedures.
 */
public class Utils301 {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  static Random rand = new Random();

  // +----------------+----------------------------------------------
  // | Misc Utilities |
  // +----------------+

  /**
   * Randomly select a letter from str.
   */
  static String randomLetter(String str) {
    int k = rand.nextInt(str.length());
    return str.substring(k, k+1);
  } // randomLetter(String)

  /**
   * Randomly select a vowel.
   */
  static String randomVowel() {
    return randomLetter("aeiou");
  } // randomVowel()

  /**
   * Randomly select a consonant.
   */
  static String randomConsonant() {
    return randomLetter("bcdfghjklmnpqrstvwxyz");
  } // randomConsonant()

  /**
   * Generate a "word" (mostly, something that looks pronouncable) of 
   * n letters.
   */
  static String randomWord(int n) {
    String result = "";
    while (n > 1) {
      result += randomConsonant() + randomVowel();
      n -= 2;
    } // while
    if (n == 1) {
      result += randomConsonant();
    }
    return result;
  } // randomWord(int)

  // +----------------+----------------------------------------------
  // | Tree Utilities |
  // +----------------+

  /**
   * Generate a tree of size approximately n with strings as keys.
   * (We might have some duplicate keys, so the size isn't guaranteed
   * to be n.)
   */
  static BST<String,Integer> randomStringIntTree(int n) {
    BST<String,Integer> result = 
      new BST<String,Integer>((s1,s2) -> s1.compareTo(s2));
    for (int i = 0; i < n; i++) {
      result.set(randomWord(8), rand.nextInt());
    } // result
    return result;
  } // randomStringIntTree(int)

  /**
   * Generate a tree of size approximately n with integers as keys.
   * We might have some duplicate keys, so the size isn't guaranteed
   * to be n.  In fact, this is designed so that we are likely to
   * have some duplicate keys.
   */
  static BST<Integer,String> randomIntStringTree(int n) {
    BST<Integer,String> result = 
      new BST<Integer,String>((s1,s2) -> s1.compareTo(s2));
    for (int i = 0; i < n; i++) {
      result.set(rand.nextInt(2*n), randomWord(6));
    } // result
    return result;
  } // randomStringIntTree(int)

} // class Utils301

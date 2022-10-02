package LeetCode;

import java.util.Arrays;

public class ValidAnagram_242 {

  public static void main(String args[]) {
    ValidAnagram_242 program = new ValidAnagram_242();

    // params
    String s = "anagram";
    String t = "nagaram";

    // execute
    boolean result_1 = program.isAnagram_1(s, t);
    boolean result_2 = program.isAnagram_2(s, t);

    // display
    System.out.println(result_1);
    System.out.println(result_2);
  }

  // time: O(N log N)
  // space: O(1)
  public boolean isAnagram_1(String s, String t) {
    if (s.length() != t.length())
      return false;

    char[] text1 = s.toCharArray();
    char[] text2 = t.toCharArray();
    Arrays.sort(text1);
    Arrays.sort(text2);

    return Arrays.equals(text1, text2);
  }

  // time: O(N)
  // space: O(1)
  public boolean isAnagram_2(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] charCounter = new int[26];

    for (int i = 0; i < s.length(); i++) {
      charCounter[s.charAt(i) - 'a']++;
      charCounter[t.charAt(i) - 'a']--;
    }

    for (int count : charCounter) {
      if (count != 0) return false;
    }

    return true;
  }
}
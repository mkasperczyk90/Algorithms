package AlgoExpert;

import java.util.*;

class FirstNonRepeatingCharacter {
public static void main(String args[]) {
    FirstNonRepeatingCharacter program = new FirstNonRepeatingCharacter();
    String string = "faadabcbbebdf";
    System.out.println(program.firstNonRepeatingCharacter_1(string));
    System.out.println(program.firstNonRepeatingCharacter_2(string));
    }

  // time O(N^2) <- because one for inside another for
  // space O(1) - no addictional space allocation
  public int firstNonRepeatingCharacter_1(String string) {
    for(int i = 0; i < string.length(); i++) {
      boolean hasDuplicatie = false;
      for(int j = 0; j < string.length(); j++) {
        if(string.charAt(i) == string.charAt(j) && i != j) {
          hasDuplicatie = true;
        }
      }
      if(!hasDuplicatie) return i;
    }
    return -1;
  }

  // time O(N) <-- (N + N = N because it is linear). 
  // space O(1) <-- We add hashMap but it's not more then 26 characters (letters in word and this make constant value here). 
  public int firstNonRepeatingCharacter_2(String string) {
    HashMap<Character, Integer> charMap = new HashMap<>();

    for(Character character: string.toCharArray()) {
      charMap.put(character, charMap.getOrDefault(character, 0) + 1);
    }

    for(int i = 0; i < string.length(); i++) {
      char character = string.charAt(i);
      
      if(charMap.get(character) == 1) {
        return i;
      }
    }

    return -1;
  }

}

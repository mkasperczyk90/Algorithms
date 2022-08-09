package AlgoEx;

import java.util.*;

class GenerateDocument {
public static void main(String args[]) {
  GenerateDocument program = new GenerateDocument();
  String characters = "Bste!hetsi ogEAxpelrt x ";
  String document = "AlgoExpert is the Best!";
    System.out.println(program.generateDocument(characters, document));
    }

  // time O(N + M) N - characters.length M document.length
  // space O(C) - c unique characters in the characters string 
  public boolean generateDocument(String characters, String document) {
    HashMap<Character, Integer> charCounts = new HashMap<>();

    for(char character: characters.toCharArray()) {
      charCounts.put(character, charCounts.getOrDefault(character, 0) + 1);
    }

    // check that all characters from map could create document
    for(char character: document.toCharArray()) {
      if(!charCounts.containsKey(character) || charCounts.get(character) == 0)
        return false;

      charCounts.put(character, charCounts.get(character) -1);
    }

    return true;
  }

}

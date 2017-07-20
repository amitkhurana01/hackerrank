package algorithms.implementations;

import algorithms.interfaces.UnorderedAnagrammaticPairsCounter;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 * https://codereview.stackexchange.com/questions/169768/unordered-substring-anagrammatic-pairs
 */

public class UnorderedAnagrammaticPairsCounterImpl implements UnorderedAnagrammaticPairsCounter {

  @Override
  public int countUnorderedAnagrammaticPairs(String s) {
    int count = 0;

    for (int substringLength = 1; substringLength <= s.length(); substringLength++) {
      Map<Map<Character, Integer>, Integer> substringsCounts = new HashMap<>();
      for (int index = 0; index <= s.length() - substringLength; index++) {
        String substring = s.substring(index, index + substringLength);
        Map<Character, Integer> characterCounts = this.getCharacterCounts(substring);
        Integer substringCounts = substringsCounts.get(characterCounts);
        if (substringCounts == null) {
          substringsCounts.put(characterCounts, 1);
        } else {
          count += substringCounts;
          substringsCounts.put(characterCounts, substringCounts + 1);
        }
      }
    }

    return count;
  }

  @Override
  public Map<Character, Integer> getCharacterCounts(String s) {
    Map<Character, Integer> characterCounts = new HashMap<>();

    for (char c : s.toCharArray()) {
      Integer characterCount = characterCounts.get(c);
      if (characterCount == null) {
        characterCounts.put(c, 1);
      } else {
        characterCounts.put(c, characterCount + 1);
      }
    }

    return characterCounts;
  }
}

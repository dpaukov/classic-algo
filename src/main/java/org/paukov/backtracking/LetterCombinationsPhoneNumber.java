package org.paukov.backtracking;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent. A
 * mapping of digit to letters is just like on the telephone buttons is given. Input: Digit string
 * "23". Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsPhoneNumber extends Backtracking<String, List<String>> {

  private final String[][] mapping = {
      {}, {""},
      {"a", "b", "c"},
      {"d", "e", "f"},
      {"g", "h", "i"},
      {"j", "k", "l"},
      {"m", "n", "o"},
      {"p", "q", "r", "s"},
      {"t", "u", "v"},
      {"w", "x", "y", "z"}};

  private final List<String> result = new ArrayList<>();

  public static List<String> of(String input) {
    LetterCombinationsPhoneNumber solution = new LetterCombinationsPhoneNumber();
    solution.run(new String[input.length() + 1], 0, asList(input.split("")));
    return solution.result;
  }

  @Override
  protected boolean isSolution(String[] vector, int k, List<String> dataInput) {
    return k == dataInput.size();
  }

  @Override
  protected void processSolution(String[] vector, int k, List<String> dataInput) {
    StringBuilder builder = new StringBuilder();
    for (int i = 1; i <= k; i++) {
      builder.append(vector[i]);
    }
    result.add(builder.toString());
  }

  @Override
  protected List<String> constructCandidates(String[] vector, int k, List<String> dataInput) {
    try {
      int number = Integer.parseInt(dataInput.get(k));
      return asList(mapping[number]);
    } catch (NumberFormatException ex) {
      return new ArrayList<>(); // no candidates
    }
  }
}

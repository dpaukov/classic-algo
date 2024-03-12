package org.paukov.backtracking;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses (Leetcode).
 * <p>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return
 * all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Examples: "()())()" -> ["()()()", "(())()"] "(a)())()" -> ["(a)()()", "(a())()"] ")(" -> [""]
 * <p>
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 */
public class RemoveInvalidParentheses extends Backtracking<Boolean, List<String>> {

  private int minRemoved = Integer.MAX_VALUE;
  private final List<List<Boolean>> result = new ArrayList<>();

  public static Set<String> of(String input) {
    RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
    Boolean[] vector = new Boolean[input.length() + 2];
    List<String> dataInput = asList(input.split(""));

    removeInvalidParentheses.run(vector, 0, dataInput);

    Set<String> result = new HashSet<>();
    for (List<Boolean> solution : removeInvalidParentheses.result) {
      StringBuilder solutionBuilder = new StringBuilder();
      for (int i = 1; i <= dataInput.size(); i++) {
        if (solution.get(i)) {
          solutionBuilder.append(dataInput.get(i - 1));
        }
      }
      result.add(solutionBuilder.toString());
    }
    return result;
  }

  @Override
  protected boolean isCorrectSolution(Boolean[] solution, int index, List<String> dataInput) {
    return index == dataInput.size();
  }

  @Override
  protected void processSolution(Boolean[] solution, int index, List<String> dataInput) {
    int balance = 0;
    int i = 1;
    while (balance >= 0 && i <= index) {
      if (solution[i]) {
        if (dataInput.get(i - 1).equals("(")) {
          balance++;
        } else if (dataInput.get(i - 1).equals(")")) {
          balance--;
        }
      }
      i++;
    }
    int removed = 0;
    if (balance == 0) {
      StringBuilder builder = new StringBuilder();
      for (i = 1; i <= index; i++) {
        if (solution[i]) {
          builder.append(dataInput.get(i - 1));
        } else {
          removed++;
        }
      }

      if (removed < minRemoved) {
        minRemoved = removed;
        result.clear();
        result.add(new ArrayList<>(asList(solution)));
      } else if (removed == minRemoved) {
        result.add(new ArrayList<>(asList(solution)));
      }
    }
  }

  @Override
  protected List<Boolean> constructCandidates(Boolean[] vector, int index, List<String> dataInput) {
    if (dataInput.get(index).equals("(") || dataInput.get(index).equals(")")) {
      return asList(Boolean.TRUE, Boolean.FALSE);
    } else {
      return asList(Boolean.TRUE);
    }
  }
}

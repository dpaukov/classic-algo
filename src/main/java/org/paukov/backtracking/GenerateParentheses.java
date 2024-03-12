package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 * <p>
 * For example, given n = 3, a solution set is: "((()))", "(()())", "(())()", "()(())", "()()()".
 */
public class GenerateParentheses extends Backtracking<String, Integer> {

  private final List<String> result = new ArrayList<>();

  public static List<String> of(int number) {
    GenerateParentheses generateParentheses = new GenerateParentheses();
    String[] vector = new String[number * 2 + 1];
    generateParentheses.run(vector, 0, number);
    return generateParentheses.result;
  }

  @Override
  protected boolean isCorrectSolution(String[] solution, int index, Integer dataInput) {
    return (index == 2 * dataInput);
  }

  @Override
  protected void processSolution(String[] solution, int index, Integer dataInput) {
    int balance = 0;
    int i = 1;
    while (balance >= 0 && i <= index) {
      if (solution[i].equals("(")) {
        balance++;
      } else if (solution[i].equals(")")) {
        balance--;
      } else {
        throw new RuntimeException("Unsupported symbol: " + solution[i]);
      }
      i++;
    }
    if (balance == 0) {
      StringBuilder builder = new StringBuilder();
      for (i = 1; i <= index; i++) {
        builder.append(solution[i]);
      }
      result.add(builder.toString());
    }
  }

  @Override
  protected List<String> constructCandidates(String[] vector, int index, Integer dataInput) {
    return Arrays.asList("(", ")");
  }
}

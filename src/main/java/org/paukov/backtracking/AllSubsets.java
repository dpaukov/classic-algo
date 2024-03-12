package org.paukov.backtracking;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.Arrays;
import java.util.List;

public class AllSubsets extends Backtracking<Boolean, Integer> {

  StringBuilder result = new StringBuilder();

  public static String of(int number) {
    AllSubsets allSubsets = new AllSubsets();
    Boolean[] vector = new Boolean[number + 1];
    allSubsets.run(vector, 0, number);
    return allSubsets.result.toString();
  }

  @Override
  protected boolean isCorrectSolution(Boolean[] solution, int index, Integer dataInput) {
    return index == dataInput;
  }

  @Override
  protected void processSolution(Boolean[] solution, int index, Integer dataInput) {
    result.append("{");
    for (int i = 1; i <= dataInput; i++) {
      if (solution[i] == TRUE) {
        result.append(i);
      }
    }
    result.append("}");
  }

  @Override
  protected List<Boolean> constructCandidates(Boolean[] vector, int index, Integer dataInput) {
    return Arrays.asList(TRUE, FALSE);
  }
}

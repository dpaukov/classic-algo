package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A child is running up the stairs and can take 1, 2 or 3 steps at a time. Count how many possible
 * ways the child can run up the stairs.
 */
public class ChildAndStaircase extends Backtracking<Integer, Integer> {

  private final List<List<Integer>> result = new ArrayList<>();

  public static List<List<Integer>> of(int number) {
    ChildAndStaircase solution = new ChildAndStaircase();
    Integer[] vector = new Integer[number + 1];
    vector[0] = 0;
    solution.run(vector, 0, number);
    return solution.result;
  }

  private Integer sum(Integer[] vector, int k) {
    Integer sum = 0;
    for (int i = 1; i <= k; i++) {
      sum += vector[i];
    }
    return sum;
  }

  @Override
  protected boolean isCorrectSolution(Integer[] solution, int index, Integer dataInput) {
    Integer s = sum(solution, index);
    return s.equals(dataInput);
  }

  @Override
  protected void processSolution(Integer[] solution, int index, Integer dataInput) {
    result.add(new ArrayList<>(Arrays.asList(solution).subList(1, index + 1)));
  }

  @Override
  protected List<Integer> constructCandidates(Integer[] vector, int index, Integer dataInput) {
    List<Integer> candidates = new ArrayList<>();
    Integer s = sum(vector, index);
    int diff = dataInput - s;
    if (diff >= 1) {
      candidates.add(1);
    }
    if (diff >= 2) {
      candidates.add(2);
    }
    if (diff >= 3) {
      candidates.add(3);
    }
    return candidates;
  }
}

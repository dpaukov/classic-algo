package org.paukov.backtracking;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations extends Backtracking<Integer, Integer> {

  List<int[]> result = new ArrayList<>();

  public static List<int[]> of(int number) {
    AllPermutations permutations = new AllPermutations();
    Integer[] vector = new Integer[100];
    vector[0] = 0;
    permutations.run(vector, 0, number);
    return permutations.result;
  }

  @Override
  boolean isCorrectSolution(Integer[] solution, int index, Integer dataInput) {
    return index == dataInput;
  }

  @Override
  void processSolution(Integer[] solution, int index, Integer dataInput) {
    int[] arr = new int[index];
    for (int i = 1; i <= index; i++) {
      arr[i-1] = solution[i];
    }
    result.add(arr);
  }

  @Override
  List<Integer> constructCandidates(Integer[] vector, int index, Integer dataInput) {
    List<Integer> result = new ArrayList<>();
    boolean[] in_perm = new boolean[dataInput + 1];
    for (int i = 0; i <= index; i++) {
      in_perm[vector[i]] = TRUE;
    }
    for (int i = 1; i <= dataInput; i++) {
      if (in_perm[i] == FALSE) {
        result.add(i);
      }
    }
    return result;
  }
}

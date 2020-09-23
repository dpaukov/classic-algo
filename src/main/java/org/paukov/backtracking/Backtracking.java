package org.paukov.backtracking;

import java.util.List;

/**
 * A skeleton class for all backtracking issues.
 */
public abstract class Backtracking<T, I> {

  protected boolean finished = false;

  abstract boolean isSolution(T[] vector, int k, I dataInput);

  abstract void processSolution(T[] vector, int k, I dataInput);

  abstract List<T> constructCandidates(T[] vector, int k, I dataInput);

  void makeMove(T[] vector, int k, I dataInput) {
  }

  void unmakeMove(T[] vector, int k, I dataInput) {
  }

  void run(T[] vector, int k, I dataInput) {
    if (isSolution(vector, k, dataInput)) {
      processSolution(vector, k, dataInput);
    } else {
      for (T c : constructCandidates(vector, k, dataInput)) {
        vector[k + 1] = c;
        makeMove(vector, k + 1, dataInput);
        run(vector, k + 1, dataInput);
        unmakeMove(vector, k + 1, dataInput);
        if (finished) {
          return;
        }
      }
    }
  }
}

package org.paukov.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.paukov.backtracking.SearchSequenceIn2DArray.Cell;

class SearchSequenceIn2DArrayTest {

  @Test
  void of() {
    int[][] matrix = new int[][]{
        {1, 2, 3},
        {3, 4, 5},
        {5, 6, 7}};
    int[] pattern = new int[]{1, 3, 4, 6, 5, 3};

    Cell[] result = SearchSequenceIn2DArray.of(matrix, pattern);

    assertThat(result).hasSize(7);
    assertThat(result[0]).isNull();
    assertThat(result[1]).isEqualTo(new Cell(0, 0));
    assertThat(result[2]).isEqualTo(new Cell(1, 0));
    assertThat(result[3]).isEqualTo(new Cell(1, 1));
    assertThat(result[4]).isEqualTo(new Cell(2, 1));
    assertThat(result[5]).isEqualTo(new Cell(2, 0));
    assertThat(result[6]).isEqualTo(new Cell(1, 0));
  }
}
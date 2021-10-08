package org.paukov.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.paukov.backtracking.Sudoku.Board;

class SudokuTest {

  /**
   * Sudoku Board:
   * |---------|---------|---------|
   * |         |         |    1  2 |
   * |         |    3  5 |         |
   * |         | 6       |    7    |
   * |---------|---------|---------|
   * | 7       |         | 3       |
   * |         | 4       | 8       |
   * | 1       |         |         |
   * |---------|---------|---------|
   * |         | 1  2    |         |
   * |    8    |         |    4    |
   * |    5    |         | 6       |
   * |---------|---------|---------|
   * <p>
   * Solution:
   * |---------|---------|---------|
   * | 6  7  3 | 8  9  4 | 5  1  2 |
   * | 9  1  2 | 7  3  5 | 4  8  6 |
   * | 8  4  5 | 6  1  2 | 9  7  3 |
   * |---------|---------|---------|
   * | 7  9  8 | 2  6  1 | 3  5  4 |
   * | 5  2  6 | 4  7  3 | 8  9  1 |
   * | 1  3  4 | 5  8  9 | 2  6  7 |
   * |---------|---------|---------|
   * | 4  6  9 | 1  2  8 | 7  3  5 |
   * | 2  8  7 | 3  5  6 | 1  4  9 |
   * | 3  5  1 | 9  4  7 | 6  2  8 |
   * |---------|---------|---------|
   */
  @Test
  void of() {
    Board board = new Board();
    board.setCellValue(1, 8, 1);
    board.setCellValue(1, 9, 2);
    board.setCellValue(2, 5, 3);
    board.setCellValue(2, 6, 5);
    board.setCellValue(3, 4, 6);
    board.setCellValue(3, 8, 7);
    board.setCellValue(4, 1, 7);
    board.setCellValue(4, 7, 3);
    board.setCellValue(5, 4, 4);
    board.setCellValue(5, 7, 8);
    board.setCellValue(6, 1, 1);
    board.setCellValue(7, 4, 1);
    board.setCellValue(7, 5, 2);
    board.setCellValue(8, 2, 8);
    board.setCellValue(8, 8, 4);
    board.setCellValue(9, 2, 5);
    board.setCellValue(9, 7, 6);

    System.out.println(board.toString());
    assertThat(board.toString()).isEqualTo(
        "Board:\n"
            + "|---------|---------|---------|\n"
            + "|         |         |    1  2 |\n"
            + "|         |    3  5 |         |\n"
            + "|         | 6       |    7    |\n"
            + "|---------|---------|---------|\n"
            + "| 7       |         | 3       |\n"
            + "|         | 4       | 8       |\n"
            + "| 1       |         |         |\n"
            + "|---------|---------|---------|\n"
            + "|         | 1  2    |         |\n"
            + "|    8    |         |    4    |\n"
            + "|    5    |         | 6       |\n"
            + "|---------|---------|---------|\n"
    );

    Board result = Sudoku.of(board);

    System.out.println(result.toString());
    assertThat(result.toString()).isEqualTo(
        "Board:\n"
            + "|---------|---------|---------|\n"
            + "| 6  7  3 | 8  9  4 | 5  1  2 |\n"
            + "| 9  1  2 | 7  3  5 | 4  8  6 |\n"
            + "| 8  4  5 | 6  1  2 | 9  7  3 |\n"
            + "|---------|---------|---------|\n"
            + "| 7  9  8 | 2  6  1 | 3  5  4 |\n"
            + "| 5  2  6 | 4  7  3 | 8  9  1 |\n"
            + "| 1  3  4 | 5  8  9 | 2  6  7 |\n"
            + "|---------|---------|---------|\n"
            + "| 4  6  9 | 1  2  8 | 7  3  5 |\n"
            + "| 2  8  7 | 3  5  6 | 1  4  9 |\n"
            + "| 3  5  1 | 9  4  7 | 6  2  8 |\n"
            + "|---------|---------|---------|\n"
    );
  }
}
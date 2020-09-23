package org.paukov.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Simple Sudoku solver based on the Backtracking algorithm.
 */
public class Sudoku extends Backtracking<Integer, Sudoku.Board> {

  private static final int DIMENSION = 9;
  private static final int CELLS = DIMENSION * DIMENSION;
  private static final int EMPTY_CELL = 0;

  Board result = null;

  public static Board of(Board board) {
    Sudoku sudoku = new Sudoku();
    Integer[] vector = new Integer[100];
    sudoku.run(vector, 0, board);
    return sudoku.result;
  }

  @Override
  protected boolean isSolution(Integer[] vector, int k, Board dataInput) {
    Point point = dataInput.nextCell();
    return point == null;
  }

  @Override
  protected void processSolution(Integer[] vector, int k, Board dataInput) {
    result = new Board(dataInput);
    finished = true;
  }

  @Override
  protected List<Integer> constructCandidates(Integer[] vector, int k, Board dataInput) {
    ArrayList<Integer> candidates = new ArrayList<>();
    Point point = dataInput.nextCell();
    if (point == null) {
      return candidates; // no candidates found
    }
    dataInput.setMove(k + 1, point);
    candidates.addAll(dataInput.possibleValues(point));
    return candidates;
  }

  @Override
  protected void makeMove(Integer[] vector, int k, Board dataInput) {
    dataInput.setCellValue(k, vector[k]);
  }

  @Override
  protected void unmakeMove(Integer[] vector, int k, Board dataInput) {
    dataInput.freeCell(k);
  }

  static class Point {

    final int x;
    final int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static public class Board {

    int[][] matrix = new int[DIMENSION + 1][DIMENSION + 1];
    Point[] move = new Point[CELLS + 1];

    public Board() {
    }

    public Board(Board board) {
      for (int i = 0; i < matrix.length; i++) {
        System.arraycopy(board.matrix[i], 0, this.matrix[i], 0, matrix[i].length);
      }
    }

    void setCellValue(int x, int y, int value) {
      matrix[x][y] = value;
    }

    void setCellValue(int k, int value) {
      matrix[move[k].x][move[k].y] = value;
    }

    void freeCell(int k) {
      matrix[move[k].x][move[k].y] = EMPTY_CELL;
    }

    void setMove(int k, Point p) {
      move[k] = p;
    }

    Point nextCell() {
      for (int i = 1; i <= DIMENSION; i++) {
        for (int j = 1; j <= DIMENSION; j++) {
          if (matrix[i][j] == EMPTY_CELL) {
            return new Point(i, j);
          }
        }
      }
      return null;
    }

    Set<Integer> possibleValues(Point point) {
      Set<Integer> possible = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
      for (int i = 1; i <= DIMENSION; i++) {
        possible.remove(matrix[i][point.y]);
        possible.remove(matrix[point.x][i]);
      }
      int sector_x = (point.x - 1) / 3;
      int sector_y = (point.y - 1) / 3;
      for (int i = 3 * sector_x + 1; i <= 3 * sector_x + 3; i++) {
        for (int j = 3 * sector_y + 1; j <= 3 * sector_y + 3; j++) {
          possible.remove(matrix[i][j]);
        }
      }
      return possible;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Board:").append("\n");
      sb.append("|---------|---------|---------|").append("\n");
      for (int i = 1; i <= DIMENSION; i++) {
        sb.append("|");
        for (int j = 1; j <= DIMENSION; j++) {
          if (matrix[i][j] != EMPTY_CELL) {
            sb.append(String.format(" %d ", matrix[i][j]));
          } else {
            sb.append("   ");
          }
          if (j % 3 == 0) {
            sb.append("|");
          }
        }
        sb.append("\n");
        if (i % 3 == 0) {
          sb.append("|---------|---------|---------|").append("\n");
        }
      }
      return sb.toString();
    }
  }
}

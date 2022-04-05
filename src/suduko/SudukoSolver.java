package suduko;

public class SudukoSolver {

  static int[][] board = new int[9][9];

  SudukoSolver(int[][] board) {
    SudukoSolver.board = board;
  }

  public static void main(String[] args) {

    fil();
    solveSudoku();
    print();
  }

  public static void solveSudoku() {
    helper(0, 0);
  }

  public static boolean contains(int[] li, int n) {

    for (int i = 0; i < li.length; i++) {
      if (li[i] == n)
        return true;
    }
    return false;
  }

  public static boolean isSafe(int row, int col, int number) {
    // column
    for (int i = 0; i < board.length; i++) {
      if (board[i][col] == number) {
        return false;
      }
    }

    // row
    for (int j = 0; j < board.length; j++) {
      if (board[row][j] == number) {
        return false;
      }
    }

    // grid
    int sr = 3 * (row / 3);
    int sc = 3 * (col / 3);

    for (int i = sr; i < sr + 3; i++) {
      for (int j = sc; j < sc + 3; j++) {
        if (board[i][j] == number) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean helper(int row, int col) {
    if (row == board.length) {
      return true;
    }

    int nrow = 0;
    int ncol = 0;

    if (col == board.length - 1) {
      nrow = row + 1;
      ncol = 0;
    } else {
      nrow = row;
      ncol = col + 1;
    }

    if (board[row][col] != 0) {
      if (helper(nrow, ncol)) {
        return true;
      }
    } else {

      // fill the place
      for (int i = 1; i <= 9; i++) {
        if (isSafe(row, col, i)) {
          board[row][col] = i;
          if (helper(nrow, ncol))
            return true;
          else
            board[row][col] = 0;
        }
      }
    }
    return false;
  }

  public static void fil() {
    int arr[][] = {
        { 0, 0, 0, 0, 9, 0, 0, 0, 0 },
        { 0, 0, 4, 5, 0, 6, 9, 0, 0 },
        { 0, 3, 0, 0, 0, 0, 0, 2, 0 },
        { 0, 0, 9, 3, 0, 8, 6, 0, 0 },
        { 0, 0, 0, 7, 0, 4, 0, 0, 0 },
        { 0, 0, 6, 2, 0, 9, 4, 0, 0 },
        { 0, 7, 0, 0, 0, 0, 0, 1, 0 },
        { 0, 0, 3, 9, 0, 2, 8, 0, 0 },
        { 0, 0, 0, 0, 4, 0, 0, 0, 0 }
    };

    board = arr;
  }

  public static void print() {

    for (int i = 0; i < board.length; i++) {
      if (i % 3 == 0) {

        System.out.print("_________________________");

        System.out.println();
      }
      for (int j = 0; j < board[0].length; j++) {
        if (j % 3 == 0)
          System.out.print("| ");
        System.out.print((board[i][j] == 0 ? " " : board[i][j]) + " ");
      }
      System.out.print("| ");
      System.out.println();
    }
    System.out.println("_________________________");
  }

}

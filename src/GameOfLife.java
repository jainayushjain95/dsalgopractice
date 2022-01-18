public class GameOfLife {

    public static int ZERO_ZERO = 2;
    public static int ZERO_ONE = 3;
    public static int ONE_ONE = 4;
    public static int ONE_ZERO = 5;
    public int[][] directions;

    public static void main(String[] args) {
        int[][] board = {
                {1, 1}, {1, 0}
        };
        new GameOfLife().gameOfLife(board);
        for(int i = 0;i < board.length; i++) {
            for(int j = 0;j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        directions = new int[][]{
                {0, 1}, {1, 1}, {1, 0}, {1, -1},
                {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
        };

        for(int i = 0;i < board.length; i++) {
            for(int j = 0;j < board[i].length; j++) {
                updateValueForCell(board, i, j);
            }
        }
        postProcess(board);
    }

    public void postProcess(int[][] board) {
        for(int i = 0;i < board.length; i++) {
            for(int j = 0;j < board[i].length; j++) {
                if(board[i][j] == ZERO_ZERO || board[i][j] == ONE_ZERO) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }

    public void updateValueForCell(int[][] board, int i, int j) {
        int liveNeighboursCount = getLiveNeighboursCount(board, i, j);
        if(board[i][j] == 1) {
            if(liveNeighboursCount < 2) {
                board[i][j] = ONE_ZERO;
            } else if(liveNeighboursCount == 2 || liveNeighboursCount == 3) {
                board[i][j] = ONE_ONE;
            } else {
                board[i][j] = ONE_ZERO;
            }
        } else {
            if(liveNeighboursCount == 3) {
                board[i][j] = ZERO_ONE;
            } else {
                board[i][j] = ZERO_ZERO;
            }
        }
    }

    public int getLiveNeighboursCount(int[][] board, int i, int j) {
        int liveNeighboursCount = 0;
        for(int k = 0;k < directions.length; k++) {
            int rowIndex = i + directions[k][0];
            int colIndex = j + directions[k][1];
            if(isValidCell(board, rowIndex, colIndex)) {
                if(isLiveNeighbour(board, rowIndex, colIndex)) {
                    liveNeighboursCount++;
                }
            }
        }

        return liveNeighboursCount;
    }

    public boolean isLiveNeighbour(int[][] board, int rowIndex, int colIndex) {
        return board[rowIndex][colIndex] == 1
                || board[rowIndex][colIndex] == ONE_ONE
                || board[rowIndex][colIndex] == ONE_ZERO;
    }

    public boolean isValidCell(int[][] board, int rowIndex, int colIndex) {
        return rowIndex >= 0
                && rowIndex < board.length
                && colIndex >= 0
                && colIndex < board[rowIndex].length;
    }
}

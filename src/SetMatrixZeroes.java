public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new SetMatrixZeroes().setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        boolean isFirstColumnZero = false;

        for(int i = 0;i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                isFirstColumnZero = true;
            }

            for(int j = 1;j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1;i < matrix.length; i++) {
            for(int j = 1;j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int i = 0;i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(isFirstColumnZero) {
            for(int i = 0;i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }


}

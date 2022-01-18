public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1},
        };
        new RotateImage().rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        for(int i = 0;i < matrix.length; i++) {
            reverseRow(matrix, i);
        }

        for(int i = 0;i < matrix.length; i++) {
            System.out.println();
            for(int j = 0;j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }

    }

    public static void reverseRow(int[][] matrix, int rowIndex) {
        int i = 0, j = matrix.length - 1;
        while(i < j) {
            swap(matrix, rowIndex, i, rowIndex, j);
            i++;
            j--;
        }
    }

    public static void transpose(int[][] matrix) {
        int rowIndex = 0, columnIndex = 0;
        while(rowIndex < matrix.length) {
            int i = rowIndex, j = columnIndex;
            while(i < matrix.length) {
                swap(matrix, i, columnIndex, rowIndex, j);
                i++;
                j++;
            }
            rowIndex++;
            columnIndex++;
        }
    }

    public static void swap(int[][] matrix, int ri1, int ci1, int ri2, int ci2) {
        int temp = matrix[ri1][ci1];
        matrix[ri1][ci1] = matrix[ri2][ci2];
        matrix[ri2][ci2] = temp;
    }
}

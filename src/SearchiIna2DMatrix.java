public class SearchiIna2DMatrix {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = matrix.length - 1, columnIndex = 0;

        while(rowIndex >= 0 && columnIndex < matrix[0].length) {
            if(matrix[rowIndex][columnIndex] == target) {
                return true;
            }
            if(matrix[rowIndex][columnIndex] > target) {
                rowIndex--;
            } else {
                columnIndex++;
            }
        }
        return false;
    }
}

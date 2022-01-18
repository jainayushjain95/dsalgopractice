import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;

        while(output.size() < rows * cols) {
            for(int i = left; i <= right; i++) {
                output.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                output.add(matrix[i][right]);
            }
            right--;

            if(output.size() < rows * cols) {
                for(int i = right; i >= left; i--) {
                    output.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(output.size() < rows * cols) {
                for(int i = bottom; i >= top; i--) {
                    output.add(matrix[i][left]);
                }
                left++;
            }
        }

        return output;
    }
}

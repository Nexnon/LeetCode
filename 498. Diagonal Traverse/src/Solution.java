import java.util.Arrays;

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int length = rows * cols;
        int[] result = new int[length];
        int j = 0, i = 0;
        boolean isUp = true;
        for (int k = 0; k < length; k++){
            result[k] = mat[i][j];
            if(isUp){
                if(i == 0 || j == cols - 1){
                    isUp = !isUp;
                } else
                    i--;
                if(j == cols - 1){
                    i++;
                } else{
                    j++;
                }
            } else{
                if(j == 0 || i == rows - 1){
                    isUp = !isUp;
                } else
                    j--;
                if(i == rows - 1){
                    j++;
                } else {
                    i++;
                }
            }
        }
        return result;
    }
}

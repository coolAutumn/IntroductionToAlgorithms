package Matrix;

/**
 * Created by coolAutumn on 6/10/16.
 */
public class SquareMatrixMultiplyRecursive {

    int[][] result=null;

    public int[][] calculateSquareMatrixValue(int[][] arr1,int[][]arr2,int arr1_rows,int arr2_colomns){
        result=new int[arr1_rows][arr2_colomns];
        return result;
    }

    public int[][] directlyCalculateMatrixValue(int[][] arr1,int[][]arr2,int arr1_rows,int arr1_columns,int arr2_columns){
        int[][] res=new int[arr1_rows][arr2_columns];
        for(int i=0;i<arr1_rows;i++){
            for (int j=0;j<arr2_columns;j++){
                for (int k=0;k<arr1_columns;k++){
                    res[i][j]+=arr1[i][k] * arr2[j][k];
                }
            }
        }
        return res;
    }
}

import Array.FindMaxSubSubArray;
import Matrix.SquareMatrixMultiplyRecursive;

/**
 * Created by coolAutumn on 6/6/16.
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr1=new int[][]{{1,2,3,2},{1,2,3,2},{1,2,3,2},{1,2,3,2},{1,2,3,2}};
        int[][] arr2=new int[][]{{1,2,3,2,1},{1,2,3,2,1},{1,2,3,2,1},{1,2,3,2,1}};

        SquareMatrixMultiplyRecursive s=new SquareMatrixMultiplyRecursive();
        System.out.println(s.directlyCalculateMatrixValue(arr1,arr2,5,4,4));


    }
}

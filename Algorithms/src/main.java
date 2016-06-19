import Array.FindMaxSubSubArray;
import Matrix.SquareMatrixMultiplyRecursive;
import Sort.HeapSort;

/**
 * Created by coolAutumn on 6/6/16.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr1=new int[]{123,243,73,233,164,2,23,221,11,24,35,2,91,23,34,62,1,52,3,22};

        HeapSort h=new HeapSort();
        h.heapSort(arr1);
        System.out.println(arr1);

    }
}

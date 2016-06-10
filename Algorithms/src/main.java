import Array.FindMaxSubSubArray;

/**
 * Created by coolAutumn on 6/6/16.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr=new int[]{0,0,0,11,1};
        FindMaxSubSubArray f=new FindMaxSubSubArray();
        System.out.println(f.findMaxSubSumArray(arr,0,arr.length-1));


    }
}

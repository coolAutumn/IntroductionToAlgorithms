import sort.Sort;

/**
 * Created by coolAutumn on 6/6/16.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{96,85,48,46,94,14,3,2,1,23,5,212,685,24,7,45,2,32};
        Sort<Integer> s=new Sort<Integer>();
        arr=s.mergeSort(arr,true);
        for(Integer t:arr){
            System.out.println(t);
        }
    }
}

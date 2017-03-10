import expression.CalculateExpression;
import expression.InfixToSuffix;
import sort.*;
import sort.interfaces.IObjectSort;

/**
 * Created by coolAutumn on 6/6/16.
 */
public class Main {
    public static void main(String[] args) {

        int[] arr1=new int[]{123,243,73,233,164,2,23,221,11,24,35,2,91,23,34,62,-1,52,3,22};
        Integer[] arr2=new Integer[]{123,243,73,233,164,2,23,221,11,24,35,2,91,23,34,62,-1,52,3,22};
        int[] arr3=new int[]{123,243,73,233,164,2,23,221,11,24,35,2,91,23,34,62,-1,52,3,22};
        int[] arr4=new int[]{123,243,73,233,164,2,23,221,11,24,35,2,91,23,34,62,1,52,3,22};

        HeapSort h=new HeapSort();
        h.heapSort(arr1);
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();
//
        QuickSort_two<Integer> quickSort = new QuickSort_two<Integer>();

        quickSort.sort(arr2, new IObjectSort() {
            @Override
            public int compare(Object o1, Object o2) {
                if((Integer)o1 == (Integer)o2){
                    return 0;
                }
                return (Integer)o1 > (Integer)o2 ? 1 : -1;
            }
        });
        for(int i:arr2){
            System.out.print(i+" ");
        }
        System.out.println();
//
//        System.out.println();
//        for(int i:arr2){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//
//        CountingSort countingSort = new CountingSort();
//        countingSort.countingSort(arr3);
//
//        RadixSort radixSort = new RadixSort();
//        radixSort.sort(arr4);
//
//        System.out.println();
//        for(int i:arr4){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        int[] A = MergeSort_two.mergeSort(arr1);
//        for(int i:A){
//            System.out.print(i+",");
//        }
    }


//    public static void main(String[] args) {
//        String s = "a[0]";
//        System.out.println(s.substring(0,s.indexOf("[")+1));
//    }
}

package sort;

/**
 * Created by Moopa on 08/03/2017.
 * blog: leeautumn.net
 *
 * 该归并排序只考虑对于int型数组的排序
 *
 * @autuor : Moopa
 */
public class MergeSort_two {

    public static int[] mergeSort(int[] A){
        int length = A.length;

        int[] from = A;
        int[] to = new int[length];

        return mergeSort_partial(from,to,0,length-1,0);
    }

    public static int[] mergeSort_partial(int[] from , int to[] , int head,int tail,int count){
        int[] temp = from;
        if(count%2 != 0){
            from = to;
            to = temp;
        }

        count++;

        int length = tail-head+1;

        if(head >= tail){
            return to;
        }else{
            mergeSort_partial(from,to,head,head+(length-1)/2,count);
            mergeSort_partial(from,to,head+(length+1)/2,tail,count);
            iner_sort(from,to,head,tail);
        }


        return to;
    }

    /**
     * 冒泡排序
     * @param from
     * @param to
     * @param head
     * @param tail
     */
    private static void iner_sort(int[] from, int[] to, int head,int tail){
        int i = head;
        int j = head+(tail-head+1)/2;
        int length = tail-head+1;

        int start = head;

        for(;(i!=head+(tail-head+1)/2) && (j!=tail+1);){
            if(from[i]<from[j]){
                to[start] = from[i];
                i++;
            }else{
                to[start] = from[j];
                j++;
            }
            start++;
        }
        if(i==head+(tail-head+1)/2){
            for(int k=start;k<=tail;k++){
                to[k] = from[k];
            }
        }else{
            for(int k=i;k<head+(tail-head+1)/2;k++){
                to[++start] = from[k];
            }
        }
    }
}

package sort;

/**
 * Created by LeeAutumn on 10/8/16.
 * blog: leeautumn.net
 */
public class CountingSort {
    public void countingSort(int[] array){

        int max = array[0],min = array[0];
        for(int i:array){
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }
        //这里k的大小是要排序的数组中，元素大小的极值差+1
        int templength=max-min+1;
        int[] temp = new int[templength];

        //在temp数组上记录下每个数出现的次数
        for(int i=0;i<array.length;i++){
            temp[array[i]-min] += 1;
        }

        //way1:在原址上放入数字,此步骤是我自己的想法,书上的步骤还要多,觉得有点多余
        int j=0,i=0;
//        while(j < temp.length){
//            if(temp[j]!=0){
//                array[i] = j+min;
//                temp[j]--;
//                i++;
//
//            }else {
//                j++;
//            }
//        }

        //way2:书上的方法
        for(int k = 1;k<temp.length;k++){
            temp[k] += temp[k-1];
        }

        //新new一个和被比较数组相同长度的数组
        int[] newarray = new int[array.length];
        for(int k = array.length-1 ;k >= 0; k--){
            newarray[temp[array[k]-min]-1] = array[k];
            temp[array[k]-min]--;
        }
        for(int o : newarray){
            System.out.print(o+" ");
        }
    }
}

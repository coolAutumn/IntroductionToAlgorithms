package sort;

import sun.awt.image.IntegerComponentRaster;
import sun.text.normalizer.SymbolTable;

/**
 * Created by coolAutumn on 6/6/16.
 */
public class Sort<T>{
    public T[] insertionSort(T[] arr,boolean isAsc){
        int length=arr.length;
        if(arr.getClass().equals(String[].class)) {
            for (int i = 1; i < length; i++) {
                T t = arr[i];
                if (isAsc) {
                    int j = i - 1;
                    for (; j >= 0&&((String) t).compareTo((String) arr[j]) < 0; j--) {
                        arr[j + 1] = arr[j];
                    }
                    arr[j+1]=t;
                }else {
                    int j = i - 1;
                    for (; j >= 0&&((String) t).compareTo((String) arr[j]) > 0; j--) {
                        arr[j + 1] = arr[j];
                    }
                    arr[j+1]=t;
                }
            }
        }else if(arr.getClass().equals(Integer[].class)){
            for (int i = 1; i < length; i++) {
                T t = arr[i];
                if (isAsc) {
                    int j = i - 1;
                    for (; j >= 0&&((Integer) t)<((Integer) arr[j]); j--) {
                        arr[j + 1] = arr[j];
                    }
                    arr[j+1]=t;
                }else {
                    int j = i - 1;
                    for (; j >= 0&&((Integer) t)>((Integer) arr[j]); j--) {
                        arr[j + 1] = arr[j];
                    }
                    arr[j+1]=t;
                }
            }
        }else{
            System.out.println("此排序只支持String,整型");
            return null;
        }
        return arr;
    }
}

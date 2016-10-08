package Sort;

import Sort.interfaces.IObjectSort;

/**
 * Created by LeeAutumn on 10/8/16.
 * blog: leeautumn.net
 * 本文件描述的是快速排序的实现方法,利用泛型来实现多对象的比较
 *
 * 如果是常规类型则利用内置的比较器来比较
 * 如果不是,则先判断被比较对象有没有实现IObjectCompare接口,然后再用接口方法来比较
 * 采用策略设计模式
 */
public class QuickSort<T> {

    private IObjectSort<T> iObjectSort;

    private int IntergeCompare(int num1,int num2){
        if(num1 == num2){
            return 0;
        }
        return num1>num2 ? 1 : -1;
    }

    /**
     * 调用者在调用该方法时,通过对IObejctSort的实现从而实现策略的变换
     * 排序最重要的步骤就是比较,也就是对比较策略进行动态绑定来实现策略模式
     * @param array
     * @param iObjectSort
     */
    public void sort(T[] array,IObjectSort iObjectSort){
        try {
            if (iObjectSort == null) {
                throw new Exception("请实现比较器");
            }

            if (array == null || array.length < 2) {
                throw new Exception("请确认数组的合法性");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        this.iObjectSort = iObjectSort;
        int length = array.length;

        //先判断类型,是否为基础类型,然后设置适配器
        if(array.getClass().equals(int[].class)){               //判断其为int
            //此处利用内置的对于整型的排序算法
        }else{                                                  //未对其他基本类型进行实现
            //以下开始实现快速排序
            //先进行Partition操作,将数组从中间隔开(中间左边的数小于中间的书,中间右边的数大于中间的数)
            //然后继续对分开后的两个数组进行快排操作
            int index = length;
            quickSort(array,0,array.length-1);
        }
    }
    public void quickSort(T[] array , int start , int end){
        int t = partition(array,start,end);
        if(t == -1){
            return;
        }
        quickSort(array,start,t-1);
        quickSort(array,t+1,end);
    }

    public int partition(T[] array,int start,int end){
        if(start >= end){
            return -1;
        }
        T index = array[end];
        int iter = start;
        //i代表了比index小的数列的后面一个数 , j代表了比index大的数列的后面一个数
        int i = start , j = start;
        int compareResult = 0;
        for(;iter < end;iter++){
            compareResult = iObjectSort.compare(array[iter],index);
            if(compareResult > 0){
                //如果发现大于的那只要j++就可以了
                j++;
            }else if(compareResult < 0){
                //如果发现小于的,就要和i后面那个大于index的交换位置
                T temp      =  array[i];
                array[i]  =  array[iter];
                array[iter] =  temp;

                i++;
                j++;
            }else if(compareResult == 0){
                //直接iter++即可
            }
        }
        //最后把array[end]放到他应该在的位置
        T temp     =  array[end];
        array[end] =  array[i];
        array[i]   =  temp;

        //返回中间数所在位置
        return i;
    }
}


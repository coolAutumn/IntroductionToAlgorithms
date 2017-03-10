package sort;

import sort.interfaces.IObjectSort;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by LeeAutumn on 10/8/16.
 * blog: leeautumn.net
 * 本文件描述的是快速排序的实现方法,利用泛型来实现多对象的比较
 *
 * 如果是常规类型则利用内置的比较器来比较
 * 如果不是,则先判断被比较对象有没有实现IObjectCompare接口,然后再用接口方法来比较
 * 采用策略设计模式
 */
public class QuickSort_two<T> {

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

        int i = start , j = end , hole = end;
        boolean findLarger = true;

        while(i < j){
            if(findLarger){
                while(iObjectSort.compare(array[i],index) <= 0 && i < j){
                    i++;
                }
                if(i<j) {
                    array[hole] = array[i];
                    findLarger = false;
                    hole = i;
                    j--;
                }
            }else{
                while(iObjectSort.compare(array[j],index)>0 && j > i){
                    j--;
                }
                if(j>i) {
                    array[hole] = array[j];
                    findLarger = true;
                    hole = j;
                    i++;
                }
            }
        }
        //最后把index放到他应该在的位置
        array[j] = index;
        //返回中间数所在位置
        return i;
    }
}


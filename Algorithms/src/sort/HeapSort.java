package sort;

/**
 * Created by coolAutumn on 6/19/16.
 */
//此处堆排序只对数字进行排序
public class HeapSort {

    /**
     * 这两个函数用来获得index节点的左右子树的结点索引值
     * @param length
     * @param index
     * @return  若存在则返回正确的索引值,若不存在则返回-1
     */
//    public int getLeft(int[] array,int index,int length){
    public int getLeft(int index,int length){
        return length-1 >= index*2+1 ? index*2+1 : -1;
    }
//    public int getRight(int[] array,int index,int length){
    public int getRight(int index,int length){
        return length-1 >= index*2+2 ? index*2+2 : -1;
    }


    /**
     * 这个函数用来维护数组中top以下的最大堆的性质(一般从length/2~0)
     * @param array   要维护的数组
     * @param top   要开始维护子树的头结点的index
     * @param last  要维护的数组最后一个数
     */
    public void maxHeapify(int[] array,int top,int last){
        int left=getLeft(top,last);
        int right=getRight(top,last);

        //获得左右字数较大的节点
        //为了防止做三次if判断(if语句有三个判断条件,太多),直接做两次ifelse
        int largest=-1;
        if(left!=-1 && array[top]<array[left]){
            largest=left;
        }else {
            largest=top;
        }
        if(right!=-1 && array[largest]<array[right]){
            largest=right;
        }

        //交换top和子节点的值
        //并且递归修正子树
        if(largest!=top){
            int temp=array[largest];
            array[largest]=array[top];
            array[top]=temp;

            maxHeapify(array,largest,last);
        }
    }

    /**
     * 这个函数用于讲一个整型数组构建成一个最大堆
     * 由于在上一个maxHeapify函数中已经做出了构建一个小子树的流程
     * 采取自底向上的方法,利用上面的函数来构建最大堆
     * @param array 需要被构建的数组
     */
    public void buildMaxHeap(int[] array){
        int length=array.length;

        for(int i=(length-1)/2;i>=0;i--){
            maxHeapify(array,i,length);
        }
    }


    /**
     * 堆排序算法(原址上排序)
     * 将A[0]和A[length]互换,换好之后length-1(因为A[0]永远最大,则该剩余数组最大数已经得出了),之后还要继续维持最大堆的性质
     * @param array 待被排序的数组
     */
    public void heapSort(int[] array){
        int length=array.length;

        //先建成最大堆
        buildMaxHeap(array);
        for(int i=length;i>0;i--){
            // 将A[0]和A[length]互换
            int temp=array[--length];
            array[length]=array[0];
            array[0]=temp;

            //维持最大堆性质
            maxHeapify(array,0,length);
        }
    }


}

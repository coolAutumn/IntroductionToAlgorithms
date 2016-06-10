package Sort;

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

    //归并排序还可以递归调用,此处不再给出方法
    public T[] mergeSort(T[] arr,boolean isAsc){
        //只支持String,整型数组
        if(!arr.getClass().equals(Integer[].class)&&!arr.getClass().equals(String[].class)){
            System.out.println("此排序只支持String,整型");
            return null;
        }

        //创建一个等长的数组,用来作归并操作中的临时存储数组元素的地方
        T[] tempArr= (T[]) new Object[arr.length];
        int partLength=1;
        int whichFinalArray=0;                                  //用来判断最后排好序的数组在哪个变量里边
        while(partLength<=arr.length){

            if(whichFinalArray%2==0) {
                mergeSort_merge(arr, tempArr, partLength,isAsc);
            }else{
                mergeSort_merge(tempArr, arr, partLength,isAsc);
            }
            whichFinalArray++;

            if(partLength==arr.length){
                break;
            }
            partLength = partLength*2 < arr.length ? partLength*2 : arr.length;

        }
        if(whichFinalArray%2!=0){
            for (int i=0;i<arr.length;i++) {
                arr[i]=tempArr[i];
            }
        }
        tempArr=null;
        return arr;
    }

    private void mergeSort_merge(T[] arr,T[] tempArr,int partLength,boolean isAsc){
        //i :第一段开始的位置
        //j :第二段开始的位置
        //lastOfFirst   :   第一段应该结束的位置
        //lastOfSecond  :   第二段应该结束的位置
        int i = 0,j = partLength<arr.length-1 ? partLength : arr.length-1;
        int offset=0;
        if(isAsc) {
            if (arr.getClass().equals(Integer[].class)||tempArr.getClass().equals(Integer[].class)) {

                while(offset<arr.length) {
                    int lastOfFirst=j,lastOfSecond=((j+partLength<=arr.length)?j+partLength:arr.length);

                    //分为三种情况
                    //第一种和第二种:最后两段都是完整的或者最后两段后一段不完整,两个情况相同
                    //第三种:最后只有一段了

                    if(j==arr.length){                      //如果处于第三种情况,直接退出,因为此时只有一个数组了,没有和他相比较的数组了
                        for(int m=i;m<lastOfFirst;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                        break;
                    }

                    while (i < lastOfFirst && j < lastOfSecond) {
                        if ((Integer) arr[i] < (Integer) arr[j]) {
                            tempArr[offset]=arr[i];
                            i++;
                        }else{
                            tempArr[offset]=arr[j];
                            j++;
                        }
                        offset++;
                    }
                    if(i==lastOfFirst){
                        for(int m=j;m<lastOfSecond;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                    }else{
                        for(int m=i;m<lastOfFirst;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                    }

                    i=offset;
                    j=i+partLength<=arr.length?i+partLength:arr.length;     //如果第二段开始位置大于数组长度,则处于第三种情况
                }
            }else{

                while(offset<arr.length) {
                    int lastOfFirst=j,lastOfSecond=((j+partLength<=arr.length)?j+partLength:arr.length);

                    //分为三种情况
                    //第一种和第二种:最后两段都是完整的或者最后两段后一段不完整,两个情况相同
                    //第三种:最后只有一段了

                    if(j==arr.length){                      //如果处于第三种情况,直接退出,因为此时只有一个数组了,没有和他相比较的数组了
                        for(int m=i;m<lastOfFirst;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                        break;
                    }

                    while (i < lastOfFirst && j < lastOfSecond) {
                        if (((String)arr[i]).compareTo((String)arr[j])<0) {
                            tempArr[offset]=arr[i];
                            i++;
                        }else{
                            tempArr[offset]=arr[j];
                            j++;
                        }
                        offset++;
                    }
                    if(i==lastOfFirst){
                        for(int m=j;m<lastOfSecond;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                    }else{
                        for(int m=i;m<lastOfFirst;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                    }

                    i=offset;
                    j=i+partLength<=arr.length?i+partLength:arr.length;     //如果第二段开始位置大于数组长度,则处于第三种情况
                }
            }
        }else{
            if (arr.getClass().equals(Integer[].class)||tempArr.getClass().equals(Integer[].class)) {

                while(offset<arr.length) {
                    int lastOfFirst=j,lastOfSecond=((j+partLength<=arr.length)?j+partLength:arr.length);

                    //分为三种情况
                    //第一种和第二种:最后两段都是完整的或者最后两段后一段不完整,两个情况相同
                    //第三种:最后只有一段了

                    if(j==arr.length){                      //如果处于第三种情况,直接退出,因为此时只有一个数组了,没有和他相比较的数组了
                        for(int m=i;m<lastOfFirst;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                        break;
                    }

                    while (i < lastOfFirst && j < lastOfSecond) {
                        if ((Integer) arr[i] > (Integer) arr[j]) {
                            tempArr[offset]=arr[i];
                            i++;
                        }else{
                            tempArr[offset]=arr[j];
                            j++;
                        }
                        offset++;
                    }
                    if(i==lastOfFirst){
                        for(int m=j;m<lastOfSecond;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                    }else{
                        for(int m=i;m<lastOfFirst;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                    }

                    i=offset;
                    j=i+partLength<=arr.length?i+partLength:arr.length;     //如果第二段开始位置大于数组长度,则处于第三种情况
                }
            }else{

                while(offset<arr.length) {
                    int lastOfFirst=j,lastOfSecond=((j+partLength<=arr.length)?j+partLength:arr.length);

                    //分为三种情况
                    //第一种和第二种:最后两段都是完整的或者最后两段后一段不完整,两个情况相同
                    //第三种:最后只有一段了

                    if(j==arr.length){                      //如果处于第三种情况,直接退出,因为此时只有一个数组了,没有和他相比较的数组了
                        for(int m=i;m<lastOfFirst;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                        break;
                    }

                    while (i < lastOfFirst && j < lastOfSecond) {
                        if (((String)arr[i]).compareTo((String)arr[j])>0) {
                            tempArr[offset]=arr[i];
                            i++;
                        }else{
                            tempArr[offset]=arr[j];
                            j++;
                        }
                        offset++;
                    }
                    if(i==lastOfFirst){
                        for(int m=j;m<lastOfSecond;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                    }else{
                        for(int m=i;m<lastOfFirst;m++){
                            tempArr[offset]=arr[m];
                            offset++;
                        }
                    }

                    i=offset;
                    j=i+partLength<=arr.length?i+partLength:arr.length;     //如果第二段开始位置大于数组长度,则处于第三种情况
                }
            }
        }
    }
}
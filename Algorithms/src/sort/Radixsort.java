package Sort;

/**
 * Created by LeeAutumn on 10/10/16.
 * blog: leeautumn.net
 */
public class RadixSort {
    public void sort(String[] array){
        //首先获得字符串数组中字符串的最大长度
        int maxLength = 0;
        for(String str : array){
            if(maxLength < str.length()){
                maxLength = str.length();
            }
        }

        //从低位开始进行排序
        //计数排序存在一个隐性问题,当高位数相同,只有低位数不同时,需要确保高位数的排序不会影响到低位数的排序
        for(int i = 1;i <= maxLength;i++){
            //冒泡排序
            for(int j = array.length - 1; j >= 0;j--){
                for(int k = 1; k <= j; k++) {

                    //此处应实现附属的比较,还未实现
                    if(array[k].length() >= i && array[k].charAt(array[k].length()-i) == '-'){
                        continue;
                    }

                    if(!(array[k].length() >= i && array[k-1].length() >=i)){
                        if(array[k].length() < array[k-1].length()) {
                            String temp = array[k - 1];
                            array[k - 1] = array[k];
                            array[k] = temp;
                        }
                    }
                    else if (array[k-1].length() >= i  && array[k].charAt(array[k].length()-i) < array[k-1].charAt(array[k-1].length()-i)) {
                        String temp =  array[k-1];
                        array[k-1]  =  array[k];
                        array[k]    =  temp;
                    }
                }
//                String temp =  array[max];
//                array[max]  =  array[j];
//                array[j]    =  temp;
            }
        }
    }

    public void sort(int[] array){
        String[] temp = new String[array.length];

        for(int i=0 ;i<array.length;i++){
            temp[i] = String.valueOf(array[i]);
        }

        sort(temp);

        for(int i=0 ;i<array.length;i++){
            array[i] = Integer.valueOf(temp[i]);
        }
    }
}

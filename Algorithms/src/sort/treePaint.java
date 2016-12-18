package sort;

/**
 * Created by coolAutumn on 6/19/16.
 */

/**
 * 未完成
 */
public class treePaint {

    //边进行深度遍历边打印出来
    public static void paintTree(int[] array){
        int level=0;
        int numberHasPainted=0;
        int numberOfLevel= (int) Math.pow(2,level);
        for(int i=0;i<array.length;i++){
            for(int j=1;j<numberOfLevel;j++){
                System.out.println();
                numberHasPainted++;
            }
            numberOfLevel=(int)Math.pow(2,level);
        }
    }
}

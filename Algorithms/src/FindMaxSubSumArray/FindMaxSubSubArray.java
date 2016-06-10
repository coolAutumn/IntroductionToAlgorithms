package FindMaxSubSumArray;

/**
 * Created by coolAutumn on 6/10/16.
 */
public class FindMaxSubSubArray {

    //变量s,用于在递归运算中存储一些值
    ExchangeInfo left=new ExchangeInfo();
    ExchangeInfo right=new ExchangeInfo();
    ExchangeInfo cross=new ExchangeInfo();

    public ExchangeInfo findMaxSubSumArray(int[] arr, int low, int high){
        if(low==high){
            ExchangeInfo result=new ExchangeInfo();
            result.setValues(low,high,arr[low]);
            return result;
        }else{
            int mid=(high+low)/2;
            left.setValues(findMaxSubSumArray(arr,low,mid));
            right.setValues(findMaxSubSumArray(arr,mid+1,high));
            cross.setValues(findMaxSumCrossSubArray(arr,low,mid,high));
            if(left.sum>=right.sum && left.sum>=cross.sum){
                return left;
            }else if(right.sum>=left.sum && right.sum>=cross.sum){
                return right;
            }else{
                return cross;
            }
        }
    }

    private ExchangeInfo findMaxSumCrossSubArray(int[] arr, int low, int mid, int high){
        int leftSum=-1;
        int sum=0;
        int maxLeft=mid;
        for(int i=mid;i>=low;i--){
            sum+=arr[i];
            if(sum>leftSum){
                leftSum=sum;
                maxLeft=i;
            }
        }

        int rightSum=0;
        int maxRight=mid+1;
        sum=0;
        for(int j=mid+1;j<=high;j++){
            sum+=arr[j];
            if(sum>rightSum){
                rightSum=sum;
                maxRight=j;
            }
        }

        ExchangeInfo result=new ExchangeInfo();
        result.setValues(maxLeft,maxRight,leftSum+rightSum);
        return result;
    }



}

//定义1个类,用于存储递归过程中传递的信息
class ExchangeInfo {
    int low=-1;
    int high=Integer.MAX_VALUE;
    int sum=Integer.MIN_VALUE;

    public void setValues(int low,int high,int sum){
        this.low=low;
        this.high=high;
        this.sum=sum;
    }

    public void setValues(ExchangeInfo e){
        this.low=e.low;
        this.high=e.high;
        this.sum=e.sum;
    }

    @Override
    public String toString() {
        return "low:"+low+",high:"+high+",sum:"+sum;
    }
}

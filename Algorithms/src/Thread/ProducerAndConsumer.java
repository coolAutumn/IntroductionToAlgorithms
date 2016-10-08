package Thread;

/**
 * Created by coolAutumn on 6/24/16.
 */

/**
 * 此类用来实验生产者和消费者问题
 * 以下类的方法是错误的
 */
public class ProducerAndConsumer {

    boolean binary_signal = true;
    int[] cacheArae = new int[]{0,0,0,0,0,0,0,0,0,0};
    Producer p = new Producer();
    Consumer c = new Consumer();
    long start = System.currentTimeMillis();

    /**
     *  内部类 生产者和消费者
     */
    class Producer implements Runnable{

        @Override
        public void run() {
            //首先进行生产动作,进入临界区
            while (binary_signal){
                System.out.print("\n");
                for(int i=0;;i = (i+1) % 10){
                    if(System.currentTimeMillis() - start > 100){
                        break;
                    }
                    if(cacheArae[i] == 0){
                        cacheArae[i] = 1;
                        binary_signal = false;
                        System.out.print("生产了第"+(i+1)+"个产品\t");
                    }
                }
            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            //进行消费动作,进入临界区
            while (!binary_signal){
                System.out.print("\n");
                for(int i=0;;i = (i+1) % 10){
                    if(System.currentTimeMillis() - start > 100){
                        break;
                    }
                    if(cacheArae[i] == 1){
                        cacheArae[i] = 0;
                        binary_signal = true;
                        System.out.print("消费了第"+(i+1)+"个产品\t");
                    }
                }
            }
        }
    }

    public void start(){
        new Thread(p).start();
        new Thread(c).start();
    }
}

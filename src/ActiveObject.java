import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ActiveObject<T> {
    public interface Consumer<T>{
        void consume(T t);
    }
    public interface Producer<T>{
        T produce();
    }
    BlockingQueue<T> buffer;
    Consumer<T> consumer;
    Producer<T> producer;
    boolean stop;
    boolean produce;

    public ActiveObject(BlockingQueue<T> buffer, Consumer<T> consumer, Producer<T> producer) {
        this.stop = false;
        this.produce = true;
        this.buffer = buffer;
        this.consumer = consumer;
        this.producer = producer;
    }

    public void shutDown(){
        produce = false;
        new Thread(()->{
            while(!buffer.isEmpty()){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}
            }
            stop=true;
        }).start();
    }

    public void active(){
        new Thread(() -> {
            while(!stop){
                try {
                    consumer.consume(buffer.take());
                } catch (InterruptedException e) {}
            }
        }).start();
        new Thread(() -> {
            while(produce){
                buffer.add(producer.produce());
            }
        }).start();
    }

    public static void test(){
        Random r = new Random();
        LinkedBlockingQueue<Double> blockingQueue = new LinkedBlockingQueue<>();
        Consumer<Double> consumer = aDouble -> System.out.println(aDouble*10-5);
        Producer<Double> producer = () -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) { }
            return r.nextDouble();
        };
        ActiveObject<Double> activeObject = new ActiveObject<>(blockingQueue,consumer,producer);
        activeObject.active();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        activeObject.shutDown();
    }
}

package objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Interrupt {
    Thread[] threads;
    AtomicInteger atomicInteger;

    public Interrupt() {
        this.threads = new Thread[2];
        atomicInteger = new AtomicInteger(0);
    }

    public void active(){
        threads[0] = new Thread(() -> {
            while(atomicInteger.get()<50) {
                try {
                    synchronized (threads[0]) {
                        threads[0].wait();
                    }
                } catch (InterruptedException ignored) {}
                System.out.println(atomicInteger.get() + "Thread[0]");
                threads[atomicInteger.incrementAndGet() % 2].interrupt();
            }
        });
        threads[1] = new Thread(()->{
            while(atomicInteger.get()<50) {
                try {
                    synchronized (threads[1]) {
                        threads[1].wait();
                    }
                } catch (InterruptedException ignored) {}
                System.out.println(atomicInteger.get()+"Thread[1]");
                threads[atomicInteger.incrementAndGet()%2].interrupt();
            }
        });
        threads[0].start();
        threads[1].start();
        threads[0].interrupt();
    }

    public static void main(String[] args) {
        new Interrupt().active();
    }
}

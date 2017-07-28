package cn.bingoogolapple.tuning;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/27 上午8:55
 * 描述:
 */
public class Producer implements Runnable {
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
    private Deque<Product> deque;
    private int objectSize;
    private int queueSize;
    private String productName;

    public Producer(int objectSize, int ttl) {
        this.deque = new ArrayDeque<>();
        this.productName = "产品" + objectSize;
        // 单位, 兆(M)
        Integer M = new Integer(1024 * 1024);
        this.objectSize = objectSize * M / 1000;
        this.queueSize = ttl * 1000;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            deque.add(new Product(this.productName + i, objectSize));
            if (deque.size() > queueSize) {
                deque.poll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        executorService.scheduleAtFixedRate(new Producer(100, 5), 0, 100, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(new Producer(50, 50), 0, 100, TimeUnit.MILLISECONDS);
        TimeUnit.MINUTES.sleep(2);
        executorService.shutdownNow();
    }
}
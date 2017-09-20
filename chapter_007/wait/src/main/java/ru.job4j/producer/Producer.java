package ru.job4j.producer;

import java.util.Queue;

/**
 * The class Producer.
 *
 * @author Alexander Mezgin.
 * @version 1.0.
 * @since 20.09.2017.
 */
public class Producer implements Runnable {

    /**
     * The queue.
     */
    private final Queue<Integer> sharedQueue;

    /**
     * The size of queue.
     */
    private final int size;

    /**
     * The Constructor.
     *
     * @param sharedQueue the queue.
     * @param size        the size of queue.
     */
    public Producer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.size = size;
    }

    /**
     * This method is executed when starting the thread.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Produced: " + i);
            try {
                produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The producer.
     *
     * @param i parameter.
     * @throws InterruptedException InterruptedException.
     */
    private void produce(int i) throws InterruptedException {
        while (sharedQueue.size() == this.size) {
            synchronized (this.sharedQueue) {
                System.out.println("The queue is full! The producer is waiting!");
                this.sharedQueue.wait();
            }
        }

        synchronized (this.sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

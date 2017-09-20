package ru.job4j.producer;

import java.util.Queue;

/**
 * The class Consumer.
 *
 * @author Alexander Mezgin.
 * @version 1.0.
 * @since 20.09.2017.
 */
public class Consumer implements Runnable {

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
    public Consumer(Queue<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.size = size;
    }

    /**
     * This method is executed when starting the thread.
     */
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The consumer.
     *
     * @return the value.
     * @throws InterruptedException InterruptedException.
     */
    private int consume() throws InterruptedException {
        while (this.sharedQueue.isEmpty()) {
            synchronized (this.sharedQueue) {
                System.out.println("The queue is empty! The Consumer is waiting.");
                this.sharedQueue.wait();
            }
        }

        synchronized (this.sharedQueue) {
            this.sharedQueue.notifyAll();
            return this.sharedQueue.poll();
        }
    }
}

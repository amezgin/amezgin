package ru.job4j.threadpool;

import java.util.Queue;

/**
 * The class ThreadPool.
 *
 * @author Alexander Mezgin.
 * @version 1.0.
 * @since 20.09.2017.
 */
public class ThreadPool {

    /**
     * The count processor.
     */
    private final int countProcessor = Runtime.getRuntime().availableProcessors();

    /**
     * The queue of work.
     */
    private final Queue<Work> queueWork;

    /**
     * The array of threads.
     */
    private final Thread[] threads = new Thread[this.countProcessor];

    /**
     * The constructor.
     *
     * @param queueWork queue of work.
     */
    public ThreadPool(Queue<Work> queueWork) {
        this.queueWork = queueWork;
    }

    /**
     * Start.
     */
    public void start() {
        for (int i = 0; i < this.countProcessor; i++) {
            this.threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!Thread.currentThread().isInterrupted()) {
                        synchronized (queueWork) {
                            while (queueWork.isEmpty()) {
                                System.out.println(String.format("%s waiting!", Thread.currentThread().getName()));
                                try {
                                    queueWork.wait();
                                } catch (InterruptedException e) {
                                    System.out.println(String.format("%s is interrupted!", Thread.currentThread().getName()));
                                    return;
                                }
                            }
                            queueWork.poll().start();
                            queueWork.notifyAll();
                        }
                    }
                }
            });
            this.threads[i].start();
        }
    }

    /**
     * This method adds the work.
     *
     * @param work the work.
     */
    public void add(Work work) {
        synchronized (this.queueWork) {
            this.queueWork.add(work);
            this.queueWork.notifyAll();
        }
    }

    /**
     * This method stops the threads.
     */
    public void stop() {
        while (!this.queueWork.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread thread : this.threads) {
            thread.interrupt();
        }
    }
}
package ru.job4j;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The class Scheduler.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.12.2017
 */
public class Scheduler {

    /**
     * TimerTask.
     */
    private TimerTask myTask = null;

    /**
     * Timer.
     */
    private Timer timer = null;

    /**
     * The ConnectDB.
     */
    private ConnectDB connectDB = null;

    /**
     * The constructor.
     */
    public Scheduler() {
        this.connectDB  = new ConnectDB();
        this.myTask = new ParserJSOUP(connectDB);
        this.timer = new Timer(true);
    }

    /**
     * This method start the program once a day.
     */
    public void startProgramOnceDay() {
        this.timer.scheduleAtFixedRate(myTask, 0, 60 * 60 * 24 * 1000);
    }

    /**
     * This method start the program the several time a day.
     */
    public void startProgramSeveralTimeDay(int n) {
        this.timer.scheduleAtFixedRate(myTask, 0, 60 * 60 * 24 * 1000 / n);
    }

    /**
     * This method stopped the scheduler.
     */
    public void stopScheduler() {
        this.timer.cancel();
    }
}
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
     * The constructor.
     */
    public Scheduler() {
        this.myTask = new ParserJSOUP();
        this.timer = new Timer(true);
    }

    /**
     * This method start the program once a day.
     */
    public void startProgramOnceDay() {
        ConnectDB connectDB = new ConnectDB();
        connectDB.connectToDB();
        connectDB.createTable();
        connectDB.disconnectDB();
        this.timer.scheduleAtFixedRate(myTask, 0, 60 * 60 * 24 * 1000);
    }

    /**
     * This method start the program the several time a day.
     */
    public void startProgramSeveralTimeDay(int n) {
        ConnectDB connectDB = new ConnectDB();
        connectDB.connectToDB();
        connectDB.createTable();
        this.timer.scheduleAtFixedRate(myTask, 0, 60 * 60 * 24 * 1000 / n);
    }

    /**
     * This method stopped the scheduler.
     */
    public void stopScheduler() {
        this.timer.cancel();
    }
}
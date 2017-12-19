package ru.job4j;

import java.util.Scanner;

/**
 * The class Main.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.12.2017
 */
public class Main {

    /**
     * The main method.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of program starts in the day.");
        int n = scanner.nextInt();
        Scheduler scheduler = null;
        if (n == 1) {
            scheduler = new Scheduler();
            scheduler.startProgramOnceDay();
        } else {
            scheduler = new Scheduler();
            scheduler.startProgramSeveralTimeDay(n);
        }
        try {
            Thread.sleep(2 * 60 * 60 * 24 * 1000);
            scheduler.stopScheduler();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
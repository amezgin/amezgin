package ru.job4j.aquarium;

import java.util.Random;

/**
 * Class Fish.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.10.2017
 */
public class Fish {

    /**
     * The gender for the fish.
     */
    public enum Gender {
        /**
         * The gender.
         */
        MALE, FEMALE
    }

    /**
     * The name of the fish.
     */
    private final String name;

    /**
     * The life cycle of the fish.
     */
    private final long lifeCycle;

    /**
     * The gender of the fish.
     */
    private final Gender gender;

    /**
     * The constructor.
     *
     * @param name the name of the fish.
     */
    public Fish(String name) {
        this.name = name;
        this.lifeCycle = setLifeCycle();
        this.gender = setGender();
    }

    /**
     * This method setup the life cycle of the fish.
     *
     * @return the life cycle.
     */
    private long setLifeCycle() {
        return System.currentTimeMillis() / 1000 + new Random().nextInt(10) + 1;
    }

    /**
     * This method setup the gender of the fish.
     *
     * @return gender.
     */
    private Gender setGender() {
        Gender[] gender = Gender.values();
        return gender[new Random().nextInt(2)];
    }

    /**
     * This method returns the name of the fish.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the life cycle of the fish.
     *
     * @return the life cycle.
     */
    public long getLifeCycle() {
        return lifeCycle;
    }

    /**
     * This method returns the gender of the fish.
     *
     * @return the gender.
     */
    public Gender getGender() {
        return gender;
    }
}
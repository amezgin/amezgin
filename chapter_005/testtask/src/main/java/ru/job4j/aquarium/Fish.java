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

    /**
     * This method checking that first fish meeting with other fish.
     *
     * @param fish fish.
     * @return true if first fish meeting with other fish otherwise false.
     */
    public boolean meet(Fish fish) {
        return !this.equals(fish) && this.getGender() != fish.getGender();
    }

    /**
     * Override equals.
     *
     * @param o fish2.
     * @return true if this fish == fish2.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fish fish = (Fish) o;

        if (lifeCycle != fish.lifeCycle) {
            return false;
        }
        if (name != null ? !name.equals(fish.name) : fish.name != null) {
            return false;
        }
        return gender == fish.gender;
    }

    /**
     * Override hashCode.
     *
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (lifeCycle ^ (lifeCycle >>> 32));
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

}
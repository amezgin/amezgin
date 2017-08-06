package ru.job4j.userstorage;

/**
 * Class User.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
public class User {
    /**
     * The user id.
     */
    private int id;

    /**
     * The user amount.
     */
    private int amount;

    /**
     * The Constructor.
     *
     * @param id     id.
     * @param amount amount.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * This method returns the ID.
     *
     * @return id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * This method returns the amount.
     *
     * @return amount.
     */
    public int getAmount() {
        synchronized (this) {
            return this.amount;
        }
    }

    /**
     * This method set amount.
     *
     * @param amount amount.
     */
    public void setAmount(int amount) {
        synchronized (this) {
            this.amount += amount;
        }
    }
}

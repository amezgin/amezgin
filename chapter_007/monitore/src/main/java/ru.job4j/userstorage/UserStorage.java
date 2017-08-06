package ru.job4j.userstorage;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class UserStorage.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
@ThreadSafe
public class UserStorage {

    /**
     * Storage for User.
     */
    private ConcurrentHashMap<Integer, User> storage = new ConcurrentHashMap<>();

    /**
     * This method adds the user to the storage.
     *
     * @param user user.
     * @return true if user added otherwise false.
     */
    public boolean add(User user) {
        synchronized (this) {
            boolean result = false;
            if (!this.storage.containsKey(user.getId())) {
                this.storage.put(user.getId(), user);
                result = true;
            }
            return result;
        }
    }

    /**
     * This method update the user date in the storage.
     *
     * @param user user.
     * @return true if user date will updated otherwise false.
     */
    public boolean update(User user) {
        synchronized (this) {
            boolean result = false;
            if (this.storage.containsKey(user.getId())) {
                this.storage.put(user.getId(), user);
                result = true;
            }
            return result;
        }
    }

    /**
     * This method removes the user from the storage.
     *
     * @param id id.
     * @return true if user deleted otherwise false.
     */
    public boolean delete(int id) {
        synchronized (this) {
            boolean result = false;
            if (this.storage.containsKey(id)) {
                this.storage.remove(id);
                result = true;
            }
            return result;
        }
    }

    /**
     * This method transfer money from first user amount to second user amount.
     *
     * @param fromId id first user.
     * @param toId   id second user.
     * @param amount amount.
     * @return true if transfer completed otherwise false.
     */
    public boolean transfer(int fromId, int toId, int amount) {
        synchronized (this) {
            boolean result = false;
            if (this.storage.containsKey(fromId) && this.storage.containsKey(toId)
                    && (this.storage.get(fromId).getAmount() - amount >= 0) && amount > 0) {
                this.storage.get(fromId).setAmount(-amount);
                this.storage.get(toId).setAmount(amount);
                result = true;
            }
            return result;
        }
    }

    /**
     * This method return storage.
     *
     * @return storage.
     */
    public ConcurrentHashMap<Integer, User> getStorage() {
        synchronized (this) {
            return this.storage;
        }
    }
}

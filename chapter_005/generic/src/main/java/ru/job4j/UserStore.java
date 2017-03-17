package ru.job4j;

/**
 * The class UserStore.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.03.2017
 */
public class UserStore extends MainStore<User> {

    /**
     * Constructor.
     *
     * @param size size of store.
     */
    public UserStore(int size) {
        super(size);
    }
}

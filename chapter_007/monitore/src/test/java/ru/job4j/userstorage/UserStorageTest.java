package ru.job4j.userstorage;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class UserStorageTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 06.08.2017
 */
public class UserStorageTest {

    /**
     * Test method add() with result true.
     */
    @Test
    public void whenAddOneUserThenStorageContainsOneUserAndReturnTrue() {
        User user = new User(1, 200);
        UserStorage storage = new UserStorage();

        boolean result = storage.add(user);

        assertThat(result, is(true));
        assertThat(storage.getStorage().size(), is(1));
    }

    /**
     * Test method add() with result false.
     */
    @Test
    public void whenAddOneUserThenStorageContainsOneUserAndReturnFalse() {
        User user = new User(1, 200);
        User user1 = new User(1, 300);
        UserStorage storage = new UserStorage();
        storage.add(user);

        boolean result = storage.add(user1);

        assertThat(result, is(false));
        assertThat(storage.getStorage().size(), is(1));
    }

    /**
     * Test method update() with result true.
     */
    @Test
    public void whenUpdateUserThenStorageContainsOneUserAndReturnTrue() {
        User user = new User(1, 200);
        User user1 = new User(1, 300);
        UserStorage storage = new UserStorage();
        storage.add(user);

        boolean result = storage.update(user1);

        assertThat(result, is(true));
        assertThat(storage.getStorage().get(1).getAmount(), is(300));
    }

    /**
     * Test method update() with result false.
     */
    @Test
    public void whenUpdateUserAndStorageNotContainsUserThenStorageContainsOneUserAndReturnFalse() {
        User user = new User(1, 200);
        User user1 = new User(2, 300);
        UserStorage storage = new UserStorage();
        storage.add(user);

        boolean result = storage.update(user1);

        assertThat(result, is(false));
        assertThat(storage.getStorage().size(), is(1));
    }

    /**
     * Test method delete() with result true.
     */
    @Test
    public void whenDeleteOneUserThenStorageContainsZeroUserAndReturnTrue() {
        User user = new User(1, 200);
        UserStorage storage = new UserStorage();
        storage.add(user);

        boolean result = storage.delete(1);

        assertThat(result, is(true));
        assertThat(storage.getStorage().size(), is(0));
    }

    /**
     * Test method delete() with result false.
     */
    @Test
    public void whenDeleteUserAndStorageNotContainsUserThenStorageContainsOneUserAndReturnFalse() {
        User user = new User(1, 200);
        UserStorage storage = new UserStorage();
        storage.add(user);

        boolean result = storage.delete(2);

        assertThat(result, is(false));
        assertThat(storage.getStorage().size(), is(1));
    }

    /**
     * Test method transfer() with result true.
     */
    @Test
    public void whenTransferMoneyFromOneUserThenReturnTrue() {
        User user = new User(1, 200);
        User user1 = new User(2, 500);
        UserStorage storage = new UserStorage();
        storage.add(user);
        storage.add(user1);

        boolean result = storage.transfer(1, 2, 200);

        assertThat(result, is(true));
        assertThat(storage.getStorage().get(1).getAmount(), is(0));
    }

    /**
     * Test method transfer() with result false.
     */
    @Test
    public void whenTransferMoneyFromOneUserThenReturnFalse() {
        User user = new User(1, 200);
        User user1 = new User(2, 500);
        UserStorage storage = new UserStorage();
        storage.add(user);
        storage.add(user1);

        boolean result = storage.transfer(1, 2, 250);

        assertThat(result, is(false));
    }
}
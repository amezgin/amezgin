package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class AnyStoreTest.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.03.2017
 */
public class AnyStoreTest {

    /**
     * User store.
     */
    private UserStore userStore;

    /**
     * Role store.
     */
    private RoleStore roleStore;

    /**
     * Prepare before tests.
     */
    @Before
    public void prepare() {
        this.userStore = new UserStore(3);
        this.roleStore = new RoleStore(3);
    }

    /**
     * Test method get().
     */
    @Test
    public void whenAddUserThenGetUserById() {
        User user = new User();
        user.setId("123");

        userStore.add(user);

        assertThat(userStore.get("123"), is(user));
    }

    /**
     * Test method update().
     */
    @Test
    public void whenUpdateUserThenGetUpdatedUserById() {
        User user = new User();
        user.setId("123");
        userStore.add(user);
        User checked = new User();
        checked.setId("456");

        userStore.update("123", checked);

        assertThat(userStore.get("456"), is(checked));
    }

    /**
     * Test method delete().
     */
    @Test (expected = NoSuchElementException.class)
    public void whenDeleteUserThenReturnMinusOne() {
        Role role = new Role();
        role.setId("123");

        roleStore.delete("123");

        roleStore.get("123");
    }
}
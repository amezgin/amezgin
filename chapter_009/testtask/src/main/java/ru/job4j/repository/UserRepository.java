package ru.job4j.repository;

import ru.job4j.model.Address;
import ru.job4j.model.MusicType;
import ru.job4j.model.Role;
import ru.job4j.model.User;

import java.util.List;

/**
 * The interface UserRepository.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public interface UserRepository {

    /**
     * Add.
     *
     * @param user user.
     */
    void add(User user);

    /**
     * Get user role.
     *
     * @param user user.
     * @return role.
     */
    Role getUserRole(User user);

    /**
     * Get user address.
     *
     * @param user user.
     * @return address.
     */
    Address getUserAddress(User user);

    /**
     * Get user list music.
     *
     * @param user user.
     * @return list music.
     */
    List<MusicType> getUserMusicType(User user);

    /**
     * Get user by address.
     *
     * @param address address.
     * @return user.
     */
    User getUserByAddress(Address address);

    /**
     * Get users by role.
     *
     * @param role role.
     * @return list users.
     */
    List<User> getUserByRole(Role role);

    /**
     * Get users by music type.
     *
     * @param musicType music type.
     * @return list users.
     */
    List<User> getUserByMusicType(MusicType musicType);

    /**
     * Get users with all dependencies.
     *
     * @return list users.
     */
    List<User> getAllUserWithAllDependencies();
}
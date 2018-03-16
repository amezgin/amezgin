package ru.job4j.repository;

import ru.job4j.model.User;

import java.util.List;

/**
 * The interface RoleRepository.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public interface RoleRepository {
    /**
     * Return thr list all users.
     *
     * @return list all users.
     */
    List<User> getAllUserWithRole();
}
package ru.job4j.models;

import java.sql.Timestamp;

/**
 * The class User.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 20.12.2017
 */
public class User {

    /**
     * The user name.
     */
    private final String name;

    /**
     * The user login.
     */
    private final String login;

    /**
     * The user password.
     */
    private final String password;

    /**
     * The user role.
     */
    private final Role role;


    /**
     * The user email.
     */
    private final String email;

    /**
     * The user createDate.
     */
    private final Timestamp createDate;

    /**
     * The constructor.
     *
     * @param name       name.
     * @param login      login.
     * @param password   password.
     * @param role       role.
     * @param email      email.
     * @param createDate createDate.
     */
    public User(String name, String login, String password, Role role, String email, Timestamp createDate) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.createDate = new Timestamp(createDate.getTime());
    }

    /**
     * The getter for the user name.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * The getter for the user login.
     *
     * @return login.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * The getter for the user password.
     *
     * @return password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * The getter for the user role.
     *
     * @return role.
     */
    public Role getRole() {
        return this.role;
    }

    /**
     * The getter for the user email.
     *
     * @return email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * The getter for the user createDate.
     *
     * @return createDate.
     */
    public Timestamp getCreateDate() {
        return new Timestamp(this.createDate.getTime());
    }

    /**
     * Overrides method toString().
     *
     * @return user as string.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", login='" + login + '\''
                + ", role='" + role + '\''
                + ", email='" + email + '\''
                + ", createDate=" + createDate
                + '}';
    }
}
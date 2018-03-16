package ru.job4j.model;

import java.util.List;

/**
 * The class User.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class User {

    /**
     * The id.
     */
    private Integer id;

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
     * The user address.
     */
    private Address address;

    /**
     * The list of the music type.
     */
    private List<MusicType> musicTypeList;

    /**
     * The constructor.
     *
     * @param login         login.
     * @param password      password.
     * @param role          role.
     * @param address       address.
     * @param musicTypeList list of the music type.
     */
    public User(String login, String password, Role role, Address address, List<MusicType> musicTypeList) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.address = address;
        this.musicTypeList = musicTypeList;
    }

    /**
     * The getter for id.
     *
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * The setter for id.
     *
     * @param id id.
     */
    public void setId(Integer id) {
        this.id = id;
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
     * The getter for the user address.
     *
     * @return address.
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * The setter for address.
     *
     * @param address address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * This getter for the list of the music type.
     *
     * @return list of the music type.
     */
    public List<MusicType> getMusicTypeList() {
        return this.musicTypeList;
    }

    /**
     * The setter for list music.
     *
     * @param musicTypeList musicTypeList.
     */
    public void setMusicTypeList(List<MusicType> musicTypeList) {
        this.musicTypeList = musicTypeList;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", role=" + role
                + ", address=" + address
                + ", musicTypeList=" + musicTypeList
                + '}';
    }
}
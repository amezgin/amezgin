package ru.job4j.model;

/**
 * The class Address.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 12.02.2018
 */
public class Address {

    /**
     * The id.
     */
    private Integer id;

    /**
     * The post code.
     */
    private final String postcode;

    /**
     * The city.
     */
    private final String city;

    /**
     * The street.
     */
    private final String street;

    /**
     * The home.
     */
    private final String home;

    /**
     * The user id.
     */
    private Integer userId;

    /**
     * @param postcode postcode.
     * @param city     city.
     * @param street   street.
     * @param home     home.
     * @param userId   user id.
     */
    public Address(String postcode, String city, String street, String home, Integer userId) {
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.home = home;
        this.userId = userId;
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
     * The getter for the postcode.
     *
     * @return postcode.
     */
    public String getPostcode() {
        return this.postcode;
    }

    /**
     * The getter for the city.
     *
     * @return city.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * The getter for the street.
     *
     * @return street.
     */
    public String getStreet() {
        return street;
    }

    /**
     * The getter for the home.
     *
     * @return home.
     */
    public String getHome() {
        return home;
    }

    /**
     * The getter for the user id.
     *
     * @return user id.
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * The setter for user id.
     *
     * @param userId user id.
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
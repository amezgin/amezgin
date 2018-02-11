package ru.job4j.models;

/**
 * The class Role.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 29.12.2017
 */
public class Role {

    /**
     * The id of the role.
     */
    private final int roleId;

    /**
     * The name of the role.
     */
    private final String name;

    /**
     * The constructor.
     *
     * @param roleId role_id.
     * @param name   name.
     */
    public Role(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    /**
     * The getter for the id the role.
     *
     * @return roleId.
     */
    public int getRoleId() {
        return this.roleId;
    }

    /**
     * The getter for the role name.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }
}
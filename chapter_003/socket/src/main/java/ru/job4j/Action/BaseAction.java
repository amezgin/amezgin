package ru.job4j.action;

/**
 * The abstract class BaseAction.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 14.01.2017
 */
public abstract class BaseAction implements UserAction {

    /**
     * Private field name.
     */
    private String name;

    /**
     * The Constructor.
     *
     * @param name applies name
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * This method returns information about what this method does.
     *
     * @return information
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}

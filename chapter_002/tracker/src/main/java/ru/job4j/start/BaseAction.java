package ru.job4j.start;

/**
 * The abstract class BaseAction.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.12.2016
 */
public abstract class BaseAction implements UserAction {

    /**
     * Private field name.
     */
    private String name;

    /**
     * The Constructor.
     * @param name applies name
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     *This method returns information about what this method does.
     *@return information
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}

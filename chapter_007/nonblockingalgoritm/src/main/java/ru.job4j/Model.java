package ru.job4j;

/**
 * Class Model.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 21.09.2017
 */
public class Model {

    /**
     * The name of the model.
     */
    private String name;

    /**
     * The version of the model.
     */
    private volatile int version = 0;

    /**
     * The constructor.
     *
     * @param name the name of the model.
     */
    public Model(String name) {
        this.name = name;
    }

    /**
     * This method return the name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method setup the name.
     *
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method return the version of the model.
     *
     * @return version.
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * This method udate the version of the model.
     */
    public void updateVersion() {
        this.version++;
    }
}
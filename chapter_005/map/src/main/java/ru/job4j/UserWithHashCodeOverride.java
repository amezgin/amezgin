package ru.job4j;

import java.util.Calendar;

/**
 * The class UserWithHashCodeOverride.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.04.2017
 */
public class UserWithHashCodeOverride extends User {

    /**
     * The constructor.
     *
     * @param name     name.
     * @param children children.
     * @param birthday birthday.
     */
    public UserWithHashCodeOverride(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    /**
     * Override the hashCode.
     *
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = this.getName() != null ? this.getName().hashCode() : 0;
        result = 31 * result + this.getChildren();
        result = 31 * result + (this.getBirthday() != null ? this.getBirthday().hashCode() : 0);
        return result;
    }
}

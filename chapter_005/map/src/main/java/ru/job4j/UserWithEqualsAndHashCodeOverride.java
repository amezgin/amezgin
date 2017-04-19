package ru.job4j;

import java.util.Calendar;

/**
 * The class UserWithEqualsAndHashCodeOverride.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 17.04.2017
 */
public class UserWithEqualsAndHashCodeOverride extends User {

    /**
     * The constructor.
     *
     * @param name     name.
     * @param children children.
     * @param birthday birthday.
     */
    public UserWithEqualsAndHashCodeOverride(String name, int children, Calendar birthday) {
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

    /**
     * Override equals.
     *
     * @param o object.
     * @return if object equals this then return true.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (this.getChildren() != user.getChildren()) {
            return false;
        }
        if (this.getName() != null ? !this.getName().equals(user.getName()) : user.getName() != null) {
            return false;
        }
        return this.getBirthday() != null ? this.getBirthday().equals(user.getBirthday()) : user.getBirthday() == null;
    }
}

package ru.job4j;

/**
 * Class User.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 08.10.2017
 */
public class User {
    /**
     * The name of user.
     */
    private String name;

    /**
     * The id of user.
     */
    private int id;

    /**
     * The constructor.
     *
     * @param name name of user.
     * @param id id of user.
     */
    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * This method override the method finalize.
     *
     * @throws Throwable throwable.
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize!");
    }

    /**
     * This method override the method string.
     *
     * @return object representation in string line.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", id=" + id
                + '}';
    }

    /**
     * Tests for gc.
     *
     * @param args arguments from command line.
     * @throws InterruptedException InterruptedException.
     */
    public static void main(String[] args) throws InterruptedException {
        for (int index = 0; index < 400; index++) {
            new User("name", index);
        }
        info();
    }

    /**
     * This method print info about memory usage.
     */
    public static void info() {
        int mb = 1024 * 1024;

        Runtime runtime = Runtime.getRuntime();
        System.out.println("##### Heap utilization statistics [MB] #####");
        System.out.println("Used Memory:"
                + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("Free Memory:"
                + runtime.freeMemory() / mb);
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
    }
}

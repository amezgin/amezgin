package ru.job4j;

/**
 * Class OnlyGetMemberArrays.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.12.2016
 */
public class OnlyGetMemberArrays {

    /**
     * Field of class.
     */
    private final int[] arr = {0, 55, 2, 4, 88, 5};

    /**
     * Method returns the k-value of the array.
     * @param k the cell number of the array
     * @return value
     */
    public int getMemberOfArray(int k) {
        return this.arr[k];
    }

    /**
     * Method returns the length of the array.
     * @return length
     */
    public int getArrayLength() {
        return arr.length;
    }
}

/**
 * Class OnlyGetMemberArrays.
 *
 * @author Alexander Mezgin
 * @version 1.0
 * @since 24.12.2016
 */
class TestClass extends OnlyGetMemberArrays {

    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        for (int i = 0; i < testClass.getArrayLength(); i++) {
            System.out.println(testClass.getMemberOfArray(i));
        }
    }
}
package ru.job4j;

/**
 * Class ArrayDeletDuplicate.
 *
 *@author Alexander Mezgin
 *@version 1.0
 *@since 21.11.2016
 */
public class ArrayDeletDuplicate {

	/**
	* expectArray is array without duplicates.
	*/
    private String[] expectArray;
	/**
	* This method returns an array without duplicates.
	* Check the array. Duplicate values are replaced by null.
	*@param arr a parameter takes an array of string values
	*@return returns an array without duplicates
	*/
    public String[] delDupl(String[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == null) {
                continue;
            }
            if (count == arr.length - 1) {
                break;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    arr[j] = null;
                    count++;
                }
            }
        }

        expectArray = new String[arr.length - count];

        expectArray = reqArray(arr, expectArray);

        return expectArray;
    }

	/**
	* This method will generate the final array.
	*@param originalArray a parameter takes an array of string with null and values
	*@param resultArray a parameter takes an array of string with only null
	*@return returns an array without null
	*/
    private String[] reqArray(String[] originalArray, String[] resultArray) {

        int ind = 0;

        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] != null) {
                resultArray[ind] = originalArray[i];
                ind++;
            }
        }
        return resultArray;
    }
}
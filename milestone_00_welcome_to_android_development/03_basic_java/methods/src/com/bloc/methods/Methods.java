package com.bloc.methods;

import java.lang.reflect.Method;

import com.bloc.test.Test;

public class Methods extends Object {

	// DO NOT MODIFY BELOW
	public static void main(String [] args) {
		Methods methods = new Methods();
		Method method = null;
		if ((method = Test.testMethods(methods)) == null) {
			System.out.println("Excellent, all of your methods worked!\n");
		} else {
			System.out.println("Looks like your \'" + method.getName() + "\' method has an issue with it.\n");
		}
	}
	// DO NOT MODIFY ABOVE


	/*
	 * Returns the logical opposite of a given boolean
	 *
	 * This method returns the logical opposite value
	 * of its given parameter.
	 *
	 * @param original Is the boolean variable which must be flipped
	 * @return the logical opposite of the original
	 */
	public boolean giveMeTheOpposite(boolean original) {
		
		if(original) {
			return false;
		}
		else {
			return true;
		}

	}

	/*
	 * This method reverses the sign of each integer in a
	 * given array
	 *
	 * Given a variable length array consisting of integers,
	 * this method changes the sign of each value found in the
	 * array to its opposite, e.g. {1, 54, -12} becomes
	 * {-1, -54, 12} and {42, -57, 24, -182, 9521} becomes
	 * {-42, 57, -24, 182, -9521}.
	 *
	 * @param numbers The array consisting of values whose
	 * 		  sign must be flipped
	 * @return nothing
	 */
	public void flipTheSign(int[] numbers) {
		
		for(int i = 0; i < numbers.length; ++i) {

			numbers[i] *= -1;

		}

	}


	/*
	 * This method returns an array of booleans based on
	 * comparisons made in a given integer array with an
	 * integer floor.
	 *
	 * Given an array and a floor, this method compares each
	 * value in the array to the floor. If the value at that
	 * index is at least floor or greater, the corresponding
	 * index in a boolean array is set to `true`, `false`
	 * otherwise.
	 * 
	 * E.g. {0, 5, 18, 2} with a floor of 6 returns
	 * {false, false, true, false}
	 * 
	 * {16, 20} with a floor of 21 will return the following
	 * array of booleans: {false, false}
	 *
	 * @param floor The integer to compare each value to
	 * @param someNumbers The array of integers
	 * @return an array of booleans
	 */
	public boolean[] boolsRule(int floor, int[] someNumbers) {
		
		boolean[] returnArray = new boolean[someNumbers.length];

		for(int i = 0; i < someNumbers.length; ++i) {

			if(someNumbers[i] >= floor) {
				returnArray[i] = true;
			}
			else {
				returnArray[i] = false;
			}

		}

		return returnArray;

	}

	/*
	 * Recover the minimum and maximum value found in an
	 * array of numbers.
	 *
	 * This method traverses a given array to discover its
	 * smallest value and its largest value. These two integers
	 * are returned in an array whose 0th index contains
	 * the minumum value and 1st index contains the maximum.
	 *
	 * E.g. given {3, 6, 202, 2, 9986, 5}, this method returns
	 * {2, 9986}
	 *
	 * @param someNumbers The array whose maxmimum and minimum
	 *		  must be recovered
	 * @return an array of length 2: {min, max}
	 */
	public int[] getMinAndMax(int[] someNumbers) {
		
		int[] minMax = new int[2];
		int min = someNumbers[0];
		int max = someNumbers[0];

		for(int i = 1; i < someNumbers.length; ++i) {
			
			if(someNumbers[i] > max) {
				max = someNumbers[i];
			}

			if(someNumbers[i] < min) {
				min = someNumbers[i];
			}

		}

		minMax[0] = min;
		minMax[1] = max;

		return minMax;
	}
}

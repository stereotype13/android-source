package com.bloc.loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bloc.test.Test;

public class Loops extends Object {

	public static void main(String [] args) {
		boolean[] someBools = {true, false, true, true, false, true, false, false};
		boolean temp = false;
		//

		int i = 7;
		int j = 0;
		while(i > 3) {
			temp = someBools[i];
			someBools[i] = someBools[j];
			someBools[j] = temp;
			i--;
			j++;
		}

		if (Test.testBools(someBools)) {
			System.out.print("Your booleans are in proper order!\n");
		} else {
			System.out.print("Something in the while loop…\n");
			System.exit(0);
		}

		int[] numArray = new int[someBools.length];
		// This is known as an in-line conditional
		// learn more here: http://www.cafeaulait.org/course/week2/43.html

		for(int k = 0; k < 8; ++k) {
			numArray[k] = !someBools[k] ? 1 : 0;
		}

		if (Test.testInts(numArray)) {
			System.out.print("And you nailed the number array!\n");
		} else {
			System.out.print("Issue with the numbers…\n");
		}
	}
}

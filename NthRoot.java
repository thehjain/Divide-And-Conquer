//We have given an integer and we have to find
//the nth root of it.

import java.util.*;

class NthRoot {
	public static void main(String[] args) {

		double x = 5;
		int n = 2;

		findRoot(x, n);

	}

	static void findRoot(double x, int n) {
		double low, high;

		if (x >= 0 && x <= 1) {
			low = x;
			high = 1;
		} else {
			low = 1;
			high = x;
		}

		double epsilon = 0.001;
		double guess = (low + high) / 2;

		while (Math.abs((Math.pow(guess, n)) - x) >= epsilon) {
			if (Math.pow(guess, n) > x)
				high = guess;
			else
				low = guess;
			guess = (low + high) / 2;
		}
		System.out.println(guess);
	}

}
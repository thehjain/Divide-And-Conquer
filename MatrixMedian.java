//Here we have given 2d matrix which is row wise sorted
//We have to find the median of this matrix.

//Naive approach is to use another array of size r*c
//and store all the elements in that array and sort that
//array and simply return arr[r*c/2];

//Efficent approach is to take minium and maximum element from
//array and do binary serach

import java.util.*;

class MatrixMedian {

	public static void main(String[] args) {
		int r = 3, c = 3;
		int m[][] = { {1, 3, 5}, {2, 6, 9}, {3, 6, 9} };

		System.out.println("Median is " + binaryMedian(m, r, c));

	}

	static int binaryMedian(int[][] arr, int r, int c) {

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < r; i++) {
			if (arr[i][0] < min)
				min = arr[i][0];
			if (arr[i][c - 1] > max)
				max = arr[i][c - 1];
		}

		int desired = (r * c + 1) / 2;

		while (min < max) {

			int mid = min + (max - min) / 2;
			int place = 0;
			int get = 0;

			for (int i = 0; i < r; i++) {

				get = Arrays.binarySearch(arr[i], mid);

				// If element is not found in the array the
				// binarySearch() method returns
				// (-(insertion_point) - 1). So once we know
				// the insertion point we can find elements
				// Smaller than the searched element by the
				// following calculation

				if (get < 0)
					get = Math.abs(get) - 1;
				// If element is found in the array it returns
				// the index(any index in case of duplicate). So we go to last
				// index of element which will give  the number of
				// elements smaller than the number including
				// the searched element.
				else {
					while (get < arr[i].length && arr[i][get] == mid)
						get += 1;
				}
				place += get;
			}
			if (place < desired)
				min = mid + 1;
			else
				max = mid;
		}
		return min;
	}
}


//Problem is available on geeksforgeeks
//Here we have given a sorted array in which
//all the elements repeat twice instead of one
//element and we have to find that element

//Naive apporach is to lineary traverse the array
//we can simply find the element

//Efficient approach is to use binary search with
//some modification and we can search it in O(logn)

import java.util.*;

class AppearOnce {

	public static void main(String[] args) {

		int[] arr = {1, 1, 2, 4, 4, 5, 5, 6, 6};

		search(arr, 0, arr.length - 1);

	}
	static void search(int[] arr, int low, int high) {

		if (low > high)
			return;
		if (low == high) {
			System.out.println("The requied element is " + arr[low]);
			return;
		}

		int mid = (low + high) / 2;

		if (mid % 2 == 0) {
			if (arr[mid] == arr[mid + 1])
				search(arr, mid + 2, high);
			else
				search(arr, low, mid);
		} else {
			if (arr[mid] == arr[mid - 1])
				search(arr, mid + 1, high);
			else
				search(arr, low, mid - 1);
		}

	}
}


//Question is available on geeksforgeeks
//Here we have given sorted rotated array
//And we have to search an element

//Naive approach is to search an element
//in an array linearly

//Efficient approach is to use binary search
//by first finding the pivot element which
//and than search is both array accordingly

import java.util.*;

class SortedRotatedArray {
	public static void main(String[] args) {

		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int n = arr1.length;
		int key = 3;

		System.out.println("Index of elements is " + pivotBinarySearch(arr1, n, key));

	}
	static int findPivot(int[] arr, int low, int high) {

		if (low > high)
			return -1;
		if (low == high)
			return low;

		int mid = (low + high) / 2;

		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return mid - 1;
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);

	}

	static int binarySearch(int[] arr, int low, int high, int key) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;

		if (arr[mid] == key)
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, mid + 1, high, key);
		return binarySearch(arr, low, mid - 1, key);

	}

	static int pivotBinarySearch(int[] arr, int n, int key) {

		int pivot = findPivot(arr, 0, n - 1);

		if (pivot == -1)
			return binarySearch(arr, 0, n - 1, key);

		if (arr[pivot] == key)
			return pivot;
		if (arr[0] <= key)
			return binarySearch(arr, 0, pivot - 1, key);
		return binarySearch(arr, pivot + 1, n - 1, key);

	}
}


//The more efficient approach is to do it in single function

static int findIndex(int[] arr, int K, int l, int r) {
	if (l > r) {
		return -1;
	}
	int mid = (l + r) / 2;
	if (arr[mid] == K) {
		return mid;
	}
	if (arr[l] <= arr[mid]) {
		if (arr[l] <= K && K <= arr[mid])
			return findIndex(arr, K, l, mid - 1);
		return findIndex(arr, K, mid + 1, r);
	}
	if (K >= arr[mid] && K <= arr[r])
		return findIndex(arr, K, mid + 1, r);
	return findIndex(arr, K, l, mid - 1);
}



//Problem is available on geeksforgeeks

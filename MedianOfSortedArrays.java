//Here we have given two sorted array and we have to find
//the median of given two sorted arrays.

//Naive approach is to merge both array and simply return
//the median of merged array , it will give time complexity
//of O(n+m).

//Efficient Approach is to use binary search dividing the
//array into two parts

//Here we are divind the small array in two parts and
//accordingly dividing the other array in two parts
//and checking corner elements.

double findMedian(int[] A, int[] B) {

	int MAX = Integer.MAX_VALUE;
	int MIN = Integer.MIN_VALUE;

	if (A.length > B.length)
		return findMedian(B, A);

	int x = A.length;
	int y = B.length;

	int low = 0, high = x;

	while (low < high) {

		int partitionX = (low + high) / 2;
		int partitionY = (x + y + 1) / 2 - partitionX;

		int maxLeftX = (partitionX == 0) ? MIN : A[partitionX - 1];
		int minRightX = (partitionX == x) ? MAX : A[partitionX];

		int maxLeftY = (partitionY == 0) ? MIN : B[partitionY - 1];
		int minRightY = (partitionY == y) ? MAX : B[partitionY];

		if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

			if ((x + y) % 2 == 0)
				return (double)(Math.max(maxLeftY, maxLeftX) + Math.min(minRightX, minRightY)) / 2;
			else
				return (double)(Math.max(maxLeftY, maxLeftX));

		} else if (maxLeftX > minRightY)
			high = partitionX - 1;
		else
			low = partitionX + 1;
	}

}


//Problem is available on both leetcode and geeksforgeeks
package Imp_Programs;

public class MaxSumSubRectangle {

	public static int[] maxSumSubArray(int[] arr) {

		int[] lrs = new int[3];

		int maxSum = Integer.MIN_VALUE;
		int tempSum = 0;
		int s = -1, start = 0, end = 0;

		for (int i = 0; i < arr.length; i++) {
			tempSum += arr[i];
			if (tempSum > maxSum) {
				start = s;
				end = i;
				maxSum = tempSum;
			}
			if (tempSum <= 0) {
				tempSum = 0;
				s = i + 1;
			}
		}
		lrs[0] = start;
		lrs[1] = end;
		lrs[2] = maxSum;
		return lrs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = { { 2, 1, -3, -4, 5 }, { 0, 6, 3, 4, 1 }, { 2, -2, -1, 4, -5 }, { -3, 3, 1, 0, 3 } };
		int orgLeft = -1, orgRight = -1, orgTop = -1, orgDown = -1;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < arr[0].length; i++) {
			int[] temp = new int[arr.length];

			for (int j = i; j < arr[0].length; j++) {
				for (int k = 0; k < arr.length; k++) {
					temp[k] += arr[k][j];
				}
				int[] tds = maxSumSubArray(temp);
				if (tds[2] > maxSum) {
					maxSum = tds[2];
					orgTop = tds[0];
					orgDown = tds[1];
					orgLeft = i;
					orgRight = j;
				}

			}
		}
		System.out.println("Max Sum = " + maxSum);
		System.out.println("left right top down  = " + orgLeft + " " + orgRight + " " + orgTop + " " + orgDown);

	}

}

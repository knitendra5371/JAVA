package Imp_Programs;

import java.util.Arrays;

public class InversionCount {

	int merge(int arr[], int low, int mid, int high) {

		int[] left = Arrays.copyOfRange(arr, low, mid + 1);
		int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);

		int i = 0, j = 0, k = low, swaps = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
				swaps += (mid + 1) - (low + i);
			}
		}

		while (i < left.length) {
			arr[k++] = left[i++];
		}
		while (j < right.length) {
			arr[k++] = right[j++];
		}

		return swaps;
	}

	int mSort(int arr[], int low, int high) {
		int inv_count = 0;

		if (low < high) {
			int mid = (low + high) / 2;
			inv_count += mSort(arr, low, mid);
			inv_count += mSort(arr, mid + 1, high);
			inv_count += merge(arr, low, mid, high);

		}

		return inv_count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 20, 6, 4, 5 };
		InversionCount obj = new InversionCount();
		System.out.println("Inversion Count = " + obj.mSort(arr, 0, arr.length - 1));

	}

}

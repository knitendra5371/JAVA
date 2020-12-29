package sorting;

import java.util.ArrayList;

public class MergeSort {

	void merge(ArrayList<Integer> al, int low, int mid, int high) {

		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();

		for (int i = 0; i < mid - low + 1; i++) {
			left.add(al.get(low + i));
		}
		for (int j = 0; j < high - mid; j++) {
			right.add(al.get(mid + j + 1));
		}
		int k = low;
		int i = 0;
		int j = 0;

		while (i < left.size() && j < right.size()) {
			if (left.get(i) <= right.get(j)) {
				al.set(k, left.get(i));
				i++;
			} else {
				al.set(k, right.get(j));
				j++;
			}
			k++;
		}

		while (i < left.size()) {
			al.set(k, left.get(i));
			k++;
			i++;
		}

		while (j < right.size()) {
			al.set(k, right.get(j));
			k++;
			j++;
		}
	}

	void mergeSort(ArrayList<Integer> al, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(al, low, mid);
			mergeSort(al, mid + 1, high);
			merge(al, low, mid, high);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ial = new ArrayList<>();
		ial.add(4);
		ial.add(3);
		ial.add(2);
		ial.add(5);
		ial.add(9);
		ial.add(8);
		ial.add(7);
		ial.add(10);
		ial.add(1);

		MergeSort obj = new MergeSort();
		obj.mergeSort(ial, 0, ial.size() - 1);
		System.out.println(ial);

	}

}

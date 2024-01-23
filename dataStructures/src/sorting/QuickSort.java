package sorting;

import java.util.ArrayList;

public class QuickSort {

	void swap(ArrayList<Integer> al, int i, int j) {
		Integer temp = al.get(i);
		al.set(i, al.get(j));
		al.set(j, temp);
	}

	int partition(ArrayList<Integer> al, int p, int r) {
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (al.get(j) <= al.get(r)) {
				i++;
				swap(al, i, j);
			}
		}
		swap(al, i + 1, r);
		return (i + 1);
	}

	void quickSort(ArrayList<Integer> al, int l, int h) {
		if (l < h) {
			int q = partition(al, l, h);
//			System.out.println("q "+q);
			quickSort(al, l, q - 1);
			quickSort(al, q + 1, h);
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

		QuickSort obj = new QuickSort();

		obj.quickSort(ial, 0, ial.size() - 1);

		System.out.println(ial);

	}

}

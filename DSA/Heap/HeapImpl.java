package heap;

public class HeapImpl {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void heapify(int[] arr, int i) {
		while (i > 0) {
			int j = (i - 1) / 2;
			if (arr[j] > arr[i]) {
				swap(arr, i, j);
			} else {
				break;
			}
			i = (i - 1) / 2;
		}
	}

	public static void delete(int[] arr, int i) {
		if (i < 0 || i >= arr.length) {
			System.out.println("Invalid Index");
			return;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 3, 4, 5, 2, 1 };

		for (int i = 1; i < arr.length; i++) {
			heapify(arr, i);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}

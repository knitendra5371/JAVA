package Imp_Programs;

public class FindMinValueFromSortedAndRotatedArray {

	public static int findMin(int[] arr,int low,int high) {
		
		if(arr[low]<=arr[high]) {
			return arr[low];
		}
//		System.out.println("lol");
		int mid=(low+high)/2;
		
		if(arr[mid]>=arr[low]) {
			return findMin(arr, mid+1, high);
		}else {
			return findMin(arr, low, mid);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] arr= {7,8,9,9,10,10,11,11,1,2,3,4};
//		int[] arr= {1,2,3,9,10,11};
		int[] arr= {1,1,1,1,1,1,1,1,1,1};
		System.out.println(findMin(arr,0,arr.length-1));

	}

}

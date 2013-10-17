package Arrays;
public class BinarySearchNonRecursive {

	public static int find(int[] a, int key) {
	
		int low = 0;
		int high = a.length - 1;

		while(true) {
			
			if(low>high) 
				return -1;

			int mid = (low+high)/2;

			if(a[mid] == key)
				return mid;
			else if(a[mid] < key)
				low = mid + 1;
			else
				high = mid - 1;
		}

	}

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5};
		int key = 3;

		System.out.println(BinarySearchNonRecursive.find(a, key));

	}

}
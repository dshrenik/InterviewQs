package Arrays;

public class BinarySearchRecursive {

	public static int find(int[] a, int key, int low, int high) {
		if(low>high)
			return -1;

		int mid = (low+high)/2;	

		if(a[mid] == key)
			return mid;

		else if(key<a[mid]) {
			return find(a, key, low, mid-1);
		}
		else {
			return find(a, key, mid+1, high);
		}

	}

	public static void main(String[] args) {

		int[] a = {1, 2, 3, 4, 5};
		int key = 4;
		
		System.out.println(BinarySearchRecursive.find(a, key, 0, a.length-1));
	}

}

package Arrays;

public class ReverseArray {

	public static void reverse(int[] a) {

		for (int i=0; i<a.length/2; i++) {
			int temp = a[i];
			a[i] = a[a.length-1-i];
			a[a.length-1-i] = temp;
		}

		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		ReverseArray.reverse(a);
	}

}

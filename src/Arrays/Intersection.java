package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Intersection {

	public static void printIntersection(int[] a, int[] b) {
		Set<Integer> set = new HashSet<Integer>();

		for(int i=0; i<a.length; i++) {
			set.add(a[i]);
		}

		for(int i=0; i<b.length; i++) {
			if(set.contains(b[i])) {
				set.remove(b[i]);
				System.out.println(b[i]);
			}
		}

	}

	public static void printIntersection3(int[] a, int[] b) {
		Map<Integer, Boolean> set = new HashMap<Integer, Boolean>();

		for(int i=0; i<a.length; i++) {
			set.put(a[i], true);
		}

		for(int i=0; i<b.length; i++) {
			if(set.containsKey(b[i]) && set.get(b[i])) {
				set.remove(b[i]);
				System.out.println(b[i]);
			}
		}

	}
	
	public static void printIntersection2(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i=0; i<a.length; i++) {
			// Binary search in b
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {0, 1, 2, 4, 7, 4};
		
		Intersection.printIntersection(a, b);
	}

}

package Misc;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author shrenikdevasani
 *
 */
public class ArraysAndStrings {

	public static boolean hasUniqueCharacters(String str) {

		Set<Character> set = new HashSet<Character>();
		for(int i=0; i<str.length(); i++) {
			if(set.contains(str.charAt(i))) {
				return false;
			}
			else {
				set.add(str.charAt(i));
			}
		}
		return true;

	}
	
	public static boolean isAnagram(String str1, String str2) {

		int numCompleted = 0;
		int numUnique = 0;
		int[] count = new int[256];

		if(str1.length() != str1.length()) {
			return false;
		}

		for(int i=0; i<str1.length(); i++) {
			if(count[str1.charAt(i)] == 0) {
				numUnique++;
			}
			count[str1.charAt(i)]++;
		}

		for(int i=0; i<str2.length(); i++) {
			if(count[str2.charAt(i)] == 0) {
				return false;
			}

			count[str2.charAt(i)]--;

			if(count[str2.charAt(i)] == 0) {
				numCompleted++;
			}

			if(numCompleted == numUnique) {
				return i==(str2.length()-1);
			}
			
		}
		
		return true;
	}

	public static boolean isRotation(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		
		String c = a+a;
		
		return c.contains(b); 
	}
	
	public static void main(String[] args) {
//		System.out.println(ArraysAndStrings.hasUniqueCharacters("abcdaD"));
//		System.out.println(ArraysAndStrings.isAnagram("dad", "dda"));
		System.out.println(ArraysAndStrings.isRotation("dads", "adsd"));
	}


}
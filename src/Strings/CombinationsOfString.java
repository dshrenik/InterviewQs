package Strings;

/**
 * 
 * @author shrenikdevasani
 *
 */
public class CombinationsOfString {

	public static void getCombinations(String str) {

		char[] chars = str.toCharArray();
		int length = str.length();

		doCombination(chars, "", length, 0);
	}

	public static void doCombination(char[] chars, String in, int length, int start) {
		for(int i=start; i<length; i++) {
			System.out.println(in + chars[i]);

//			if(start < length-1) {
				doCombination(chars, in + chars[i], length, i+1);
//			}	
		}	
	}

	public static void main(String[] args) {
		CombinationsOfString.getCombinations("abcd");
	}

}

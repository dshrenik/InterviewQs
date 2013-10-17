package Strings;

public class PermutationsOfString {
	
	public static void printPermutations(String str) {

		char[] chars = str.toCharArray();
		int length = str.length();
		boolean [] used = new boolean[length];
		doPermute(chars, used, "");
		
	}

	public static void doPermute(char[] chars, boolean[] used, String in) {
		if(in.length() == chars.length) {
			System.out.println(in);
		}

		for(int i=0; i<chars.length; i++) {
			StringBuilder sb = new StringBuilder(in);
			if(! used[i]) {
				sb.append(chars[i]);
				used[i] = true;
				doPermute(chars, used, sb.toString());
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {

		PermutationsOfString .printPermutations("abcd");

	}

}

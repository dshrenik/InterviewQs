package Misc;

public class PhoneKeyPad {

	public static String []  s = {null, "abc", "def", "ghi", "jkl", "mno", "pqrst", "uvw", "xyz"};

	public static void Combination(String prefix, String num ) {

		if(num.length()==0) {
			System.out.println(prefix);        	
		}
		else {
			int digit = Integer.parseInt(num.charAt(0) + "");
			String temp = new String();
			temp = s[digit];

			if(temp != null) {
				for(int j=0; j<temp.length(); j++) {
					Combination( prefix+temp.charAt(j), num.substring(1, num.length()) );
				} 
			}
			else {
				Combination( prefix, num.substring(1, num.length()) );                	
			}
		}
	}

	public static void main(String args[]) {
		Combination("", "123");
	}

}
package Strings;

/**
 * 
 * @author shrenikdevasani
 *
 */
public class Compress {
	
	public static String getCompressed(String str) {
		StringBuilder sb = new StringBuilder();
		if(str == null) {
			throw new NullPointerException();
		}
		
		if(str.length() == 0) {
			return "";
		}
		
		int count = 0;
		char currentChar = str.charAt(0);
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == currentChar) {
				count++;
			}
			else {
				sb.append(currentChar).append(count);
				currentChar = str.charAt(i);
				count = 1;
			}
		}
		
		sb.append(currentChar).append(count);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Compress.getCompressed("abbcdddde"));
	}

}

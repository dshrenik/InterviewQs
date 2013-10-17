package Strings;

/**
 * 
 * @author shrenikdevasani
 *
 */
public class Reverse {
	
	public static String getReverseOfString(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public static String getReverseWords(String str) {
		StringBuilder sb = new StringBuilder();
		
		String[] words = str.split(" ");
		for(int i=words.length-1; i>=0; i--) {
			sb.append(words[i]).append(" ");
		}
		
		return (sb.substring(0, sb.length()-1));
	}
	
	public static String getReverseOfEachWord(String str) {
		StringBuilder sb = new StringBuilder();
		
		String[] words = str.split(" ");
		for(int i=0; i<words.length; i++) {
			for(int j=words[i].length()-1; j>=0; j--) {
				sb.append(words[i].charAt(j));				
			}
			sb.append(" ");
		}
		
		return (sb.substring(0, sb.length()-1));
	}
	
	public static void main(String[] args) {
//		System.out.println(Reverse.getReverseOfString("abcd"));
//		System.out.println(Reverse.getReverseWords("quick Brown fox jumped"));
		System.out.println(Reverse.getReverseOfEachWord("quick Brown fox jumped"));
	}

}

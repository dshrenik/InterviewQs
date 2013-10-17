package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author shrenikdevasani
 *
 */
public class AnagramSorter implements Comparator<String>{
	
	public String sort(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	@Override
	public int compare(String str1, String str2) {
		return sort(str1).compareTo(sort(str2));
	}
	
	public static void main(String[] args) {
		String[] strings = {"abcd", "1ba", "abcde", "ggod", "ab1", "dogg", "cdba"};
		Arrays.sort(strings, new AnagramSorter());
		
		for(int i=0; i<strings.length; i++) {
			System.out.println(strings[i]);
		}
	}

}

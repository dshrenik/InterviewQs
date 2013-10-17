package Misc;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeated {

	public static Character getFirstNonRepeated(String str) {
		if(str == null) {
			throw new NullPointerException();
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++) {
			if(map.get(str.charAt(i)) == null) {
				map.put(str.charAt(i), 1);
			}
			else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}

		for(int i=0; i<str.length(); i++) {
			if(map.get(str.charAt(i)) == 1) {
				return str.charAt(i);
			}
		}
		
		return null;
		
	}

	public static void main(String[] args) {
		System.out.println(FirstNonRepeated.getFirstNonRepeated("abcdbcd"));
	}

}

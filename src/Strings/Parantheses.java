package Strings;

public class Parantheses {
	
	public static void main(String[] args) {
		Parantheses.getStrings("", 3,3);
	}

	private static void getStrings(String str, int l, int r) {
		if(l==0 && r==0) {
			System.out.println(str);
		}
		else {
			if(l>0) {
				str = str + "(";
				getStrings(str, l-1, r);
			}
			if(r>l) {
				str = str + ")";
				getStrings(str, l, r-1);
			}
		}
			
	}

}

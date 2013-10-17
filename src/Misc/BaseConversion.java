package Misc;

public class BaseConversion {

	// For x <= 9
	public static String intToBaseX(int n, int x) {
		String str = "";

		while(n>0) {
			int r = n%x;
			str = r + str;
			n = n/x;
		}

		return str;
	}

	public static void main(String[] args) {
		System.out.println(BaseConversion.intToBaseX(12, 2));
	}

}

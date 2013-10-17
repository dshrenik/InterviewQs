package Arrays;

/**
 * 
 * @author shrenikdevasani
 *
 */
public class PascalsTriangle {

	public static void printPascalsTriangle(int n) {
		int triangle[][] = new int[n][n];

		for(int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				if(j==0) {
					triangle[i][j] = 1;
				}
				else {
					triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
				}
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print(triangle[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		PascalsTriangle.printPascalsTriangle(7);
	}

}

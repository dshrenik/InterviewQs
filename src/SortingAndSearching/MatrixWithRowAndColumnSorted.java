package SortingAndSearching;

/**
 * 
 * @author shrenikdevasani
 *
 */
public class MatrixWithRowAndColumnSorted {

	public static boolean find(int[][] a, int key) {
		int row = 0;
		int column = a[0].length - 1;
		
		while(row<a.length && column>=0) {
			if(a[row][column] == key) {
				return true;
			}
			else if(a[row][column] < key) {
				row++;
			}
			else {
				column--;
			}
		}
		
		return false;
	}
	
}

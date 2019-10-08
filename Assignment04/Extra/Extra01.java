package Assignment04.Extra;

import java.util.ArrayList;
import java.util.List;
/* matrix A: n * k  for i in n: iterate every number in the line 
 * 						for j in k: 
 * matrix B: k * m
 */
public class Extra01 {
	public int[][] DotProduct(int[][] A, int[][] B) {
		ArrayList<List<Integer>> product = new ArrayList<>();
		int n = A.length, k = A[0].length, m = B[0].length;
		for(int i = 0; i < n; i++) {
			List<Integer> thisLine = new ArrayList<>();
			for(int j = 0; j < m; j++) {
				int sum = 0;
				for(int ptr = 0; ptr < k; ptr++) {
					sum += A[i][ptr] * B[ptr][j];
				}
				thisLine.add(sum);
			}
			product.add(thisLine);
		}
		int[][] result = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				result[i][j] = product.get(i).get(j);
			}
		}
		return result;
	}
}

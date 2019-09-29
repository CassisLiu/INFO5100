package Assignment03;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
	

	public int[] spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return null;
		
		List<Integer> list = new ArrayList<>();
		int[] dr = new int[] {0,1,0,-1};
		int[] dc = new int[] {1,0,-1,0};
		int di = 0, r = 0, c = 0;
		int row = matrix.length, col = matrix[0].length;
		boolean[][] seen = new boolean[row][col];
		for(int i = 0; i < row * col; i++) {
			seen[r][c] = true;
			list.add(matrix[r][c]);
			int cr = r + dr[di];
			int cc = c + dc[di];
			if(cr < row && cr >= 0 && cc < col && cc >= 0 && !seen[cr][cc]) {
				r = cr;
				c = cc;				
			} else {
				di = (di+1) % 4;
				c += dc[di];
				r += dr[di];
			}
		}
		int[] result = new int[row * col];
		for(int i = 0; i< row* col; i++) {
			result[i] = list.get(i);
		}
	
		return result;
	}
	
}

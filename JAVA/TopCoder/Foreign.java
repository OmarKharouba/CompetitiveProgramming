//import java.util.Arrays;
//
//public class Foreign {
//	public static int[][][] memo = new int[10][10][10];
//	public static int righ;
//	public static int down;
//	public static int dep;
//
//	public static int dp(int i, int j, int k) {
//		if ((i >= 10 || j >= 10) || (k <= 0))
//			return -1;
//		if (memo[i][j][k] != -1) {
//			return memo[i][j][k];
//		}
//		righ = -1;
//		down = -1;
//		dep = -1;
//		if (j + 1 < 10)
//			righ = grid[i][j][k] + dp(i, j + 1, k);
//		if (k + 1 < 10)
//			down = grid[i][j][k] + dp(i, j, k + 1);
//		if (k + 1 < 10)
//			dep = grid[i][j][k] + dp(i + 1, j, k);
//		return Math.max(righ, Math.max(down, dep));
//
//	}
//
//	public static void main(String[] args) {
//
//		for (int cub[][] : memo) {
//			for (int[] sqr : cub) {
//				Arrays.fill(sqr, -1);
//			}
//		}
//
//	}
//
//}

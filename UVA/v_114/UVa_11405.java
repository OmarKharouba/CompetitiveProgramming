import java.io.*;
import java.util.*;

public class UVa_11405 {
	/*
	 * we need to find the shortest possible way to start from the knight's
	 * position and visit all the pawn's locations without moving into an
	 * occupied cell(by king or other pieces), we can try all possible
	 * permutations of the order of visiting the pawn's locations and minimize
	 * the total distance, the distance from any cell to another cell can be
	 * found using BFS
	 */
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		int[] dx = { 1, 1, 2, 2, -1, -1, -2, -2 };
		int[] dy = { 2, -2, 1, -1, 2, -2, 1, -1 };

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			char[][] a = new char[8][8];
			int sx = 0, sy = 0;
			ArrayList<Integer> x = new ArrayList<Integer>();
			ArrayList<Integer> y = new ArrayList<Integer>();
			for (int i = 0; i < 8; i++) {
				a[i] = sc.next().toCharArray();
				for (int j = 0; j < 8; j++) {
					if (a[i][j] == 'k') {
						sx = i;
						sy = j;
					} else if (a[i][j] == 'K' || a[i][j] == 'p')
						a[i][j] = '#';
					else if (a[i][j] == 'P') {
						x.add(i);
						y.add(j);
					}
				}
			}
			int[][][][] dis = new int[8][8][8][8];
			for (int[][][] xx : dis)
				for (int[][] yy : xx)
					for (int[] zz : yy)
						Arrays.fill(zz, -1);
			int[][] vis = new int[8][8];
			int vid = 0;
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++) {
					if (a[i][j] == '#')
						continue;
					vid++;
					Queue<pair> q = new LinkedList<pair>();
					vis[i][j] = vid;
					dis[i][j][i][j] = 0;
					q.add(new pair(i, j));
					while (!q.isEmpty()) {
						pair p = q.poll();
						for (int k = 0; k < 8; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							if (!valid(nx, ny))
								continue;
							if (a[nx][ny] == '#')
								continue;
							if (vis[nx][ny] == vid)
								continue;
							dis[i][j][nx][ny] = dis[i][j][p.x][p.y] + 1;
							vis[nx][ny] = vid;
							q.add(new pair(nx, ny));
						}
					}
				}
			// //////////////
			int min = Integer.MAX_VALUE;
			int[] per = new int[x.size()];
			for (int i = 0; i < x.size(); i++)
				per[i] = i;
			do {
				int curX = sx;
				int curY = sy;
				boolean ok = true;
				int cnt = 0;
				for (int i = 0; i < x.size(); i++) {
					int nxtX = x.get(per[i]);
					int nxtY = y.get(per[i]);
					if (dis[curX][curY][nxtX][nxtY] == -1) {
						ok = false;
						break;
					}
					cnt += dis[curX][curY][nxtX][nxtY];
					curX = nxtX;
					curY = nxtY;
				}
				if (ok)
					min = Math.min(min, cnt);
			} while (nextPermutation(per));
			if (min <= n)
				pw.println("Yes");
			else
				pw.println("No");
		}

		pw.flush();
		pw.close();
	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < 8 && j >= 0 && j < 8;
	}

	static class pair {
		int x, y;

		pair(int a, int b) {
			x = a;
			y = b;
		}
	}

	static boolean nextPermutation(int[] c) {
		int first = getFirst(c);
		if (first == -1)
			return false;
		int toSwap = c.length - 1;
		while (c[first] >= c[toSwap])
			--toSwap;
		swap(c, first++, toSwap);
		toSwap = c.length - 1;
		while (first < toSwap)
			swap(c, first++, toSwap--);
		return true;
	}

	static int getFirst(int[] c) {
		for (int i = c.length - 2; i >= 0; i--)
			if (c[i] < c[i + 1])
				return i;
		return -1;
	}

	static void swap(int[] c, int i, int j) {
		int tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
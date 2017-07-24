package v_001;

import java.io.*;
import java.util.*;

public class UVA116 {
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		pw = new PrintWriter(System.out);

		while (sc.br.ready()) {
			n = sc.nextInt();
			m = sc.nextInt();
			a = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					a[i][j] = sc.nextInt();
			mem = new int[n + 1][m + 1];
			for (int[] x : mem)
				Arrays.fill(x, -1);
			int ans = inf;
			for (int i = 0; i < n; i++)
				ans = Math.min(ans, dp(i, 0));

			for (int i = 0; i < n; i++)
				if (dp(i, 0) == ans) {
					print(i, 0);
					break;
				}

			pw.println(ans);
		}

		pw.flush();
		pw.close();
	}

	static PrintWriter pw;
	static int n, m;
	static int inf = (int) 1e8;
	static int[][] mem;
	static int[][] a;

	public static int dp(int i, int j) {
		if (j == m)
			return 0;
		if (mem[i][j] != -1)
			return mem[i][j];
		int ans = dp(i, j + 1);
		ans = Math.min(ans, dp((i + 1) % n, j + 1));
		ans = Math.min(ans, dp((i + n - 1) % n, j + 1));
		ans += a[i][j];
		return mem[i][j] = ans;
	}

	public static void print(int i, int j) {
		if (j == m)
			return;

		if (j == m - 1)
			pw.println(i + 1);
		else
			pw.print((i + 1) + " ");
		
		int [] next=new int [3];
		next[0]=i;
		next[1]=(i+1)%n;
		next[2]=(i+n-1)%n;
		Arrays.sort(next);
		
		int best = dp(i, j) - a[i][j];
		
		if (best == dp(next[0], j + 1)) {
			print(next[0], j + 1);
		} else if (best == dp(next[1], j + 1)) {
			print(next[1], j + 1);
		} else {
			print(next[2], j + 1);
		}
	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("test.in")));
			} catch (FileNotFoundException e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
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

package v_107;

import java.io.*;
import java.util.*;

public class UVA10755 {
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out, true);

		int t = sc.nextInt();

		while (t-- > 0) {
			int C = sc.nextInt() + 1;
			int A = sc.nextInt() + 1;
			int B = sc.nextInt() + 1;

			long[][][] a = new long[C][A][B];
			long[][][] cum = new long[C][A][B];
			for (int k = 1; k < C; k++)
				for (int i = 1; i < A; i++)
					for (int j = 1; j < B; j++)
						a[k][i][j] = sc.nextLong();
			for (int k = 1; k < C; k++) {
				long[][] cum2 = new long[A][B];
				for (int i = 1; i < A; i++)
					for (int j = 1; j < B; j++) {
						cum2[i][j] = a[k][i][j] + cum2[i][j - 1]
								+ cum2[i - 1][j] - cum2[i - 1][j - 1];
						cum[k][i][j] = cum[k - 1][i][j] + cum2[i][j];
					}
			}
			long max = Long.MIN_VALUE;

			for (int i1 = 1; i1 < A; i1++)
				for (int j1 = 1; j1 < B; j1++)
					for (int k1 = 1; k1 < C; k1++)
						for (int i2 = i1; i2 < A; i2++)
							for (int j2 = j1; j2 < B; j2++)
								for (int k2 = k1; k2 < C; k2++) {

									long ans = cum[k2][i2][j2];

									ans -= cum[k2][i2][j1 - 1];
									ans -= cum[k2][i1 - 1][j2];
									ans -= cum[k1 - 1][i2][j2];

									ans += cum[k1 - 1][i2][j1 - 1];
									ans += cum[k2][i1 - 1][j1 - 1];
									ans += cum[k1 - 1][i1 - 1][j2];

									ans -= cum[k1 - 1][i1 - 1][j1 - 1];

									max = Math.max(max, ans);
								}

			pw.println(max);
			if(t>0)
				pw.println();
		}

		pw.flush();
		pw.close();
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

		boolean ready() throws Exception {
			return br.ready();
		}

	}
}

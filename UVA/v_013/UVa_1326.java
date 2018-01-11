import java.io.*;
import java.util.*;

public class UVa_1326 {
	/*
	 * we can try all possible subsets of bones and find the maximum subset that
	 * satisfies the conditions, for any subset to be valid, it has to contain
	 * an even number of each letter, representing each bone with a mask to
	 * represent the letters it contains will reduce the problem to : 
	 * find the maximum subset of bones with XOR equal to zero
	 */
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);
		while (sc.br.ready()) {
			n = sc.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (char c : s.toCharArray())
					a[i] |= (1 << (c - 'A'));
			}
			ansMsk = 0;
			max = 0;
			solve(0, 0, 0);
			pw.println(max);
			boolean f = true;
			for (int i = 0; i < n; i++) {
				if ((ansMsk & (1 << i)) != 0) {
					if (!f)
						pw.print(" ");
					pw.print(i + 1);
					f = false;
				}
			}
			pw.println();
		}
		pw.flush();
		pw.close();
	}

	static int n;
	static int[] a;
	static int max, ansMsk;

	static void solve(int i, int val, int msk) {
		if (i == n) {
			if (val == 0 && Integer.bitCount(msk) > max) {
				max = Integer.bitCount(msk);
				ansMsk = msk;
			}
			return;
		}
		solve(i + 1, val ^ a[i], msk | (1 << i));
		solve(i + 1, val, msk);
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
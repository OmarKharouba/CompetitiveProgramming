

import java.io.*;
import java.util.*;

public class Timus_1689 {

	/*
	 * since the maximum length of the groove is <=1e5, and all input values are
	 * integers, we can try every possible left end of the bar and count the
	 * number of harmed worms, and choose the start position with the minimum
	 * number of harmed worms, to calculate this number in a fast way, we can
	 * build a cumulative sum of the number of worms at every position , and
	 * knowing the start and end of the two plates of the bar, we can count the
	 * harmed worms, take care of the cases where there is a worm covered by
	 * both the plates
	 */

	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		int g = sc.nextInt();
		int w = sc.nextInt();
		int b = sc.nextInt();
		int p = sc.nextInt();
		int n = sc.nextInt();
		int[] c = new int[g + 1];
		for (int i = 0; i < n; i++)
			c[sc.nextInt()]++;
		for (int i = 1; i <= g; i++)
			c[i] += c[i - 1];
		int min = n;
		int ans = 0;
		for (int st = 0; st + b <= g; st++) {
			int tot = c[st + b - 1] - (st - w + 1 > 0 ? c[st - w] : 0);
			if (w <= b - 2 * p)
				tot -= (c[st + b - p - w] - (st + p > 0 ? c[st + p - 1] : 0));
			if (tot < min) {
				min = tot;
				ans = st;
			}
		}
		pw.println(ans);
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
	}
}
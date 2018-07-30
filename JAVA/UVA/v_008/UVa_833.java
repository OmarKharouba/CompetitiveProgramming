import java.io.*;
import java.util.*;

public class UVa_833 {
	/*
	 * for each segment, save the next segment below it, also for each point
	 * find the first segment below it, then follow its chain till you reach the
	 * ground the X coordinate of the lower side of last segment is the answer
	 * Complexity : O(N^2)
	 */
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		int t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			a = new LineSegent[n];
			nxt = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = new LineSegent(new Point(sc.nextInt(), sc.nextInt()),
						new Point(sc.nextInt(), sc.nextInt()));
			for (int i = 0; i < n; i++) {
				int below = -1;
				double maxY = -1;
				int x = a[i].p.x;
				int y = a[i].p.y;
				if (a[i].q.y < a[i].p.y) {
					x = a[i].q.x;
					y = a[i].q.y;
				}
				for (int j = 0; j < n; j++) {
					if (j == i)
						continue;
					double tt = 1.0 * (x - a[j].p.x) / (a[j].q.x - a[j].p.x);
					if (tt < 0 || tt > 1)
						continue;
					double yy = a[j].p.y + (a[j].q.y - a[j].p.y) * tt;
					if (yy < y && yy > maxY) {
						maxY = yy;
						below = j;
					}
				}
				nxt[i] = below;
			}
			int q = sc.nextInt();
			while (q-- > 0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int below = -1;
				double maxY = -1;
				for (int j = 0; j < n; j++) {
					double tt = 1.0 * (x - a[j].p.x) / (a[j].q.x - a[j].p.x);
					if (tt < 0 || tt > 1)
						continue;
					double yy = a[j].p.y + (a[j].q.y - a[j].p.y) * tt;
					if (yy < y && yy > maxY) {
						maxY = yy;
						below = j;
					}
				}
				if (below == -1)
					pw.println(x);
				else
					pw.println(go(below));
			}
			if (t > 0)
				pw.println();
		}

		pw.flush();
		pw.close();
	}

	static int n;
	static LineSegent[] a;
	static int[] nxt;

	static int go(int i) {
		if (nxt[i] != -1)
			return go(nxt[i]);
		int x = a[i].p.x;
		if (a[i].q.y < a[i].p.y)
			x = a[i].q.x;
		return x;
	}

	static class LineSegent {
		Point p, q;

		LineSegent(Point a, Point b) {
			p = a;
			q = b;
		}
	}

	static class Point {
		int x, y;

		Point(int a, int b) {
			x = a;
			y = b;
		}
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
import java.io.*;
import java.util.*;

public class UVa_10357 {
	/*
	 * for each ball we need to find the time at which it hit the ground (that
	 * is the time when Z=0 or -ve), this can be obtained by solving the
	 * quadratic equation describing the motion in the Z direction, using this
	 * value of t , we can substitute in the X and Y equations to find the
	 * location the ball falls in, and then for each player we can calculate the
	 * time at which he can reach that location
	 */
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		String s = sc.next();
		String[] sa = s.split("=");
		int n = Integer.parseInt(sa[1]);
		int[] x = new int[n];
		int[] y = new int[n];
		int[] v = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		s = sc.next();
		sa = s.split("=");
		int q = Integer.parseInt(sa[1]);
		for (int i = 1; i <= q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			int f = sc.nextInt();
			int g = sc.nextInt();

			int t1 = (int) Math.ceil((-b + Math.sqrt(b * b - 4 * a * c))
					/ (2.0 * a));
			int t2 = (int) Math.ceil((-b - Math.sqrt(b * b - 4 * a * c))
					/ (2.0 * a));
			int t = t1;
			if (t <= 0 || (t2 > 0 && t2 < t1))
				t = t2;
			int xp = d * t + e;
			int yp = f * t + g;
			boolean foul = xp < 0 || yp < 0;
			boolean caught = false;
			for (int j = 0; j < n; j++) {
				double dis = new Point(x[j], y[j]).dist(new Point(xp, yp));
				if (dis / v[j] <= t)
					caught = true;
			}
			String res = foul ? "foul" : caught ? "caught" : "safe";
			pw.printf("Ball %d was %s at (%d,%d)\n", i, res, xp, yp);
		}

		pw.flush();
		pw.close();
	}

	static final double EPS = 1e-9;

	static class Point {

		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}

		public double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		static double sq(double x) {
			return x * x;
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
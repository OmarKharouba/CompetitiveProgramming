import java.io.*;
import java.util.*;

public class UVa_10245 {
	/*
	 * just a direct application of the line sweep closest pair algorithm
	 */
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			Point[] a = new Point[n];
			for (int i = 0; i < n; i++)
				a[i] = new Point(sc.nextDouble(), sc.nextDouble());
			double d = closest_pair(a);
			if (d >= 10000)
				pw.println("INFINITY");
			else
				pw.printf("%.4f\n", d);
		}

		pw.flush();
		pw.close();
	}

	static double eps = 1e-9;
	static double inf = 1e9;

	public static double closest_pair(Point[] a) {
		int n = a.length;
		double d = inf;
		Arrays.sort(a, new comX());
		TreeSet<Point> active = new TreeSet<Point>(new comY());
		active.add(a[0]);
		int left = 0;
		for (int i = 1; i < n; i++) {
			while (left < i && a[i].x - a[left].x > d + eps)
				active.remove(a[left++]);
			Point from = new Point(a[i].x, a[i].y - d);
			Point to = new Point(a[i].x, a[i].y + d);
			for (Point p : active.subSet(from, to))
				d = Math.min(d, p.dis(a[i]));
			active.add(a[i]);
		}
		return d;
	}

	static class Point {
		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}

		double dis(Point p) {
			return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
		}
	}

	static int com(double a, double b) {
		return Math.abs(a - b) < eps ? 0 : a > b ? 1 : -1;
	}

	static class comX implements Comparator<Point> {
		public int compare(Point a, Point b) {
			return com(a.x, b.x) != 0 ? com(a.x, b.x) : com(a.y, b.y);
		}
	}

	static class comY implements Comparator<Point> {
		public int compare(Point a, Point b) {
			return com(a.y, b.y) != 0 ? com(a.y, b.y) : com(a.x, b.x);
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
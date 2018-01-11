import java.io.*;
import java.util.*;

public class UVa_10005 {
	/*
	 * the "smallest" circle that contains a polygon has to touch at least two
	 * vertices of it, so we can try all possible pairs of vertices and try the
	 * two circles passing through them with radius R, and check if all points
	 * are inside the circle 
	 * Complexity : O(N^3)
	 */

	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);
		double eps = 1e-9;
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			Point[] a = new Point[n];
			boolean ok = false;
			for (int i = 0; i < n; i++)
				a[i] = new Point(sc.nextDouble(), sc.nextDouble());
			double r = sc.nextDouble();
			loop: for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++) {
					double d = 0.5 * a[i].dis(a[j]);
					if (r + eps < d) {
						ok = false;
						break loop;
					}
					double h = Math.sqrt(r * r - d * d);

					double dx = a[j].x - a[i].x;
					double dy = a[j].y - a[i].y;

					double ang = Math.atan(dy / dx);

					double midX = 0.5 * (a[i].x + a[j].x);
					double midY = 0.5 * (a[i].y + a[j].y);

					double c = Math.cos(ang);
					double s = Math.sin(ang);

					double cX = midX - h * s;
					double cY = midY + h * c;
					Point p = new Point(cX, cY);

					boolean f = true;
					for (int k = 0; k < n; k++)
						if (p.dis(a[k]) > r)
							f = false;
					ok |= f;

					cX = midX + h * s;
					cY = midY - h * c;
					p = new Point(cX, cY);

					f = true;
					for (int k = 0; k < n; k++)
						if (p.dis(a[k]) > r)
							f = false;
					ok |= f;
				}
			if (ok)
				pw.println("The polygon can be packed in the circle.");
			else
				pw.println("There is no way of packing that polygon.");
		}

		pw.flush();
		pw.close();
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
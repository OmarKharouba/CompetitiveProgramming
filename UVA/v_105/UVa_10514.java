import java.io.*;
import java.util.*;

public class UVa_10514 {
	/*
	 * we can construct a graph, in witch each island is represented as a
	 * vertex, also the two sides of the river as represented by two vertices,
	 * the shortest distance between every pair of islands is represented by an
	 * edge between the corresponding vertices, the answer is the shortest path
	 * between the two sides of the river, this can be calculated using
	 * dijkstra's algorithm
	 */
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		int t = sc.nextInt();
		while (t-- > 0) {
			int r1 = sc.nextInt();
			int r2 = sc.nextInt();
			int n = sc.nextInt();
			V = n + 2;
			adj = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adj[i] = new ArrayList<Edge>();
			Point[][] input = new Point[V][];
			input[0] = new Point[r1];
			input[V - 1] = new Point[r2];
			for (int i = 0; i < r1; i++)
				input[0][i] = new Point(sc.nextDouble(), sc.nextDouble());
			for (int i = 0; i < r2; i++)
				input[V - 1][i] = new Point(sc.nextDouble(), sc.nextDouble());
			for (int i = 1; i <= n; i++) {
				int c = sc.nextInt();
				input[i] = new Point[c];
				for (int j = 0; j < c; j++)
					input[i][j] = new Point(sc.nextDouble(), sc.nextDouble());
			}
			for (int i = 0; i < V; i++)
				for (int j = i + 1; j < V; j++) {
					double min = INF;
					for (int k = 0; k < input[i].length; k++) {
						for (int h = 0; h < input[j].length; h++) {
							if (j == V - 1 && h == input[j].length - 1)
								continue;
							min = Math
									.min(min,
											distToLineSegment(input[i][k],
													input[j][h],
													input[j][(h + 1)
															% input[j].length]));
						}
					}
					for (int k = 0; k < input[j].length; k++) {
						for (int h = 0; h < input[i].length; h++) {
							if (i == 0 && h == input[i].length - 1)
								continue;
							min = Math
									.min(min,
											distToLineSegment(input[j][k],
													input[i][h],
													input[i][(h + 1)
															% input[i].length]));
						}
					}
					adj[i].add(new Edge(j, min));
					adj[j].add(new Edge(i, min));
				}
			pw.printf("%.3f\n", dijkstra(0, V - 1));
		}

		pw.flush();
		pw.close();
	}

	static int V;
	static ArrayList<Edge>[] adj;

	static final double INF = 1e9;

	static double dijkstra(int S, int T) // O(E log E)
	{
		double[] dist = new double[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[S] = 0;
		pq.add(new Edge(S, 0)); // may add more in case of MSSP (Mult-Source)
		while (!pq.isEmpty()) {
			Edge cur = pq.remove();
			if (cur.node == T) // remove if all computations are needed
				return dist[T];
			if (cur.cost > dist[cur.node]) // lazy deletion
				continue;
			for (Edge nxt : adj[cur.node])
				if (cur.cost + nxt.cost < dist[nxt.node])
					pq.add(new Edge(nxt.node, dist[nxt.node] = cur.cost
							+ nxt.cost));
		}
		return -1;
	}

	static class Edge implements Comparable<Edge> {
		int node;
		double cost;

		Edge(int a, double b) {
			node = a;
			cost = b;
		}

		public int compareTo(Edge e) {
			return Math.abs(cost - e.cost) < EPS ? 0 : cost > e.cost ? 1 : -1;
		}
	}

	static final double EPS = 1e-9;

	static class Vector {
		double x, y;

		Vector(double a, double b) {
			x = a;
			y = b;
		}

		Vector(Point a, Point b) {
			this(b.x - a.x, b.y - a.y);
		}

		Vector scale(double s) {
			return new Vector(x * s, y * s);
		}

		double dot(Vector v) {
			return (x * v.x + y * v.y);
		}

		double norm2() {
			return x * x + y * y;
		}
	}

	static double distToLineSegment(Point p, Point a, Point b) {
		Vector ap = new Vector(a, p), ab = new Vector(a, b);
		double u = ap.dot(ab) / ab.norm2();
		if (u < 0.0)
			return p.dist(a);
		if (u > 1.0)
			return p.dist(b);
		return distToLine(p, a, b);
	}

	static double distToLine(Point p, Point a, Point b) // distance between
														// point p and a line
														// defined by points a,
														// b (a != b)
	{
		if (a.compareTo(b) == 0)
			return p.dist(a);
		// formula: c = a + u * ab
		Vector ap = new Vector(a, p), ab = new Vector(a, b);
		double u = ap.dot(ab) / ab.norm2();
		Point c = a.translate(ab.scale(u));
		return p.dist(c);
	}

	static class Point {
		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}

		public int compareTo(Point p) {
			if (Math.abs(x - p.x) > EPS)
				return x > p.x ? 1 : -1;
			if (Math.abs(y - p.y) > EPS)
				return y > p.y ? 1 : -1;
			return 0;
		}

		Point translate(Vector v) {
			return new Point(x + v.x, y + v.y);
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
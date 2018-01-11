import java.io.*;
import java.util.*;

public class UVa_1234 {
	/*
	 * assume we have chosen some edges of the graph to put cameras in, then the
	 * remaining part of the graph can not contain any cycle because if it
	 * contains a cycle, then at least one of its edges should have a camera in
	 * it, so we can think of the reverse of the problem, find the maximum
	 * possible subgraph that does not contain any cycle(tree) and has the
	 * maximum sum of edges, that is a maximum spanning tree, so the answer is :
	 * the total weight of the graph - the weight of the maximum spanning tree
	 */
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		int t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			adj = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adj[i] = new ArrayList<Edge>();
			int m = sc.nextInt();
			int sum = 0;
			while (m-- > 0) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				int c = sc.nextInt();
				sum += c;
				adj[u].add(new Edge(v, c));
				adj[v].add(new Edge(u, c));
			}
			pw.println(sum - prim());
		}

		pw.flush();
		pw.close();
	}

	static ArrayList<Edge>[] adj;
	static int n;

	static int prim() // O(E log E)
	{
		int mst = 0;
		boolean[] visited = new boolean[n];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.remove();
			if (visited[cur.node])
				continue;
			visited[cur.node] = true;
			mst += cur.cost;
			for (Edge nxt : adj[cur.node])
				if (!visited[nxt.node])
					pq.add(nxt);
		}
		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int node, cost;

		Edge(int a, int b) {
			node = a;
			cost = b;
		}

		public int compareTo(Edge e) {
			return e.cost - cost;
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
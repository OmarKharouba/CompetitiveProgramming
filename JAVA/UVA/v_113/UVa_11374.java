import java.io.*;
import java.util.*;

public class UVa_11374 {
	/*
	 * we have two options, either not to use the commercial ticket or to use
	 * it, in the first case, we can construct a graph using the first type of
	 * routes only and find the shortest path between the source and
	 * destination, then we can try each commercial route by adding it to the
	 * graph and finding the shortest path then removing it
	 */
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);
		boolean ff = true;
		while (sc.br.ready()) {
			if (!ff)
				pw.println();

			n = sc.nextInt();
			adj = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adj[i] = new ArrayList<Edge>();
			par = new int[n];
			int src = sc.nextInt() - 1;
			int snk = sc.nextInt() - 1;
			int m = sc.nextInt();
			while (m-- > 0) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				int c = sc.nextInt();
				adj[u].add(new Edge(v, c));
				adj[v].add(new Edge(u, c));
			}
			int min = dijkstra(src, snk);
			int[] seq = Arrays.copyOf(par, par.length);
			boolean used = false;
			int usedIn = -1;
			int k = sc.nextInt();
			while (k-- > 0) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				int c = sc.nextInt();
				adj[u].add(new Edge(v, c));
				adj[v].add(new Edge(u, c));
				int cur = dijkstra(src, snk);
				if (cur < min) {
					min = cur;
					seq = Arrays.copyOf(par, par.length);
					used = true;
					usedIn = u + 1;
					if (seq[u] == v)
						usedIn = v + 1;
				}
				adj[u].remove(adj[u].size() - 1);
				adj[v].remove(adj[v].size() - 1);
			}
			int cur = snk;
			Stack<Integer> stack = new Stack<Integer>();
			while (cur != -1) {
				stack.add(cur + 1);
				cur = seq[cur];
			}
			boolean f = true;
			while (!stack.isEmpty()) {
				if (!f)
					pw.print(" ");
				pw.print(stack.pop());
				f = false;
			}
			pw.println();
			if (!used)
				pw.println("Ticket Not Used");
			else
				pw.println(usedIn);
			pw.println(min);

			ff = false;
		}
		pw.flush();
		pw.close();
	}

	static int n;
	static ArrayList<Edge>[] adj;
	static int[] par;

	static final int INF = (int) 1e9;

	static int dijkstra(int S, int T) // O(E log E)
	{
		Arrays.fill(par, -1);
		int[] dist = new int[n];
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
				if (cur.cost + nxt.cost < dist[nxt.node]) {
					par[nxt.node] = cur.node;
					pq.add(new Edge(nxt.node, dist[nxt.node] = cur.cost
							+ nxt.cost));
				}
		}
		return -1;
	}

	static class Edge implements Comparable<Edge> {
		int node, cost;

		Edge(int a, int b) {
			node = a;
			cost = b;
		}

		public int compareTo(Edge e) {
			return cost - e.cost;
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
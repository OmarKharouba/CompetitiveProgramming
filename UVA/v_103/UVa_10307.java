import java.io.*;
import java.util.*;

public class UVa_10307 {
	/*
	 * we have to start at the position that contains the letter 'S' and visit
	 * all positions that contain the letter 'A', and at every such position, we
	 * can split into two or more groups to visit the remaining places, and the
	 * total cost is the summation of the distances followed to visit all these
	 * locations, the problem can be reduced to -> find a tree that passes by
	 * all positions in the grid that contains the letters 'A' or 'S' and has
	 * the minimum total cost, that is obviously a minimum spanning tree
	 */
	public static void main(String[] args) throws Throwable {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] sa = br.readLine().split(" ");
			m = Integer.parseInt(sa[0]);
			n = Integer.parseInt(sa[1]);
			a = new char[n][m];
			for (int i = 0; i < n; i++)
				a[i] = br.readLine().toCharArray();
			int[][] id = new int[n][m];
			V = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < a[i].length; j++)
					if (a[i][j] == 'A' || a[i][j] == 'S')
						id[i][j] = V++;
			adj = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adj[i] = new ArrayList<Edge>();
			int[][] vis = new int[n][m];
			int vid = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < a[i].length; j++) {
					if (a[i][j] != 'S' && a[i][j] != 'A')
						continue;
					vid++;
					int[][] dis = new int[n][m];
					Queue<Integer> qx = new LinkedList<Integer>();
					Queue<Integer> qy = new LinkedList<Integer>();
					vis[i][j] = vid;
					qx.add(i);
					qy.add(j);
					while (!qx.isEmpty()) {
						int x = qx.poll();
						int y = qy.poll();
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if (!valid(nx, ny))
								continue;
							if (vis[nx][ny] == vid)
								continue;
							vis[nx][ny] = vid;
							dis[nx][ny] = dis[x][y] + 1;
							if (a[nx][ny] != ' ')
								adj[id[i][j]].add(new Edge(id[nx][ny],
										dis[nx][ny]));
							qx.add(nx);
							qy.add(ny);
						}
					}
				}
			pw.println(prim());
		}

		pw.flush();
		pw.close();
	}

	static int n, m;
	static char[][] a;

	static ArrayList<Edge>[] adj;
	static int V;

	static int prim() // O(E log E)
	{
		int mst = 0;
		boolean[] visited = new boolean[V];
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
			return cost - e.cost;
		}

	}

	static boolean valid(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < a[i].length && a[i][j] != '#';
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
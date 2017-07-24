package v_113;

import java.io.*;
import java.util.*;

public class UVA11381 {
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out, true);

		int tc = sc.nextInt();
		while (tc-- > 0) {
			int [][] map=new int [26][26];
			char[] s = sc.next().toCharArray();
			char[] t = sc.next().toCharArray();
			int n = s.length;
			int m = t.length;
			for (int i = 0; i < n - 1; i++) {
				if (map[s[i]-'a'][s[i+1]-'a']==0)
					map[s[i]-'a'][s[i+1]-'a']=(i + 1) * (i + 1);
			}
			N = m * 2 + 2;
			M = 2 * (m * (m + 2));
			init();
			for (int i = 0; i < m - 1; i++)
				for (int j = i + 1; j < m; j++) {
					if (map[t[i]-'a'][t[j]-'a']>0) {
						addAugEdge(i+1, m+j+1, map[t[i]-'a'][t[j]-'a'], 1);
					}
				}
			for(int i=1;i<=m;i++)
				addAugEdge(0, i, 0, 1);
			for(int i=1;i<=m;i++)
				addAugEdge(m+i, N-1, 0, 1);
			pair p=minCostMaxFlow(0, N-1);
			pw.println(m-p.f+" "+p.c);
		}

		pw.flush();
		pw.close();
	}

	static int N, M;
	static int inf = (int) (1e9);
	static int p, vid;
	static int[] head, next, from, to, cost, cap;
	static int[] dist, flow, par, vis;

	static void init() {
		p = vid = 0;
		head = new int[N];
		Arrays.fill(head, -1);
		next = new int[M];
		from = new int[M];
		to = new int[M];
		cost = new int[M];
		cap = new int[M];
		dist = new int[N];
		flow = new int[N];
		par = new int[N];
		vis = new int[N];
	}

	static void addEdge(int f, int t, int cst, int cp) {
		next[p] = head[f];
		from[p] = f;
		to[p] = t;
		cost[p] = cst;
		cap[p] = cp;
		head[f] = p++;
	}

	static void addAugEdge(int a, int b, int cst, int cp) {
		addEdge(a, b, cst, cp);
		addEdge(b, a, -cst, 0);
	}

	static boolean bellman(int src) {
		Arrays.fill(dist, inf);
		Arrays.fill(flow, 0);
		dist[src] = 0;
		flow[src] = inf;
		vid++;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		while (!q.isEmpty()) {
			int f = q.poll();
			for (int k = head[f]; k != -1; k = next[k]) {
				int t = to[k];
				int c = cost[k];
				int d = dist[f] + c;
				if (cap[k] > 0 && dist[t] > d) {
					dist[t] = d;
					flow[t] = Math.min(flow[f], cap[k]);
					par[t] = k;
					if (vis[t] != vid) {
						vis[t] = vid;
						q.add(t);
					}
				}
			}
		}

		return true;
	}

	static pair minCostMaxFlow(int src, int snk) {
		int c = 0, f = 0;
		while (true) {
			bellman(src);
			if (flow[snk] == 0)
				break;
			f += flow[snk];
			c += dist[snk] * flow[snk];
			for (int i = snk; i != src; i = from[par[i]]) {
				int k = par[i];
				cap[k] -= flow[snk];
				cap[k ^ 1] += flow[snk];
			}
		}
		return new pair(f, c);
	}

	static class pair {
		int f, c;

		pair(int f, int c) {
			this.f = f;
			this.c = c;
		}
	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("test.in")));
			} catch (Exception e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
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
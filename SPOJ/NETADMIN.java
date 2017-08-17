

import java.io.*;
import java.util.*;

public class NETADMIN {
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			N = n + 1;
			M = 2 * ( 2*m + k);
			src = 1;
			snk = 0;
			init();
			for (int i = 0; i < k; i++)		
				addAugEdge(sc.nextInt(), snk, 1);
			for (int i = 0; i < m; i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				if(x==1)
					addAugEdge(x, y, 1);
				else
					if(y==1)
						addAugEdge(y, x, 1);
					else{						
						addAugEdge(x, y, 1);
						addAugEdge(y, x, 1);
					}
			}
			int start = 0, end = n, ans = -1;
			while (start <= end) {
				int mid = ((start + end) >> 1);
				for(int i=0;i<M;i++){
					if(i%2==1)
						cap[i]=0;
					else{
						if(to[i]==snk)
							cap[i]=1;
						else
							cap[i]=mid;
					}
				}
				int tmp = maxFlow();
				if (tmp >= k) {
					ans = mid;
					end = mid - 1;
				} else
					start = mid + 1;
			}
			pw.println(ans);
		}

		pw.flush();
		pw.close();
	}

	static int inf = (int) 1e9;
	static int N, M, p;
	static int src, snk, vid;
	static int[] vis;
	static int[] head, nxt, to, cap;

	static void init() {
		p = 0;
		vis = new int[N];
		head = new int[N];
		nxt = new int[M];
		to = new int[M];
		cap = new int[M];
		Arrays.fill(head, -1);
	}

	static void addEdge(int f, int t, int c) {
		nxt[p] = head[f];
		to[p] = t;
		cap[p] = c;
		head[f] = p++;
	}

	static void addAugEdge(int a, int b, int c) {
		addEdge(a, b, c);
		addEdge(b, a, 0);
	}

	static int dfs(int i, int flow) {
		if (i == snk)
			return flow;
		if (flow == 0)
			return 0;
		if (vis[i] == vid)
			return 0;
		vis[i] = vid;
		for (int k = head[i]; k != -1; k = nxt[k]) {
			int j = to[k];
			int c = cap[k];
			int f = dfs(j, Math.min(flow, c));
			if (f > 0) {
				cap[k] -= f;
				cap[k ^ 1] += f;
				return f;
			}
		}
		return 0;
	}

	static int maxFlow() {
		if (src == snk)
			return inf;
		int flow = 0, f = 0;
		vid++;
		while (true) {
			f = dfs(src, inf);
			if (f == 0)
				break;
			flow += f;
			vid++;
		}
		return flow;
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
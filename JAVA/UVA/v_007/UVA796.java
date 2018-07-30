package v_007;
import java.io.*;
import java.util.*;

public class UVA796 {
	
	static ArrayList<Integer> [] adj;
	static int [] dfs_num,dfs_low,parent;
	static int time;
	static int n;
	static ArrayList<pair> bridges;
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);
//		int t=2;
		try {
			while(sc.br.ready()){
				n=sc.nextInt();
				adj=new ArrayList [n];
				for(int i=0;i<n;i++)
					adj[i]=new ArrayList<Integer>();
				for(int i=0;i<n;i++){
					int u=sc.nextInt();
					String s=sc.next();
					int c=Integer.parseInt(s.substring(1, s.length()-1));
					while(c-->0){
						int v=sc.nextInt();
						adj[u].add(v);
						adj[v].add(u);
					}
				}
				bridges=new ArrayList<pair>();
				dfs_low=new int [n];
				dfs_num=new int [n];
				parent=new int [n];
				time=0;
				for(int i=0;i<n;i++)
					if(dfs_num[i]==0)
						dfs(i);
				pw.println(bridges.size()+" critical links");
				Collections.sort(bridges);
				for(pair s : bridges)
					pw.println(s.a+" - "+s.b);
				pw.println();
			}
		} catch (Exception e) {
			
		}
		
		pw.flush();
		pw.close();
	}
	
	static class pair implements Comparable<pair>{
		int a,b;
		pair(int x,int y){
			a=x;
			b=y;
		}
		public int compareTo(pair o){
			if(a!=o.a)
				return a-o.a;
			return b-o.b;
		}
	}
	
	public static void dfs(int u){
		dfs_low[u]=dfs_num[u]=++time;
		
		for(int v : adj[u]){
			if(dfs_num[v]==0){
				parent[v]=u;
				dfs(v);
				if(dfs_low[v]>dfs_num[u]){
					bridges.add(new pair(Math.min(u, v),Math.max(u, v)));
				}
				dfs_low[u]=Math.min(dfs_low[u], dfs_low[v]);
			}else{
				if(v!=parent[u])
					dfs_low[u]=Math.min(dfs_low[u], dfs_num[v]);
			}
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

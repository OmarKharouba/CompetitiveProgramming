package codeforces;
import java.io.*;
import java.util.*;
public class CF369_D2_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		adj=new ArrayList [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		problem=new boolean [n];
		ArrayList<Integer> A=new ArrayList<Integer>();
		ArrayList<Integer> B=new ArrayList<Integer>();
		for(int i=0;i<n-1;i++){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			int t=sc.nextInt();
			adj[u].add(v);
			adj[v].add(u);
			if(t==2){
				A.add(u);
				B.add(v);
			}
		}
		par=new int [n];
		cnt=new int [n];
		elected=new boolean[n];
		par[0]=-1;
		dfs(0);
		for(int i=0;i<A.size();i++){
			if(par[B.get(i)]==A.get(i))
				problem[B.get(i)]=true;
			else
				problem[A.get(i)]=true;
		}
		solve(0);
		pw.println(ans);
		for(int i=0;i<n;i++)
			if(elected[i])
				pw.print(i+1+" ");
		pw.flush();
		pw.close();
	}
	static int n,ans;
	static ArrayList<Integer> [] adj;
	static boolean [] problem;
	static int [] par,cnt;
	static boolean [] elected;
	
	static void solve(int u){
		for(int v : adj[u])
			if(v!=par[u]){
				solve(v);
				cnt[u]+=cnt[v];
			}
		if(problem[u] && cnt[u]==0){
			cnt[u]++;
			elected[u]=true;
			ans++;
		}
	}
	
	static void dfs(int u){
		for(int v : adj[u])
			if(v!=par[u]){
				par[v]=u;
				dfs(v);
			}
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}
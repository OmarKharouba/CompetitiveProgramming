package codeforces;
import java.io.*;
import java.util.*;
public class CF839_D2_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		adj=new ArrayList [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		for(int i=0;i<n-1;i++){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			adj[u].add(v);
			adj[v].add(u);
		}
		mem=new Double [n];
		pw.println(dp(0, -1));
		
		pw.flush();
		pw.close();
	}
	static int n;
	static ArrayList<Integer> [] adj;
	static Double [] mem;
	
	static double dp(int u,int par){
		if(mem[u]!=null)
			return mem[u];
		int c=adj[u].size();
		if(u!=0)
			c--;
		double p=1.0/c;
		double ans=0;
		for(int v :adj[u]){
			if(v!=par)
				ans+=p*(1+dp(v, u));
		}
		return mem[u]=ans;
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
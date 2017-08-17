package v_102;
import java.io.*;
import java.util.*;
public class UVA10243 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			n=sc.nextInt();
			if(n==0)
				break;
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				int c=sc.nextInt();
				while(c-->0){
					int v=sc.nextInt()-1;
					adj[i].add(v);
				}
			}
			par=new int [n];
			par[0]=-1;
			dfs(0);
			mem=new int [2][n];
			Arrays.fill(mem[0], -1);
			Arrays.fill(mem[1], -1);
			if(n>1)
				pw.println(dp(1, 0));
			else
				pw.println(1);
		}
		
		pw.flush();
		pw.close();
	}
	static int n;
	static int [] par;
	static ArrayList<Integer> [] adj;
	static int [][] mem;
	
	static int dp(int f,int i){
		if(mem[f][i]!=-1)
			return mem[f][i];
		int ans=1;
		for(int v : adj[i])
			if(v!=par[i])
				ans+=dp(1, v);
		if(f==1){
			int sum=0;
			for(int v : adj[i])
				if(v!=par[i])
					sum+=dp(0, v);
			ans=Math.min(ans, sum);
		}
		return mem[f][i]=ans;
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
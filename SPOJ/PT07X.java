import java.io.*;
import java.util.*;
public class PT07X {
	static int n;
	static ArrayList<Integer> [] adj;
	static int [] p;
	static int [][] mem;
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		adj=new ArrayList [n];
		mem=new int [3][n+1];
		for(int i=0;i<3;i++)
			Arrays.fill(mem[i], -1);
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		for(int i=0;i<n-1;i++){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			adj[u].add(v);
			adj[v].add(u);
		}
		int leaf=-1;
		for(int i=0;i<n;i++)
			if(adj[i].size()==1)
				leaf=i;
		int ans=0;
		if(n==1)
			ans=0;
		else
			if(n==2)
				ans=1;
			else{
				p=new int [n];
				p[leaf]=-1;
				dfs(leaf);
				ans=dp(2, leaf);
			}
		pw.println(ans);
		pw.flush();
		pw.close();
	}
	
	public static void dfs(int u){
		for(int i : adj[u])
			if(i!=p[u]){
				p[i]=u;
				dfs(i);
			}
	}
	
	public static int dp(int last,int u){
		if(mem[last][u]!=-1)
			return mem[last][u];
		int take=1;
		for(int i : adj[u])
			if(p[u]!=i)
				take+=dp(1, i);
		int leave=(int)1e9;
		if(last!=0){
			leave=0;
			for(int i : adj[u])
				if(p[u]!=i)
					leave+=dp(0, i);
		}
		return mem[last][u]=Math.min(take, leave);
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
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
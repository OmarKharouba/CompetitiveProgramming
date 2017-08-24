
import java.io.*;
import java.util.*;
public class TOUR {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			n=sc.nextInt();
			adj=new ArrayList [n];
			vis=new int [n];
			Arrays.fill(vis, -1);
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				int c=sc.nextInt();
				while(c-->0){
					int v=sc.nextInt()-1;
					adj[v].add(i);
				}
			}
			reach=new boolean [n][n];
			for(int i=0;i<n;i++){
				cur=i;
				dfs(i);
			}
			int ans=0;
			for(int i=0;i<n;i++){
				boolean ok=true;
				for(int j=0;j<n;j++)
					if(!reach[i][j])
						ok=false;
				if(ok)
					ans++;
			}
			
			pw.println(ans);
		}
		
		pw.flush();
		pw.close();
	}
	static int n,cur;
	static int [] vis;
	static boolean [][] reach;
	static ArrayList<Integer> [] adj;
	
	static void dfs(int u){
		reach[cur][u]=true;
		vis[u]=cur;
		for(int v : adj[u])
			if(vis[v]!=cur)
				dfs(v);
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

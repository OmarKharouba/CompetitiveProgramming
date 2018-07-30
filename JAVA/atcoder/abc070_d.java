package atcoder;
import java.io.*;
import java.util.*;
public class abc070_d {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		adj=new ArrayList [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		int [] x=new int [n-1];
		int [] y=new int [n-1];
		int [] z=new int [n-1];
		for(int i=0;i<n-1;i++){
			x[i]=sc.nextInt()-1;
			y[i]=sc.nextInt()-1;
			z[i]=sc.nextInt();
			adj[x[i]].add(y[i]);
			adj[y[i]].add(x[i]);
		}
		preProcessing();
		for(int i=0;i<n-1;i++)
			if(level[x[i]]>level[y[i]])
				cost[x[i]]=z[i];
			else
				cost[y[i]]=z[i];
		dfs2(0);
		int q=sc.nextInt();
		k=sc.nextInt()-1;
		while(q-->0){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			pw.println(path_len(u, k, query(u, k))+path_len(v, k, query(v, k)));
		}
		
		pw.flush();
		pw.close();
	}
	
	static long path_len(int u,int v,int l){
		return cost[u]+cost[v]-2*cost[l];
	}
	
	static int n,k;
	static int [][] ansector;
	static int [] parent,level;
	static long [] cost;
	static ArrayList<Integer> [] adj;
	
	static void preProcessing(){
		parent=new int [n];
		level=new int [n];
		cost=new long [n];
		parent[0]=-1;
		dfs(0, 0);
		int log=(int)Math.ceil(Math.log(n)/Math.log(2));
		ansector=new int [n][log];
		for(int [] x : ansector)
			Arrays.fill(x, -1);
		for(int i=0;i<n;i++)
			ansector[i][0]=parent[i];				
		for(int j=1;(1<<j)<n;j++)
			for(int i=0;i<n;i++)
				if(ansector[i][j-1]!=-1)
					ansector[i][j]=ansector[ansector[i][j-1]][j-1];
	}
	
	public static void dfs(int u,int h){
		level[u]=h;
		for(int v : adj[u])
			if(v!=parent[u]){
				parent[v]=u;
				dfs(v, h+1);
			}
	}
	
	static void dfs2(int u){
		for(int v : adj[u])
			if(v!=parent[u]){
				cost[v]+=cost[u];
				dfs2(v);
			}
	}
	
	public static int query(int u,int v){
		if(level[u]<level[v]){
			int tmp=u;
			u=v;
			v=tmp;
		}
		int log=1;
		for(log=1;(1<<log)<=level[u];log++);
		log--;
		
		for(int i=log;i>=0;i--)
			if(level[u]-(1<<i)>=level[v])
				u=ansector[u][i];
		
		if(u==v)
			return u;
		
		for(int i=log;i>=0;i--)
			if(ansector[u][i]!=-1 && ansector[u][i]!=ansector[v][i]){
				u=ansector[u][i];
				v=ansector[v][i];
			}
		return parent[u];
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
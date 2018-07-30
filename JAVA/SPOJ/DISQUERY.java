import java.io.*;
import java.util.*;
public class DISQUERY {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		adj=new ArrayList [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		int [] x=new int [n-1];
		int [] y=new int [n-1];
		int [] c=new int [n-1];
		for(int i=0;i<n-1;i++){
			x[i]=sc.nextInt()-1;
			y[i]=sc.nextInt()-1;
			c[i]=sc.nextInt();
			adj[x[i]].add(y[i]);
			adj[y[i]].add(x[i]);
		}
		parent=new int [n];
		level=new int [n];
		cost=new int [n];
		parent[0]=-1;
		dfs(0, 0);
		for(int i=0;i<n-1;i++){
			if(x[i]==parent[y[i]])
				cost[y[i]]=c[i];
			else
				cost[x[i]]=c[i];
		}
		preProcessing();
		int q=sc.nextInt();
		while(q-->0){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			query(u, v);
			pw.println(minAns+" "+maxAns);
		}
		pw.flush();
		pw.close();
	}
	static int minAns,maxAns;
	static int n;
	static int [][] ansector,min,max;
	static int [] parent,level,cost;
	static ArrayList<Integer> [] adj;
	
	static void preProcessing(){
		int log=(int)Math.ceil(Math.log(n)/Math.log(2));
		ansector=new int [n][log];
		max=new int [n][log];
		min=new int [n][log];
		for(int [] x : min)
			Arrays.fill(x, Integer.MAX_VALUE);
		for(int [] x : ansector)
			Arrays.fill(x, -1);
		for(int i=0;i<n;i++){
			ansector[i][0]=parent[i];
			max[i][0]=cost[i];
			min[i][0]=cost[i];
		}
		for(int j=1;(1<<j)<n;j++)
			for(int i=0;i<n;i++)
				if(ansector[i][j-1]!=-1){
					ansector[i][j]=ansector[ansector[i][j-1]][j-1];
					min[i][j]=Math.min(min[i][j-1], min[ansector[i][j-1]][j-1]);
					max[i][j]=Math.max(max[i][j-1], max[ansector[i][j-1]][j-1]);
				}
	}
	
	public static void dfs(int u,int h){
		level[u]=h;
		for(int v : adj[u])
			if(v!=parent[u]){
				parent[v]=u;
				dfs(v, h+1);
			}
	}
	
	public static void query(int u,int v){
		maxAns=0;
		minAns=Integer.MAX_VALUE;
		if(level[u]<level[v]){
			int tmp=u;
			u=v;
			v=tmp;
		}
		int log=1;
		for(log=1;(1<<log)<=level[u];log++);
		log--;
		
		for(int i=log;i>=0;i--)
			if(level[u]-(1<<i)>=level[v]){
				minAns=Math.min(minAns, min[u][i]);
				maxAns=Math.max(maxAns, max[u][i]);
				u=ansector[u][i];
			}
		
		if(u==v)
			return;
		
		for(int i=log;i>=0;i--)
			if(ansector[u][i]!=-1 && ansector[u][i]!=ansector[v][i]){
				minAns=Math.min(minAns, min[u][i]);
				maxAns=Math.max(maxAns, max[u][i]);
				minAns=Math.min(minAns, min[v][i]);
				maxAns=Math.max(maxAns, max[v][i]);
				u=ansector[u][i];
				v=ansector[v][i];
			}
		minAns=Math.min(minAns, min[u][0]);
		maxAns=Math.max(maxAns, max[u][0]);
		minAns=Math.min(minAns, min[v][0]);
		maxAns=Math.max(maxAns, max[v][0]);
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


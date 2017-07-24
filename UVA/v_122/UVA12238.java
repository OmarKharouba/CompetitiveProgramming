package v_122;
import java.io.*;
import java.util.*;
public class UVA12238 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			n=sc.nextInt();
			if(n==0)
				break;
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			p=new int [n];
			cost=new int [n];
			p[0]=-1;
			for(int i=1;i<n;i++){
				int v=sc.nextInt();
				p[i]=v;
				adj[v].add(i);
				cost[i]=sc.nextInt();
			}
			int log=(int)Math.ceil(Math.log(n)/Math.log(2));
			ansector=new int [n][log];
			for(int [] x : ansector)
				Arrays.fill(x, -1);
			for(int i=0;i<n;i++)
				ansector[i][0]=p[i];				
			for(int j=1;(1<<j)<n;j++)
				for(int i=0;i<n;i++)
					if(ansector[i][j-1]!=-1)
						ansector[i][j]=ansector[ansector[i][j-1]][j-1];
			level=new int [n];
			sum=new long [n];
			dfs(0, 0);
			
			int q=sc.nextInt();
			while(q-->0){
				int u=sc.nextInt();
				int v=sc.nextInt();
				int LCA=query(u, v);
				long ans=sum[u]+sum[v]-2*sum[LCA];
				if(q>0)
					pw.print(ans+" ");
				else
					pw.println(ans);
			}
		}
		
		pw.flush();
		pw.close();
	}
	static int n;
	static int [][] ansector;
	static int [] p,cost,level;
	static long [] sum;
	static ArrayList<Integer> [] adj;
	
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
		return p[u];
	}
	
	public static void dfs(int u,int h){
		level[u]=h;
		sum[u]=cost[u];
		if(p[u]!=-1)
			sum[u]+=sum[p[u]];
		for(int v : adj[u])
			dfs(v, h+1);
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
	 
	      String nextLine(){
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

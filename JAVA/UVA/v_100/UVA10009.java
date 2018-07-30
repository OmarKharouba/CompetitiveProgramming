package v_100;
import java.io.*;
import java.util.*;
public class UVA10009 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		n=26;
		while(t-->0){
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			int m=sc.nextInt();
			int q=sc.nextInt();
			while(m-->0){
				int u=sc.next().charAt(0)-'A';
				int v=sc.next().charAt(0)-'A';
				adj[u].add(v);
				adj[v].add(u);
			}
			int log=(int)Math.ceil(Math.log(n)/Math.log(2));
			ansector=new int [n][log];
			level=new int [n];
			p=new int [n];
			p[0]=-1;
			dfs(0, 0);
			for(int [] x : ansector)
				Arrays.fill(x, -1);
			for(int i=0;i<n;i++)
				ansector[i][0]=p[i];				
			for(int j=1;(1<<j)<n;j++)
				for(int i=0;i<n;i++)
					if(ansector[i][j-1]!=-1)
						ansector[i][j]=ansector[ansector[i][j-1]][j-1];
			while(q-->0){
				int u=sc.next().charAt(0)-'A';
				int v=sc.next().charAt(0)-'A';
				int LCA=query(u, v);
				int cur=u;
				while(cur!=LCA){
					pw.print((char)('A'+cur));
					cur=p[cur];
				}
				Stack<Integer> stack=new Stack<Integer>();
				stack.add(v);
				cur=v;
				while(cur!=LCA){
					cur=p[cur];
					stack.add(cur);
				}
				while(!stack.isEmpty())
					pw.print((char)('A'+stack.pop()));
				pw.println();
			}
			if(t>0)
				pw.println();
		}
		
		pw.flush();
		pw.close();
	}
	static int n;
	static int [] p,level;
	static int [][] ansector;
	static ArrayList<Integer> [] adj;
	
	public static void dfs(int u,int h){
		level[u]=h;
		for(int v : adj[u])
			if(v!=p[u]){
				p[v]=u;
				dfs(v, h+1);
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
		return p[u];
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	      public MyScanner() {
	    	  try {
	    		  br=new BufferedReader(new FileReader(new File("test.in")));
			} catch (Exception e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
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

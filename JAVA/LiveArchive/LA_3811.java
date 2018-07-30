package LiveArchive;
import java.io.*;
import java.util.*;

public class LA_3811 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			int m=sc.nextInt();
			V=n+1;
			c=new int [V][V];
			while(m-->0){
				int u=sc.nextInt();
				int v=sc.nextInt();
				c[u][v]++;
				c[v][u]++;
			}
			v=new boolean [V];
			dfs(1);
			s=0;
			t=1;
			int min=pushRelabel();
			for(int i=2;i<V;i++)
				if(v[i]){
					t=i;
					min=Math.min(min, pushRelabel());
				}
			pw.println("Case "+(id++)+": "+min);
			pw.println();
		}
		pw.flush();
		pw.close();
	}
	static boolean [] v;
	static void dfs(int u){	
		v[u]=true;
		for(int i=1;i<V;i++)
			if(!v[i] && c[u][i]>0)
				dfs(i);
	}
	
	static final int INF = (int)1e9;
	static int V, s, t, c[][];			//input

	static int pushRelabel()			//O(V^3)
	{
		int[] h = new int[V], e = new int[V], f[] = new int[V][V];
		h[s] = V - 1;

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(t);
		while(!q.isEmpty())
		{
			int u = q.remove();
			for(int v = 0; v < V; ++v)
				if(v != t && v != s && h[v] == 0)
				{
					h[v] = h[u] + 1;
					q.add(v);
				}
		}
		
		boolean[] isActive = new boolean[V];
		for(int i = 0; i < V; ++i)
		{
			f[i][s] = -(f[s][i] = e[i] = c[s][i]);
			if(i != s && i != t && e[i] > 0)
			{
				isActive[i] = true;
				q.add(i);
			}
		}

		while(!q.isEmpty())
		{
			int u = q.peek();
			boolean pushed = false;
			for(int v = 0; v < V && e[u] != 0; ++v)
				if(h[u] == h[v] + 1 &&  c[u][v] - f[u][v] > 0)
				{
					int df = Math.min(e[u], c[u][v] - f[u][v]);
					f[u][v] += df; f[v][u] -= df;
					e[u] -= df; e[v] += df;
					if(v != s && v != t && !isActive[v])
					{
						isActive[v] = true;
						q.add(v);
					}
					pushed = true;
				}

			if(e[u] == 0)
			{
				isActive[u] = false;
				q.remove();
			}

			if(!pushed)
			{
				h[u] = INF;
				for(int v = 0; v < V; ++v)
					if(h[v] + 1 < h[u] && c[u][v] - f[u][v] > 0)
						h[u] = h[v] + 1;
			}
		}

		return e[t];
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

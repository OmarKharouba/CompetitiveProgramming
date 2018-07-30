package v_109;
import java.io.*;
import java.util.*;
public class UVA10938 {
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
			for(int i=0;i<n-1;i++){
				int u=sc.nextInt()-1;
				int v=sc.nextInt()-1;
				adj[u].add(v);
				adj[v].add(u);
			}
			int q=sc.nextInt();
			while(q-->0){
				int u=sc.nextInt()-1;
				int v=sc.nextInt()-1;
				dis1=new int [n];
				dis2=new int [n];
				dfs(u, -1, 0, true);
				dfs(v, -1, 0, false);
				int min=(int)1e5;
				int meet=-1;
				for(int i=0;i<n;i++)
					if(dis1[i]==dis2[i] && dis1[i]<min){
						min=dis1[i];
						meet=i+1;
					}
				if(meet!=-1){
					pw.printf("The fleas meet at %d.\n",meet);
				}else{
					int xx=-1,yy=-1;
					for(int x=0;x<n;x++)
						for(int y : adj[x]){
							if(dis1[x]==dis2[y] && dis1[x]<min){
								min=dis1[x];
								xx=x+1;
								yy=y+1;
							}
						}
					pw.printf("The fleas jump forever between %d and %d.\n",Math.min(xx, yy),Math.max(xx, yy));
				}
			}
		}
		
		pw.flush();
		pw.close();
	}
	static int [] dis1,dis2;
	static int n;
	static ArrayList<Integer> [] adj;
	
	public static void dfs(int u,int p, int d, boolean f){
		if(f)
			dis1[u]=d;
		else
			dis2[u]=d;
		for(int v : adj[u])
			if(v!=p)
				dfs(v, u, d+1, f);
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

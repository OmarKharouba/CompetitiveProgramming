package TJU;
import java.io.*;
import java.util.*;
public class TJU1706 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		for(int id=1;id<=t;id++){
			ok=true;
			n=sc.nextInt();
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			int m=sc.nextInt();
			while(m-->0){
				int u=sc.nextInt()-1;
				int v=sc.nextInt()-1;
				adj[u].add(v);
				adj[v].add(u);
			}
			c=new int [n];
			Arrays.fill(c, -1);
			for(int i=0;i<n;i++)
				if(c[i]==-1){
					c[i]=0;
					color(i);
				}
			pw.println("Scenario #"+id+":");
			if(ok)
				pw.println("No suspicious bugs found!");
			else
				pw.println("Suspicious bugs found!");
			pw.println();
		}
		
		pw.flush();
		pw.close();
	}
	static boolean ok;
	static int n;
	static int [] c;
	static ArrayList<Integer> [] adj;
	
	static void color(int u){
		for(int v : adj[u]){
			if(c[v]==c[u])
				ok=false;
			if(c[v]==-1){
				c[v]=1-c[u];
				color(v);
			}
		}
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


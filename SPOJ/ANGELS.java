import java.io.*;
import java.util.*;
public class ANGELS {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			int r=sc.nextInt();
			int c=sc.nextInt();
			n=m=r*c+r+c;
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			char [][] a=new char [r][c];
			for(int i=0;i<r;i++)
				a[i]=sc.next().toCharArray();
			int id=0;
			int [][] rowID=new int [r][c];
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++)
					if(a[i][j]=='*')
						rowID[i][j]=id;
					else
						id++;
				id++;
			}
			id=0;
			int [][] colID=new int [r][c];
			for(int j=0;j<c;j++){
				for(int i=0;i<r;i++)
					if(a[i][j]=='*')
						colID[i][j]=id;
					else
						id++;
				id++;
			}
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					if(a[i][j]=='*')
						adj[rowID[i][j]].add(colID[i][j]);
			pw.println(maxMathing());
		}
		
		pw.flush();
		pw.close();
	}
	
	static int n,m,vid;
	static int [] match;
	static ArrayList<Integer> [] adj;
	static int [] vis;
	
	static int maxMathing(){
		int ans=0;
		match=new int [m];
		vis=new int [n];
		Arrays.fill(match, -1);
		for(int i=0;i<n;i++){
			vid++;
			if(canMatch(i))
				ans++;
		}
		return ans;
	}
	
	static boolean canMatch(int u){
		vis[u]=vid;
		for(int v : adj[u])
			if(match[v]==-1 || (vis[match[v]]!=vid && canMatch(match[v]) )){
				match[v]=u;
				return true;
			}
		return false;
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

package v_101;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class UVA10113 {
	static int [][][] adj;
	static boolean v[] ;
	static int dis;
	static int n,m;
	public static void main(String[]args)throws NumberFormatException,IOException{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		TreeMap<String, Integer> map=new TreeMap<String, Integer>();
		int p=0;
		v=new boolean [60];
		adj=new int [2][60][60];
		for(int i=0;i<60;i++){
			Arrays.fill(adj[0][i], -1);
			Arrays.fill(adj[1][i], -1);
		}
		while(true){
			String s=sc.nextLine();
			if(s.contains("."))
				break;
			String [] sa=s.split(" ");
			if(sa[0].equals("?")){
				n=-1;
				m=-1;
				int x=map.get(sa[1]);
				int y=map.get(sa[3]);
				//dfs(x,y);
				pw.println(n+" "+m);
			}else{
				String a=sa[2];
				String b=sa[5];
				int x=Integer.parseInt(sa[1]);
				int y=Integer.parseInt(sa[4]);
				if(!map.containsKey(a))
					map.put(a, p++);
				if(!map.containsKey(b))
					map.put(b, p++);
				int p1=map.get(a);
				int p2=map.get(b);
				adj[0][p1][p2]=x;
				adj[1][p1][p2]=y;
				adj[0][p2][p1]=y;
				adj[1][p2][p1]=x;
			}
			
		}
		
		pw.flush();
		pw.close();
	}
	
//	public static void dfs(int s,int e){
//		if()
//	}
	
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

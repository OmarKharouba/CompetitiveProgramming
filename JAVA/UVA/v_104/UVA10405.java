package v_104;
import java.io.*;
import java.util.*;
public class UVA10405 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(sc.br.ready()){
			String x=sc.nextLine();
			String y=sc.nextLine();
			a=x.toCharArray();
			b=y.toCharArray();
			n=x.length();
			m=y.length();
			mem=new int [n+1][m+1];
			for(int [] z : mem)
				Arrays.fill(z, -1);
			pw.println(dp(0,0));
		}
		
		pw.flush();
		pw.close();
	}
	static char [] a,b;
	static int n,m;
	static int [][] mem;
	
	public static int dp(int i,int j){
		if(i>=n || j>=m)
			return 0;
		if(mem[i][j]!=-1)
			return mem[i][j];
		int ans=dp(i+1, j);
		ans=Math.max(ans, dp(i, j+1));
		if(a[i]==b[j])
			ans=Math.max(ans, 1+dp(i+1, j+1));
		return mem[i][j]=ans;
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

package v_101;
import java.io.*;
import java.util.*;
public class UVA10192 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int id=1;
		while(true){
			a=sc.nextLine();
			if(a.length()!=0 && a.charAt(0)=='#')
				break;
			b=sc.nextLine();
			mem=new int [a.length()+1][b.length()+1];
			for(int [] x : mem)
				Arrays.fill(x, -1);
			pw.printf("Case #%d: you can visit at most %d cities.\n",id++,dp(0, 0));
		}
		pw.flush();
		pw.close();
	}
	static String a,b;
	static int [][] mem;
	public static int dp(int i,int j){
		if(i>=a.length() || j>=b.length())
			return 0;
		if(mem[i][j]!=-1)
			return mem[i][j];
		int ans=0;
		ans=Math.max(ans, dp(i+1, j));
		ans=Math.max(ans, dp(i, j+1));
		if(a.charAt(i)==b.charAt(j))
			ans=Math.max(ans, 1+dp(i+1, j+1));
		return mem[i][j]=ans;
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

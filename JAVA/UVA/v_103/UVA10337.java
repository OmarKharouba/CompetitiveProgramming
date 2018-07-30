package v_103;
import java.io.*;
import java.util.*;
public class UVA10337 {
	static int n;
	static int [][] mem;
	static int [][] wind;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new StringBuilder();
		int t=sc.nextInt();
		while(t-->0){
			int x=sc.nextInt();
			n=x/100;
			mem=new int[10][n];
			wind=new int[10][n];
			for(int i=0;i<10;i++){
				Arrays.fill(mem[i], -1);
				for(int j=0;j<n;j++)
					wind[9-i][j]=sc.nextInt();
			}
			pw.println(dp(0, 0));
			pw.println();
		}
		pw.print(sb);
		pw.flush();
		pw.close();
	}
	
	public static int dp(int level,int d){
		if(d==n){
			if(level==0)
				return 0;
			return (int)(1e9);
		}
		if(mem[level][d]!=-1)
			return mem[level][d];
		int ans=30-wind[level][d]+dp(level,d+1);
		if(level>0)
			ans=Math.min(ans, 20-wind[level][d]+dp(level-1,d+1));
		if(level<9)
			ans=Math.min(ans, 60-wind[level][d]+dp(level+1,d+1));
		return mem[level][d]=ans;
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

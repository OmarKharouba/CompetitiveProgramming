package v_101;
import java.io.*;
import java.util.*;
public class UVA10130 {
	static int n;
	static int[][]mem;
	static int mw;
	static int[]w;
	static int[]v;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		int t=sc.nextInt();
		while(t-->0){
			n=sc.nextInt();
			mem=new int[n][31];
			v=new int[n];
			w=new int[n];
			for(int i=0;i<n;i++){
				v[i]=sc.nextInt();
				w[i]=sc.nextInt();
			}
			int g=sc.nextInt();
			long sum=0;
			while(g-->0){
				for(int i=0;i<n;i++)
					Arrays.fill(mem[i], -1);
				mw=sc.nextInt();
				sum+=dp(0, 0);
			}
			System.out.println(sum);
		}
	}
	
	public static int dp(int i,int sum){
		if(i==n)
			return 0;
		
		if(mem[i][sum]!=-1)
			return mem[i][sum];
		int ans=dp(i+1,sum);
		if(sum+w[i]<=mw)
			ans=Math.max(ans, v[i]+dp(i+1,sum+w[i]));
		return mem[i][sum]=ans;
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

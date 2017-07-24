package v_104;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class UVA10496 {
	static int[]x;
	static int[]y;
	static int n;
	static int[][]mem;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		int t=sc.nextInt();
		while(t-->0){
			sc.nextInt();
			sc.nextInt();
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			n=sc.nextInt();
			x=new int[n+1];
			y=new int[n+1];
			x[0]=x1;
			y[0]=y1;
			mem=new int[(1<<(n+1))][n+1];
			for(int i=0;i<(1<<(n+1));i++)
				Arrays.fill(mem[i], -1);
			for(int i=1;i<=n;i++){
				x[i]=sc.nextInt();
				y[i]=sc.nextInt();
			}
			System.out.println("The shortest path has length "+dp(1,0));
		}
	}
	
	public static int dp(int mask,int i){
		if(mask==(1<<(n+1))-1)
			return Math.abs(x[i]-x[0])+Math.abs(y[i]-y[0]);
		if(mem[mask][i]!=-1)
			return mem[mask][i];
		int ans=(int)(1e8);
		for(int j=1 ;j<=n;j++)
			if((mask & (1<<j))==0)
				ans=Math.min(ans, (Math.abs(x[i]-x[j])+Math.abs(y[i]-y[j]))+dp(mask+(1<<j),j));
		return mem[mask][i]=ans;
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

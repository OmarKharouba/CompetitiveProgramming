package v_012;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class UVA1240 {
	static int[]x;
	static int[]y;
	static int[]z;
	static int n;
	static int[][][]mem;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		int t=sc.nextInt();
		while(t-->0){
			n=sc.nextInt();
			x=new int[n];
			y=new int[n];
			z=new int[n];
			mem=new int[(1<<n)][281][4];
			for(int i=0;i<(1<<n);i++)
				for(int j=0;j<281;j++)
					Arrays.fill(mem[i][j], -1);
			for(int i=0;i<n;i++)
				x[i]=sc.nextInt();
			for(int i=0;i<n;i++)
				y[i]=sc.nextInt();
			for(int i=0;i<n;i++)
				z[i]=sc.nextInt();
			System.out.println(dp(0, 0, 0));
		}
	}
	
	public static int dp(int mask,int time,int last){
		if(mask==(1<<n)-1)
			return 0;
		
		if(mem[mask][time][last]!=-1)
			return mem[mask][time][last];
		int ans=0;
		for(int i=0;i<n;i++)
			if((mask & (1 << i))==0){
				if(last!=1 && time+x[i]<=280)
					ans=Math.max(ans, 1+dp(mask+(1<<i), time+x[i], 1));
				if(last!=2 && time+y[i]<=280)
					ans=Math.max(ans, 1+dp(mask+(1<<i), time+y[i], 2));
				if(last!=3 && time+z[i]<=280)
					ans=Math.max(ans, 1+dp(mask+(1<<i), time+z[i], 3));
			}
		return mem[mask][time][last]=ans;
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

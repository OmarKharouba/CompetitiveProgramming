package v_106;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class UVA10651 {
	static int[]mem;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		int t=sc.nextInt();
		while(t-->0){
			mem=new int[(1<<12)];
			Arrays.fill(mem, -1);
			String s=sc.next();
			int mask=0;
			int pow=1;
			for(int i=s.length()-1;i>=0;i--){
				if(s.charAt(i)=='o')
					mask+=pow;
				pow*=2;
			}
			System.out.println(dp(mask));
		}
		
	}
	
	public static int dp(int mask){
		if(mem[mask]!=-1)
			return mem[mask];
		int ans=0;
		for(int i=0;i<12;i++)
			if((mask & (1<<i))!=0)
				ans++;
		for(int i=0;i<11;i++)
			if((mask & (1<<i))!=0 && (mask & (1<<i+1))!=0){
				if(i>0 && (mask & (1<<i-1))==0)
					ans=Math.min(ans, dp(mask+(1<<i-1)-(1<<i)-(1<<i+1)));
				if(i<10 && (mask & (1<<i+2))==0)
					ans=Math.min(ans, dp(mask+(1<<i+2)-(1<<i)-(1<<i+1)));
			}
		return mem[mask]=ans;
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

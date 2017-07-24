package v_106;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class UVA10616 {
	static int n;
	static int m;
	static int d;
	static int [] a;
	static long [][][] mem;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new  StringBuilder();
		int cnt=1;
		while(true){
			n=sc.nextInt();
			a=new int [n];
			int q=sc.nextInt();
			if(n==0 && q==0)
				break;
			for(int i=0;i<n;i++) a[i]=sc.nextInt();
			
			pw.println("SET "+cnt+":");
			for(int i=1;i<=q;i++){
				d=sc.nextInt();
				m=sc.nextInt();
				mem=new long [n+1][m+1][d+1];
				for(int j=0;j<=n;j++)
					for(int k=0;k<=m;k++)
						Arrays.fill(mem[j][k], -1);
				long ans=dp(0, m, 0);
				pw.println("QUERY "+i+": "+ans);
			}
			cnt++;
		}
		pw.flush();
		pw.close();
	}
	
	public static long dp(int i,int cnt,int sum){
		if(cnt==0){
			if(sum%d==0)
				return 1;
			return 0;
		}
		
		if(i==n)
			return 0;
		
		if(mem[i][cnt][sum]!=-1)
			return mem[i][cnt][sum];
		
		long ans=0;
		ans+=dp(i+1, cnt-1,((sum+a[i]%d)%d+d)%d);
		ans+=dp(i+1, cnt,sum);
		
		
		return mem[i][cnt][sum]=ans;
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
	      
	      boolean ready()throws Exception{
	    	  return br.ready();
	      }

	   }
}

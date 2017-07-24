package v_104;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class UVA10440 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int tc=sc.nextInt();
		while(tc-->0){
			int n=sc.nextInt();
			int t=sc.nextInt();
			int m=sc.nextInt();
			int r=n;
			int cur_time=0;
			int cnt=0;
			while(m-->0){
				r--;
				cur_time=Math.max(cur_time, sc.nextInt());
				if(r==0){
					r=n;
					cur_time+=2*t;
					cnt++;
				}
			}
			if(r<n){
				cur_time+=2*t;
				cnt++;
			}
			cur_time-=t;
			pw.println(cur_time+" "+cnt);
		}
		
		
		pw.flush();
		pw.close();
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

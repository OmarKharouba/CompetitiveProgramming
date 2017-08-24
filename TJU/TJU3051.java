package TJU;
import java.io.*;
import java.util.*;
public class TJU3051 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			n=sc.nextInt();
			p=sc.nextInt();
			if(n==0 && p==0)
				break;
			int w=sc.nextInt();
			int d=sc.nextInt();
			int l=sc.nextInt();
			int sum=w+l+d;
			wp=1.0*w/sum;
			dp=1.0*d/sum;
			lp=1.0*l/sum;
			mem=new Double [n][p+5];
			pw.printf("%.1f\n",dp(0, 0)*100);
		}
		
		pw.flush();
		pw.close();
	}
	
	static int n,p;
	static double wp,dp,lp;
	static Double [][] mem;
	
	static double dp(int i,int c){
		if(c>=p)
			return 1;
		if(i==n)
			return 0;
		if(mem[i][c]!=null)
			return mem[i][c];
		return mem[i][c]=wp*dp(i+1, c+3)+lp*dp(i+1, c)+dp*dp(i+1, c+1);
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	    	  try {
	    		  br=new BufferedReader(new FileReader(new File("test1.in")));
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


package v_103;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class UVA10347 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new  StringBuilder();
		
		DecimalFormat df=new DecimalFormat("#0.000");
		
		while(sc.ready()){
			double x=sc.nextDouble();
			double y=sc.nextDouble();
			double z=sc.nextDouble();
			
			if(x+y<=z || x+z<=y || y+z<=x)
				pw.println(df.format(-1));
			else
				pw.println(df.format(areaMedians(x, y, z)));
			
		}
		
		
		pw.flush();
		pw.close();
	}
	
	static double areaMedians(double ma, double mb, double mc)
	{
		double s = (ma + mb + mc) / 2.0;
		return Math.sqrt(s * (s - ma) * (s - mb) * (s - mc)) * 4.0 / 3.0;
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

package PKU;
import java.io.*;
import java.util.*;
public class PKU1632 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			types=new long [36];
			for(int i=0;i<n;i++){
				int x=sc.nextInt()-1;
				int y=sc.nextInt()-1;
				types[x]|=(1L<<y);
			}
			pw.println(max(0, 0, -1L));
		}
		
		pw.flush();
		pw.close();
	}
	static long [] types;
	static int max(int i,int c,long msk){
		int bc=Long.bitCount(msk);
		if(bc<=c)
			return bc;
		if(i==36)
			return Math.min(c, bc);
		int ans=max(i+1, c, msk);
		if(types[i]!=0 && c<10)
			ans=Math.max(ans, max(i+1, c+1, msk & types[i]));
		return ans;
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	    	  try {
	    		  br=new BufferedReader(new FileReader(new File("test.in")));
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

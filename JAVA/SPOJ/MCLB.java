import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class MCLB {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		int id=1;
		while(t-->0){
			long a=0,b=0;
			char [] c=sc.next().toCharArray();
			for(int i=0;i<c.length;i++)
				if(c[i]=='B')
				a+=(1L<<(63-i));
			c=sc.next().toCharArray();
			for(int i=0;i<c.length;i++)
				if(c[i]=='B')
					b+=(1L<<(63-i));
			boolean ok=false;
			BigInteger ans=BigInteger.ZERO;
			if(b>a){
				if((b>0 && a>0) || (b<0 && a<0)){					
					ok=true;
					ans=BigInteger.valueOf(b).subtract(BigInteger.valueOf(a));
				}
			}else
				if(b<a){
					if(a>0 && b<0){
						ok=true;
						ans=BigInteger.valueOf(Long.MAX_VALUE).subtract(BigInteger.valueOf(Long.MIN_VALUE).add(BigInteger.valueOf(a)).subtract(BigInteger.valueOf(b).add(BigInteger.ONE)));
					}
				}else
					ok=(a!=0);
			
			
			pw.print("Case "+(id++)+": ");
			if(!ok)
				pw.println("The goal state will never be reached!");
			else
				pw.println("The goal state could be reached after "+ans+" laser beams.");
		}
		
		pw.flush();
		pw.close();
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

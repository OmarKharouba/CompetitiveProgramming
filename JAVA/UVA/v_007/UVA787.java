package v_007;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class UVA787 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new  StringBuilder();
		while(sc.ready()){
			ArrayList<BigInteger> a=new ArrayList<BigInteger>();
			while(true){
				int x=sc.nextInt();
				if(x==-999999)
					break;
				a.add(new BigInteger(x+""));
			}
			int n=a.size();
			BigInteger [][] mem=new BigInteger [n][n];
			BigInteger max=new BigInteger(a.get(0)+"");
			mem[0][0]=max;
			for(int i=1;i<n;i++){
				mem[i][i]=a.get(i);
				for(int j=0;j<=i;j++){
					if(j<i)
						mem[i][j]=mem[i-1][j].multiply(a.get(i));
					if(mem[i][j].compareTo(max)>0)
						max=mem[i][j];
				}
			}
			pw.println(max);
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
	      
	      boolean ready()throws Exception{
	    	  return br.ready();
	      }

	   }
}

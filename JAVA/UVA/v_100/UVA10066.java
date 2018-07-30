package v_100;
import java.io.*;
import java.util.*;
public class UVA10066 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		while(true){
			int n=sc.nextInt();
			int m=sc.nextInt();
			if(n==0)
				break;
			int [] a=new int [n];
			int [] b=new int [m];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			for(int i=0;i<m;i++)
				b[i]=sc.nextInt();
			int [][] mem=new int [2][m+1];
			int p=0;
			for(int i=n-1;i>=0;i--){
				p=1-p;
				for(int j=m-1;j>=0;j--){
					mem[p][j]=Math.max(mem[p][j+1], mem[1-p][j]);
					if(a[i]==b[j])
						mem[p][j]=Math.max(mem[p][j], 1+mem[1-p][j+1]);
				}
			}
			pw.println("Twin Towers #"+id++);
			pw.println("Number of Tiles : "+mem[p][0]);
			pw.println();
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

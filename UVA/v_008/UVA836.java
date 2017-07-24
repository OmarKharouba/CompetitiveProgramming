package v_008;

import java.io.*;
import java.util.*;

public class UVA836 {
	
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			int n=s.length()+1;
			int [][] a=new int [n][n];
			for(int i=1;i<n;i++)
				a[1][i]=s.charAt(i-1)=='0'? 1 : 0;
			 for(int i=2;i<n;i++){
				 s=sc.next();
				 for(int j=1;j<n;j++)
						a[i][j]=s.charAt(j-1)=='0'? 1 : 0;
			 }
			 for(int i=1;i<n;i++)
				 for(int j=1;j<n;j++)
					 a[i][j]+=a[i-1][j]+a[i][j-1]-a[i-1][j-1];
			 int ans=0;
			 for(int i1=1;i1<n;i1++)
				 for(int j1=1;j1<n;j1++)
					 for(int i2=i1;i2<n;i2++)
						 for(int j2=j1;j2<n;j2++){
							 int cnt=a[i2][j2]-a[i2][j1-1]-a[i1-1][j2]+a[i1-1][j1-1];
							 if(cnt==0)
								 ans=Math.max(ans, (i2-i1+1)*(j2-j1+1));
						 }
			 
			 pw.println(ans);
			 if(t>0)
				 pw.println();
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

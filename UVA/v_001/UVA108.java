package v_001;
import java.io.*;
import java.util.*;
public class UVA108 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		int n=sc.nextInt();
		int [][] a=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				a[i][j]=sc.nextInt();
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				a[i][j]+=(a[i][j-1]+a[i-1][j]-a[i-1][j-1]);
		int max=-127*100*100;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				for(int i2=i;i2<=n;i2++)
					for(int j2=j;j2<=n;j2++){
						int x=a[i2][j2]-a[i2][j-1]-a[i-1][j2]+a[i-1][j-1];
						if(x>max)
							max=x;
					}
		System.out.println(max);
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

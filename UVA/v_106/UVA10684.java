package v_106;
import java.io.*;
import java.util.*;
public class UVA10684 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			int [] a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			int max=-1;
			int sum=0;
			for(int i=0;i<n;i++){
				sum+=a[i];
				if(sum>max)
					max=sum;
				if(sum<0)
					sum=0;
					
			}
				
			System.out.println((max>0)? "The maximum winning streak is "+max+"." : "Losing streak.");
		}
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

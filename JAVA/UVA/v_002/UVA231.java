package v_002;
import java.io.*;
import java.util.*;
public class UVA231 {
	static int[]mem;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		int id=1;
		while(true){
			int x=sc.nextInt();
			if(x==-1)
				break;
			ArrayList<Integer> a=new ArrayList<Integer>();
			a.add(x);
			while(true){
				x=sc.nextInt();
				if(x==-1)
					break;
				a.add(x);
			}
			int max=0;
			int[] dp=new int[a.size()];
			dp[0]=1;
			for(int i=1;i<a.size();i++){
				dp[i]=1;
				for(int j=0;j<i;j++){
					if(a.get(j)>a.get(i) && 1+dp[j]>dp[i])
						dp[i]=1+dp[j];
				}
				if(dp[i]>max)
					max=dp[i];
			}
			if(id>1)
				System.out.println();
			System.out.println("Test #"+id+":");
			System.out.println("  maximum possible interceptions: "+max);
			id++;
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

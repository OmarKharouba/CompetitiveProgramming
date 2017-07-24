package v_109;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class UVA10911 {
	static int[]x;
	static int[]y;
	static int n;
	static double[]mem;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		int cnt=1;
		while(true){
			n=sc.nextInt()*2;
			if(n==0)
				break;
			x=new int[n];
			y=new int[n];
			mem=new double[(1<<n)];
			for(int i=0;i<(1<<n);i++)
				mem[i]=-1;
			for(int i=0;i<n;i++){
				sc.next();
				x[i]=sc.nextInt();
				y[i]=sc.nextInt();
			}
			DecimalFormat df=new DecimalFormat("#0.00");
			System.out.println("Case "+cnt+": "+df.format(dp(0)));
			cnt++;
		}
	}
	
	public static double dp(int mask){
		if(mask==(1<<n)-1)
			return 0;
		if(mem[mask]!=-1)
			return mem[mask];
		double ans=(1e8);
		int i;
		for(i=0;i<n && (mask & (1<<i))!=0;i++);
		for(int j=i+1 ;j<n;j++)
			if((mask & (1<<j))==0){
				double dx2=(x[i]-x[j])*(x[i]-x[j]);
				double dy2=(y[i]-y[j])*(y[i]-y[j]);
				double d=Math.sqrt(dx2+dy2);
				ans=Math.min(ans, d+dp(mask+(1<<i)+(1<<j)));
			}
		return mem[mask]=ans;
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

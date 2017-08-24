package v_116;
import java.io.*;
import java.util.*;
public class UVA11605 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int m=sc.nextInt();
			int p=sc.nextInt();
			int steps=sc.nextInt();
			double ans=0;
			int total=(n+n*(n-1)/2)*(m+m*(m-1)/2)*(p+p*(p-1)/2);
			for(int i=1;i<=n;i++)
				for(int j=1;j<=m;j++)
					for(int k=1;k<=p;k++){
						int i2=n-i+1;
						int j2=m-j+1;
						int k2=p-k+1;
						int sub=i*i2*j*j2*k*k2;
						ratio=1.0*sub/total;
						mem=new Double [2][steps+1];
						ans+=dp(0, steps);
					}
			pw.println(ans);
		}
		pw.flush();
		pw.close();
	}
	static double ratio;
	static Double [][] mem;
	
	static double dp(int on,int steps){
		if(steps==0)
			return on;
		if(mem[on][steps]!=null)
			return mem[on][steps];
		double ans=ratio*dp(on^1, steps-1)+(1-ratio)*dp(on, steps-1);
		return mem[on][steps]=ans;
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}
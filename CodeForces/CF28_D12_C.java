package codeforces;
import java.io.*;
import java.util.*;
public class CF28_D12_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		m=sc.nextInt();
		
		comb = new long[n+1][n+1];
		comb[0][0] = 1;
		for (int i = 1; i < n+1; i++)
		{
			comb[i][0] = 1;
			for (int j = 1; j <= i; j++)
				comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]);
		}
		c=new int [m];
		for(int i=0;i<m;i++)
			c[i]=sc.nextInt();
		mem=new Double [m+1][n+1][n+1];
		pw.println(dp(0, n, 0));
		pw.flush();
		pw.close();
	}
	static long [][] comb;
	static int m;
	static int [] c;
	static Double [][][] mem;
	
	static double dp(int i,int r,int max){
		if(i==m)
			return r==0? max : 0;
		if(mem[i][r][max]!=null)
			return mem[i][r][max];
		double ans=0;
		double p=1.0;
		for(int j=0;j<=r;j++){
			ans+=comb[r][j]*p*dp(i+1, r-j, Math.max(max, (int)Math.ceil(1.0*j/c[i])));
			p/=m;
		}
		return mem[i][r][max]=ans;
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
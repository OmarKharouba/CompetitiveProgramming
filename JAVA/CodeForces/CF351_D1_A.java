package codeforces;
import java.io.*;
import java.util.*;
public class CF351_D1_A {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		double [] a=new double [2*n];
		for(int i=0;i<2*n;i++)
			a[i]=sc.nextDouble();
		double [][] mem=new double [2][n+1];
		double inf=1e8;
		int p=0;
		Arrays.fill(mem[0], inf);
		mem[0][n]=0;
		for(int i=2*n-1;i>=0;i--){
			p=1-p;
			for(int j=n;j>=0;j--){
				mem[p][j]=Math.ceil(a[i])-a[i]+mem[1-p][j];
				if(j+1<=n){
					double f=Math.floor(a[i])-a[i]+mem[1-p][j+1];
					if(Math.abs(f)<Math.abs(mem[p][j]))
						mem[p][j]=f;
				}
			}
		}
		pw.printf("%.3f\n",Math.abs(mem[p][0]));		
		pw.flush();
		pw.close();
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
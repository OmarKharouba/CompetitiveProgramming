package codeforces;
import java.io.*;
import java.util.*;
public class CF839_D2_A {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		int [] a=new int [n];
		int ans=-1;
		int sum=0;
		int give=0;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			sum+=a[i];
			int r=Math.min(8, sum);
			give+=r;
			sum-=r;
			if(give>=k){
				ans=i+1;
				break;
			}
		}
		pw.println(ans);
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
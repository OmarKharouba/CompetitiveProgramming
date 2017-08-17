package codeforces;
import java.io.*;
import java.util.*;
public class CF839_D2_B {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		boolean ok=true;
		int n=sc.nextInt();
		int k=sc.nextInt();
		int [] a=new int [k];
		for(int i=0;i<k;i++)
			a[i]=sc.nextInt();
		int four=n;
		int two=n*2;
		for(int i=0;i<k;i++){
			int r=Math.min(four, a[i]/4);
			four-=r;
			a[i]-=r*4;
		}
		two+=four;
		for(int i=0;i<k;i++){
			int r=Math.min(two, a[i]/2);
			two-=r;
			a[i]-=r*2;
		}
		int seats=two+four;
		for(int i=0;i<k;i++)
			if(seats<a[i])
				ok=false;
			else
				seats-=a[i];
		pw.println(ok? "YES" : "NO");
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
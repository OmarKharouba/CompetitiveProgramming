package codeforces;

import java.io.*;
import java.util.*;
public class CF841_D2_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int [] a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		pair [] b=new pair [n];
		for(int i=0;i<n;i++)
			b[i]=new pair(sc.nextInt(), i);
		Arrays.sort(a);
		Arrays.sort(b);
		int [] ans=new int [n];
		for(int i=0;i<n;i++)
			ans[b[i].i]=a[n-1-i];
		for(int x : ans)
			pw.print(x+" ");
		pw.println();
		pw.flush();
		pw.close();
	}
	
	static class pair implements Comparable<pair>{
		int x,i;
		pair(int a,int id){
			x=a;
			i=id;
		}
		
		public int compareTo(pair o) {
			return x-o.x;
		}
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
package v_012;

import java.io.*;
import java.util.*;
public class UVA1251 {
	static int inf=10000;
	static int n;
	static String y;
	static String [] a,b;
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		
		
		while(true){
			n=sc.nextInt();
			if(n==0)
				break;
			a=new String [n];
			b=new String [n];
			for(int i=0;i<n;i++){
				a[i]=sc.next();
				b[i]=sc.next();
			}
			String x=sc.next();
			y=sc.next();
			int ans=solve(x);
			if(ans>10)
				pw.println(-1);
			else
				pw.println(ans);
		}
		
		pw.flush();
		pw.close();
	}
	
	public static int solve(String x){
		if(x.length()>y.length())
			return inf;
		if(x.equals(y))
			return 0;
		int ans=inf;
		for(int i=0;i<n;i++){
			String tmp=x.replace(a[i], b[i]);
			if(tmp.length()>x.length())
				ans=Math.min(ans, 1+solve(tmp));
		}
		return ans;
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
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
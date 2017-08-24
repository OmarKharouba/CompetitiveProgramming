package atcoder;
import java.io.*;
import java.util.*;
public class abc070_c {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt()-1;
		long lcm=sc.nextLong();
		while(n-->0){
			long t=sc.nextLong();
			long g=gcd(lcm, t);
			lcm=(lcm/g)*t;
		}
		pw.println(lcm);
		pw.flush();
		pw.close();
	}
	
	static long gcd(long a,long b){
		return b==0? a : gcd(b,a%b);
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
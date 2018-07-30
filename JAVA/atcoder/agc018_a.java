package atcoder;
import java.io.*;
import java.util.*;
public class agc018_a {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		int [] a=new int [n];
		boolean ok=false;
		boolean greater=false;
		int g=0;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			if(a[i]==k)
				ok=true;
			if(a[i]>k)
				greater=true;
			g=gcd(a[i], g);
		}
		if(greater && k%g==0)
			ok=true;
		pw.println(ok? "POSSIBLE" : "IMPOSSIBLE");
		pw.flush();
		pw.close();
	}
	
	static int gcd(int a,int b){
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
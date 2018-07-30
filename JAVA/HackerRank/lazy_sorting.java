
import java.io.*;
import java.util.*;
public class lazy_sorting {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int [] c=new int [101];
		boolean sorted=true;
		int last=-1;
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			if(x<last)
				sorted=false;
			c[x]++;
			last=x;
		}
		long [] fac=new long [20];
		fac[0]=1;
		for(int i=1;i<20;i++)
			fac[i]=fac[i-1]*i;
		long total=fac[n];
		long sub=1;
		for(int i=1;i<=100;i++)
			sub*=fac[c[i]];
		double p=1.0*sub/total;
		double ans=1.0/p;
		if(sorted)
			ans=0;
		pw.printf("%.6f\n",ans);
		pw.flush();
		pw.close();
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

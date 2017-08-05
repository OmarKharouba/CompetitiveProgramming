import java.io.*;
import java.util.*;
public class CF837_D12_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();
		int [] x=new int [n];
		int [] y=new int [n];
		for(int i=0;i<n;i++){
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		int max=0;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++){
				if((x[i]+y[j]<=a && y[i]<=b && x[j]<=b) || (x[i]+x[j]<=a && y[i]<=b && y[j]<=b) || (y[i]+x[j]<=a && x[i]<=b && y[j]<=b) || (y[i]+y[j]<=a && x[i]<=b && x[j]<=b)){
					max=Math.max(max, x[i]*y[i]+x[j]*y[j]);
				}
				if((x[i]+y[j]<=b && y[i]<=a && x[j]<=a) || (x[i]+x[j]<=b && y[i]<=a && y[j]<=a) || (y[i]+x[j]<=b && x[i]<=a && y[j]<=a) || (y[i]+y[j]<=b && x[i]<=a && x[j]<=a)){
					max=Math.max(max, x[i]*y[i]+x[j]*y[j]);
				}
			}
		
		pw.println(max);
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
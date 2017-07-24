package v_103;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class UVA10346 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
//		int t=3;
//		while(t-->0){
		while(sc.br.ready()){
			int n=sc.nextInt();
			int k=sc.nextInt();
			int rem=0;
			long c=0;
			while(n>0){
				c+=n;
				rem+=n;
				n=rem/k;
				rem%=k;
			}
			pw.println(c);
		}
		
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

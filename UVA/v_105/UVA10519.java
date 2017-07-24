package v_105;
import java.io.*;
import java.math.*;
import java.util.*;
public class UVA10519 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
//		int t=4;
//		while(t-->0){
		while(sc.br.ready()){
			String s=sc.next();
			BigInteger x=new BigInteger(s);
			BigInteger y=x.subtract(new BigInteger("1"));
			BigInteger ans=new BigInteger("2");
			BigInteger sum=x.multiply(y);
			ans=ans.add(sum);
			pw.println(s.equals("0")? 1 : ans);
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

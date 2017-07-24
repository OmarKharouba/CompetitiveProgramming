package v_104;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class UVA10494 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		while(sc.br.ready()){
			BigInteger x=new BigInteger(sc.next());
			char c=sc.next().charAt(0);
			BigInteger y=new BigInteger(sc.next());
			if(c=='/'){
				pw.println(x.divide(y));
			}else{
				pw.println(x.remainder(y));
			}
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

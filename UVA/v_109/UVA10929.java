package v_109;
import java.io.*;
import java.math.*;
import java.util.*;
public class UVA10929 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		while(true){
			String s=sc.next();
			if(s.equals("0"))
				break;
			BigInteger x=new BigInteger(s);
			BigInteger el=new BigInteger("11");
			BigInteger y=x.divide(el);
			if(el.multiply(y).equals(x))
				pw.println(s+" is a multiple of 11.");
			else
				pw.println(s+" is not a multiple of 11.");
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

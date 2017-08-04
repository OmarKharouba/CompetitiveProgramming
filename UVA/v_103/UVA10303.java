package v_103;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class UVA10303 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(sc.br.ready()){			
			int n=sc.nextInt();
			mem=new BigInteger [n+1];
			pw.println(dp(n));
		}
		pw.flush();
		pw.close();
	}
	
	static BigInteger [] mem;
	
	static BigInteger dp(int i){
		if(i<2)
			return BigInteger.ONE;
		if(mem[i]!=null)
			return mem[i];
		BigInteger ans=BigInteger.ZERO;
		for(int j=0;j<i;j++){
			ans=ans.add(dp(j).multiply(dp(i-j-1)));
		}
		return mem[i]=ans;
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("test.in")));
			} catch (Exception e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
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

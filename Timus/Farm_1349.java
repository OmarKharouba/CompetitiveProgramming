import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Farm_1349 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		BigInteger [] val=new BigInteger [101];
		for(int i=1;i<=100;i++){
			BigInteger b=new BigInteger(""+i);
			val[i]=b.pow(n);
		}
		String ans="-1";
		outer : for(int i=1;i<=100;i++)
			for(int j=i+1;j<=100;j++){
				BigInteger other=val[i].add(val[j]);
				for(int k=j+1;k<=100;k++)
					if(val[k].equals(other)){
						ans=i+" "+j+" "+k;
						break outer;
					}
			}
		pw.println(ans);
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
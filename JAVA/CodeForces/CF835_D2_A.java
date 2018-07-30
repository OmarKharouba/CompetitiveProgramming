import java.io.*;
import java.util.*;
public class CF835_D2_A {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int s=sc.nextInt();
		int v1=sc.nextInt();
		int v2=sc.nextInt();
		int t1=sc.nextInt();
		int t2=sc.nextInt();
		
		int n1=t1*2+s*v1;
		int n2=t2*2+s*v2;
		if(n1<n2)
			pw.println("First");
		else
			if(n1>n2)
				pw.println("Second");
			else
				pw.println("Friendship");
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
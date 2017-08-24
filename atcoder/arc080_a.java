package atcoder;
import java.io.*;
import java.util.*;
public class arc080_a {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int c4=0,c1=0;
		for(int i=0;i<n;i++){
			int x=sc.nextInt()%4;
			if(x==0)
				c4++;
			else
				if(x!=2)
					c1++;
		}
		if(c1+c4==n)
			pw.println(c4>=c1-1? "Yes" : "No");
		else
			pw.println(c4>=c1? "Yes" : "No");
		
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
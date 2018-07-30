import java.io.*;
import java.util.*;
public class CF837_D12_A {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=Integer.parseInt(sc.nextLine());
		String [] sa=sc.nextLine().split(" ");
		int max=0;
		
		for(String s : sa){
			int cnt=0;
			for(char c : s.toCharArray())
				if(c>='A' && c<='Z')
					cnt++;
			max=Math.max(max, cnt);
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
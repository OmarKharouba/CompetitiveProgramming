package v_112;
import java.io.*;
import java.util.*;
public class UVA11207 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		double eps=1e-9;
		while(true){
			int ans=0;
			double max=0;
			int n=sc.nextInt();
			if(n==0)
				break;
			for(int i=0;i<n;i++){
				double x=sc.nextInt();
				double y=sc.nextInt();
				double cur=Math.min(x, y)/2.0;
				cur=Math.max(cur, Math.min(x/4.0, y));
				cur=Math.max(cur, Math.min(y/4.0, x));
				if(cur>max+eps){
					max=cur;
					ans=i+1;
				}
			}
			pw.println(ans);
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

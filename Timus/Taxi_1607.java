
import java.io.*;
import java.util.*;
public class Taxi_1607 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
		int ans=a;
		int p=0;
		if(a>=c){
			pw.println(a);
			pw.flush();
			return;
		}
		while(true){
			if(p==0){
				a+=b;
				if(a>c){
					ans=c;
					break;
				}
			}else{
				c-=d;
				if(c<a){
					ans=a;
					break;
				}
			}
			p=1-p;
		}
		pw.println(ans);
		
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
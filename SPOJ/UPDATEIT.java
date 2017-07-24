import java.util.*;
import java.io.*;
public class UPDATEIT {
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt(),u=sc.nextInt();
			long [] a=new long [n];
			for(int i=0;i<u;i++){
				int l=sc.nextInt();
				int r=sc.nextInt()+1;
				int val=sc.nextInt();
				a[l]+=val;
				if(r<n)
					a[r]-=val;
			}
			for(int i=1;i<n;i++)
				a[i]+=a[i-1];
			int q=sc.nextInt();
			while(q-->0){
				int x=sc.nextInt();
				pw.println(a[x]);
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

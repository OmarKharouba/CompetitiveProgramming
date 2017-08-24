package codeforces;
import java.io.*;
import java.util.*;
public class CF101471_GYM_E {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int t=sc.nextInt();
		int [] a=new int [n];
		int [] b=new int [n];
		int min=(int)(1e9);
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
			min=Math.min(min,b[i]);
		}
		min*=-1;
		double start=min,end=1e18;
		for(int i=0;i<300;i++){
			double c=(start+end)/2;
			double tt=0;
			for(int j=0;j<n;j++){
				if(b[j]+c!=0)
					tt+=1.0*a[j]/(b[j]+c);
			}
			if(tt>=t){
				start=c;
			}else{
				end=c;
			}
		}
		
		pw.println(start);
		
		
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

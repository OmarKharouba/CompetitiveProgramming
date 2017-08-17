package codeforces;
import java.io.*;
import java.util.*;
public class CF334_D2_A {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int p=0;
		int x=1;
		int [][] a=new int [n][n];
		int k=0;
		for(int j=0;j<n;j++){
			for(int i=0;i<n;i++){
				a[k][j]=x++;
				if(p==0)
					k++;
				else
					k--;
			}
			if(p==1)
				k++;
			else
				k--;
			p^=1;
		}
		for(int [] y : a){			
			for(int z :y)
				pw.print(z+" ");
			pw.println();
		}
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
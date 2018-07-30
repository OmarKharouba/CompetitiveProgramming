package v_005;

import java.io.*;
import java.util.*;
public class UVA542 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int n=16;
		String [] names=new String [n];
		for(int i=0;i<n;i++)
			names[i]=sc.next();
		double [][] p=new double [n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				p[i][j]=sc.nextInt()/100.0;
		
		int m=4;
		double [][] ans=new double [n][m];
		for(int i=0;i<n;i++)
			ans[i][0]=(i%2==0? p[i][i+1] : p[i][i-1]);
		int group=4;
		for(int j=1;j<m;j++){
			int pregroup=group/2;
			for(int i=0;i<n;i++){
				int pos=i/group;
				int prepos=i/pregroup;
				double sum=0;
				for(int k=0;k<n;k++){
					if(k/group==pos && k/pregroup!=prepos)
						sum+=p[i][k]*ans[k][j-1];
				}
				ans[i][j]=ans[i][j-1]*sum;
			}
			group*=2;
		}
		for(int i=0;i<n;i++){
			pw.print(names[i]);
			int cc=11-names[i].length();
			while(cc-->0)
				pw.print(" ");
			pw.print("p=");
			pw.printf("%.2f",ans[i][3]*100);
			pw.println("%");
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
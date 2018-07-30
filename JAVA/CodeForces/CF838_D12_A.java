package codeforces;
import java.io.*;
import java.util.*;
public class CF838_D12_A {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		char [][] a=new char [n][m];
		for(int i=0;i<n;i++)
			a[i]=sc.next().toCharArray();
		int [][] cum0=new int [n][m];
		int [][] cum1=new int [n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				if(a[i][j]=='0')
					cum0[i][j]++;
				else
					cum1[i][j]++;
				if(i>0){
					cum0[i][j]+=cum0[i-1][j];
					cum1[i][j]+=cum1[i-1][j];
				}
				if(j>0){
					cum0[i][j]+=cum0[i][j-1];
					cum1[i][j]+=cum1[i][j-1];
				}
				if(i>0 && j>0){
					cum0[i][j]-=cum0[i-1][j-1];
					cum1[i][j]-=cum1[i-1][j-1];
				}
			}
		int min=n*m;
		for(int k=2;k<=Math.max(n, m);k++){
			int cnt=0;
			for(int i=0;i<n;i+=k)
				for(int j=0;j<m;j+=k){
					int minI=Math.min(i+k-1, n-1);
					int minJ=Math.min(j+k-1, m-1);
					int cnt0=cum0[minI][minJ],cnt1=cum1[minI][minJ];
					if(i>0){
						cnt0-=cum0[i-1][minJ];
						cnt1-=cum1[i-1][minJ];
					}
					if(j>0){
						cnt0-=cum0[minI][j-1];
						cnt1-=cum1[minI][j-1];
					}
					if(i>0 && j>0){
						cnt0+=cum0[i-1][j-1];
						cnt1+=cum1[i-1][j-1];
					}
					int rem=k*k-cnt0-cnt1;
					cnt0+=rem;
					cnt+=Math.min(cnt0, cnt1);
				}
			min=Math.min(min, cnt);
		}
		pw.println(min);
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
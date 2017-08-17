package codeforces;
import java.io.*;
import java.util.*;
public class CF157_D2_E {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int mod=(int)1e9+7;
		int [][][] mem=new int [101][101][2501];
		int [] cum=new int[2501];
		for(int i=1;i<=100;i++)
			mem[i][i][0]=1;
		for(int i=1;i<=100;i++){
			Arrays.fill(cum, 1);
			for(int j=i-1;j>=0;j--){
				for(int k=2500;k>=0;k--){
					mem[i][j][k]+=cum[k];
					mem[i][j][k]%=mod;
					mem[i][j][k]-=(k-25>0? cum[k-26] : 0);
					mem[i][j][k]%=mod;
					mem[i][j][k]+=mod;
					mem[i][j][k]%=mod;
				}
				for(int k=0;k<=2500;k++)
					cum[k]=mem[i][j][k];
				for(int k=1;k<=2500;k++){
					cum[k]+=cum[k-1];
					cum[k]%=mod;
				}
			}
		}
		int t=sc.nextInt();
		StringBuilder ans=new StringBuilder();
		while(t-->0){
			int sum=0;
			String s=sc.next();
			int n=s.length();
			for(char c : s.toCharArray())
				sum+=c-'a';
			ans.append(mem[n][0][sum]-1+"\n");
		}
		pw.print(ans);
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
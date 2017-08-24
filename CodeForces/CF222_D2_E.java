package codeforces;
import java.io.*;
import java.util.*;
public class CF222_D2_E {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		long n=sc.nextLong()-1;
		int m=sc.nextInt();
		int [][] base=new int [m][m];
		for(int [] x : base)
			Arrays.fill(x, 1);
		int [][] other=new int [m][1];
		for(int i=0;i<m;i++)
			other[i][0]=1;
		int k=sc.nextInt();
		while(k-->0){
			String s=sc.next();
			char c1=s.charAt(0);
			char c2=s.charAt(1);
			int x=0,y=0;
			if(c1>='a' && c1<='z')
				x=c1-'a';
			else
				x=c1-'A'+26;
			if(c2>='a' && c2<='z')
				y=c2-'a';
			else
				y=c2-'A'+26;
			base[x][y]=0;
		}
		int [][] res=matMul(matPow(base, n), other, m, m, 1);
		int ans=0;
		for(int i=0;i<m;i++){
			ans=(ans+res[i][0])%mod;
		}
		pw.println(ans);
		pw.flush();
		pw.close();
	}
	
	static int mod=(int)1e9+7;
	static int[][] matMul(int[][] A, int[][] B, int p, int q, int r){
		int[][] C = new int[p][r];
		for(int i = 0; i < p; ++i)
			for(int j = 0; j < r; ++j)
				for(int k = 0; k < q; ++k)
					C[i][j] = (int)(C[i][j]+1L* A[i][k] * B[k][j]%mod)%mod;
		return C;
	}
	
	static int[][] matPow(int[][] base, long p){
		int n = base.length;
		int[][] ans = new int[n][n];
		for(int i = 0; i < n; i++)
			ans[i][i] = 1;
		while(p != 0){
			if((p & 1) == 1)
				ans = matMul(ans, base, n, n, n);
			base = matMul(base, base, n, n, n);
			p >>= 1;
		}	
		return ans;
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
package codeforces;
import java.io.*;
import java.util.*;
public class CF621_D2_E {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int b=sc.nextInt();
		int k=sc.nextInt();
		int x=sc.nextInt();
		int [] c=new int [x];
		for(int i=0;i<n;i++)
			c[sc.nextInt()%x]++;
		int [][] base=new int [x][x];
		int [][] other=new int [x][1];
		for(int i=0;i<x;i++){
			for(int j=0;j<x;j++){		
				int m=(j*10)%x;
				base[i][j]=c[(i-m+x)%x];
			}
		}
//		System.out.println(Arrays.deepToString(base));
		other[0][0]=1;
		int [][] res=matMul(matPow(base, b), other, x, x, 1);
		pw.println(res[k][0]);
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
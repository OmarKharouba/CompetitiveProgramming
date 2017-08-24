import java.io.*;
import java.util.*;
public class SEQ {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int [][] a=new int [n][1];
			int [] b=new int [n];
			for(int i=0;i<n;i++)
				a[i][0]=sc.nextInt();
			for(int i=0;i<n;i++)
				b[i]=sc.nextInt();
			int x=sc.nextInt()-1;
			if(x<n)
				pw.println(a[x][0]);
			else{
				int pow=x-n+1;
				int [][] base=new int [n][n];
				for(int i=0;i<n-1;i++){
					base[i][i+1]=1;
				}
				for(int j=0;j<n;j++)
					base[n-1][j]=b[n-1-j];
				int [][] res=matMul(matPow(base, pow), a, n, n, 1);
				pw.println(res[n-1][0]);
			}
		}
		
		pw.flush();
		pw.close();
	}
	static int mod=(int)1e9;
	static int[][] matMul(int[][] A, int[][] B, int p, int q, int r){
		int[][] C = new int[p][r];
		for(int i = 0; i < p; ++i)
			for(int j = 0; j < r; ++j)
				for(int k = 0; k < q; ++k)
					C[i][j] = (int)(C[i][j]+1L* A[i][k] * B[k][j]%mod)%mod;
		return C;
	}
	
	static int[][] matPow(int[][] base, int p){
		int n = base.length;
		int[][] ans = new int[n][n];
		for(int i = 0; i < n; i++)
			ans[i][i] = 1;
		while(p != 0)
		{
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

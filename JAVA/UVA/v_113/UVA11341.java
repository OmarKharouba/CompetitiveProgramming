package v_113;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class UVA11341 {
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		DecimalFormat df=new DecimalFormat("0.00");
		int t=sc.nextInt();
		while(t-->0){
			n=sc.nextInt();
			m=sc.nextInt();
			a=new int [n][m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					a[i][j]=sc.nextInt();
			mem=new int [n+1][m+1];
			for(int [] x : mem)
				Arrays.fill(x, -1);
			int sum=dp(0, 0);
			if(sum>0)
				pw.printf("Maximal possible average mark - %.2f.\n",1.0*sum/n);
			else
				pw.println("Peter, you shouldn't have played billiard that much.");
		}
		
		pw.flush();
		pw.close();
	}
	static int n,m;
	static int inf=(int)1e8;
	static int [][] mem;
	static int [][] a;
	public static int dp(int i,int total){
		if(i==n){
			if(total<=m)
				return 0;
			return -inf;
		}
		if(mem[i][total]!=-1)
			return mem[i][total];
		int ans=-inf;
		for(int j=0;j<m;j++)
			if(a[i][j]>=5 && total+j+1<=m)
				ans=Math.max(ans, a[i][j]+dp(i+1, total+j+1));
		
		
		return mem[i][total]=ans;
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("alost.in")));
			} catch (FileNotFoundException e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
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

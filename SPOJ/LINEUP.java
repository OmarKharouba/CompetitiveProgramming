import java.io.*;
import java.util.*;
public class LINEUP {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=11;
		int t=sc.nextInt();
		while(t-->0){
			a=new int [11][11];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j]=sc.nextInt();
			mem=new int [n+1][1<<12];
			for(int [] x : mem)
				Arrays.fill(x, -1);
			pw.println(dp(0, 0));
		}
		
		pw.flush();
		pw.close();
	}
	static int n;
	static int [][] a;
	static int [][] mem;
	static int inf=(int)1e8;
	static int dp(int i,int msk){
		if(Integer.bitCount(msk)==11)
			return 0;
		if(mem[i][msk]!=-1)
			return mem[i][msk];
		int ans=-inf;
		for(int j=0;j<n;j++){
			if((msk & (1<<j))==0 && a[i][j]>0){
				ans=Math.max(ans, a[i][j]+dp(i+1, msk | (1<<j)));
			}
		}
		return mem[i][msk]=ans;
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("boring.in")));
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
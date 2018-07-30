package v_120;
import java.io.*;
import java.util.*;

public class UVA12063 {
	public static void main(String[] args) throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		for(int i=1;i<=t;i++){
			n=sc.nextInt();
			k=sc.nextInt();
			if(k==0){
				pw.println("Case "+i+": 0");
				continue;
			}
			mem=new long [n][k][n+1];
			for(long [][] x : mem)
				for(long [] y : x)
					Arrays.fill(y, -1);
			pw.println("Case "+i+": "+dp(0, 0, 0));
		}
		
		pw.flush();
		pw.close();
	}
	static int n,k;
	static long [][][] mem;
	
	static long dp(int idx,int mod,int zeros){
		if(idx==n-1){
			mod=(int)((mod+(1L<<(n-1))%k)%k);
			return (zeros*2==n && mod==0)? 1 : 0;
		}
		if(mem[idx][mod][zeros]!=-1)
			return mem[idx][mod][zeros];
		long ans=dp(idx+1, mod,zeros+1)+dp(idx+1,(int)((mod+(1L<<(idx)))%k)%k,zeros);
		return mem[idx][mod][zeros]=ans;
	}
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("test.in")));
			} catch (Exception e) {
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

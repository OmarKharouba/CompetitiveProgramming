package codeforces;
import java.io.*;
import java.util.*;
public class CF838_D12_E {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		x=new long [n];
		y=new long [n];
		for(int i=0;i<n;i++){
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		mem=new Double [2][n+1][n+1];
		double max=0;
		for(int i=0;i<n;i++){
			int nxt=nxt(i);
			max=Math.max(max, dis(i, nxt)+Math.max(dp(0, i, nxt), dp(1, i, nxt)));
		}
		
		pw.println(max);
		pw.flush();
		pw.close();
	}
	static int n;
	static long [] x,y;
	static Double [][][] mem;
	
	static double dp(int c, int i,int j){
		if(i==nxt(j))
			return 0;
		if(mem[c][i][j]!=null)
			return mem[c][i][j];
		double ans=0;
		int pre=pre(i);
		int nxt=nxt(j);
		if(c==0){
			double op1=dis(i, pre)+dp(0, pre, j);
			double op2=dis(i, nxt)+dp(1, i, nxt);
			ans=Math.max(op1, op2);
		}else{
			double op2=dis(j, nxt)+dp(1, i, nxt);
			double op1=dis(j, pre)+dp(0, pre, j);
			ans=Math.max(op1, op2);
		}
		return mem[c][i][j]=ans;
	}
	
	static double dis(int i,int j){
		return Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
	}
	
	static int nxt(int i){
		return (i+1)%n;
	}
	static int pre(int i){
		return (i-1+n)%n;
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
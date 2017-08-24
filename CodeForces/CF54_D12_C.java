package codeforces;
import java.io.*;
import java.util.*;
public class CF54_D12_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		cntOne=new long [n];
		cntNO=new long [n];
		all=new long [n];
		for(int i=0;i<n;i++){
			long l=sc.nextLong();
			long r=sc.nextLong();
			all[i]=r-l+1;
			cntOne[i]=cntOnes(l, r);
			cntNO[i]=all[i]-cntOne[i];
		}
		k=sc.nextInt();
		mem=new Double [n+1][n+1];
		pw.println(dp(0, 0));
		pw.flush();
		pw.close();
	}
	
	static int n,k;
	static long [] cntOne,cntNO,all;
	static Double [][] mem;
	
	static double dp(int i,int ones){
		if(i==n){
			if(ones*100>=n*k)
				return 1;
			return 0;
		}
		if(mem[i][ones]!=null)
			return mem[i][ones];
		double ret=(1.0*cntOne[i]/all[i])*dp(i+1, ones+1)+(1.0*cntNO[i]/all[i])*dp(i+1, ones);
		return mem[i][ones]=ret;
	}
	
	
	static long cntOnes(long l,long r){
		long ret=0;
		if(1>=l && 1<=r)
			ret++;
		if(1e18>=l && 1e18<=r)
			ret++;
		for(int len=2;len<=18;len++){
			String s1="1",s2="1";
			for(int i=0;i<len-1;i++){
				s1+="0";
				s2+="9";
			}
			long min=Long.parseLong(s1);
			long max=Long.parseLong(s2);
			max=Math.min(max, r);
			min=Math.max(min, l);
			if(max>=min)
				ret+=(max-min+1);
		}
		return ret;
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
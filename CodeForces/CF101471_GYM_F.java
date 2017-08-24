package codeforces;
import java.io.*;
import java.util.*;

public class CF101471_GYM_F {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		k=sc.nextInt();
		v=new int [n];
		c=new int [n];
		for(int i=0;i<n;i++){
			v[i]=sc.nextInt();
			c[i]=sc.nextInt();
		}
		min=new long [256][257];
		for(int i=0;i<256;i++)
			for(int j=i;j<257;j++){
				for(int k=0;k<n;k++)
					if(v[k]>=i && v[k]<=j){				
						if(j<256)
							min[i][j]+=1L*c[k]*Math.min((v[k]-i)*(v[k]-i), (v[k]-j)*(v[k]-j));
						else
							min[i][j]+=1L*c[k]*(v[k]-i)*(v[k]-i);
					}
			}
		mem=new long [257][257][257];
		for(long [][] x : mem)
			for(long [] y : x)
				Arrays.fill(y, -1);
		long ans=inf;
		for(int i=0;i<256;i++){
			long val=0;
			int p=0;
			while(p<n && v[p]<=i){
				val+=1L*c[p]*(v[p]-i)*(v[p]-i);
				p++;
			}
			ans=Math.min(ans, val+dp(i, 1, i));
		}
		pw.println(ans);
		pw.flush();
		pw.close();
	}
	static int n,k;
	static int [] v,c;
	static long inf=(long)(1e16);
	static long [][][] mem;
	static long [][] min;
	
	static long dp(int idx,int cnt,int last){
		if(idx==256)
			return min[last][idx];
		if(mem[idx][cnt][last]!=-1)
			return mem[idx][cnt][last];
		long ans=dp(idx+1, cnt, last);
		if(cnt<k)
			ans=Math.min(ans, min[last][idx]+dp(idx+1, cnt+1, idx));
		return mem[idx][cnt][last]=ans;
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
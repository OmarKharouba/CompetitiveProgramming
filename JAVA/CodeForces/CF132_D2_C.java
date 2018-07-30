package codeforces;
import java.io.*;
import java.util.*;
public class CF132_D2_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		a=sc.next().toCharArray();
		offset=n=a.length;
		mem=new int [2][n+1][n+1][n+1+offset];
		for(int i=0;i<=n;i++){
			for(int j=0;j<n;j++){				
				Arrays.fill(mem[0][i][j], -1);
				Arrays.fill(mem[1][i][j], -1);
			}
		}
		k=sc.nextInt();
		pw.println(Math.max(dp(0, 0, 0, 0), dp(1, 0, 0, 0)));
		
		pw.flush();
		pw.close();
	}
	static int n,k,offset;
	static char [] a;
	static int [][][][] mem;
	
	static int dp(int dir,int idx,int cnt,int dis){
		if(idx==n){
			if(cnt<=k && (k-cnt)%2==0)
				return Math.abs(dis);
			return 0;
		}
		if(mem[dir][idx][cnt][dis+offset]!=-1)
			return mem[dir][idx][cnt][dis+offset];
		int ans=0;
		if(dir==0){
			if(a[idx]=='F'){
				ans=Math.max(dp(dir^1, idx+1, cnt+1, dis), dp(dir, idx+1, cnt, dis+1));
			}else{ // T
				ans=Math.max(dp(dir^1, idx+1, cnt, dis), dp(dir, idx+1, cnt+1, dis+1));
			}
		}else{
			if(a[idx]=='F'){
				ans=Math.max(dp(dir^1, idx+1, cnt+1, dis), dp(dir, idx+1, cnt, dis-1));
			}else{ // T
				ans=Math.max(dp(dir^1, idx+1, cnt, dis), dp(dir, idx+1, cnt+1, dis-1));
			}
		}
		return mem[dir][idx][cnt][dis+offset]=ans;
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
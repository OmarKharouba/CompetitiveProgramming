package v_005;

import java.io.*;
import java.util.*;
public class UVA572 {
	static boolean [][] oil;
	static boolean [][] v;
	static int n,m,c;
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			n=sc.nextInt();
			m=sc.nextInt();
			if(n==0 && m==0)
				break;
			oil=new boolean [n][m];
			v=new boolean [n][m];
			for(int i=0;i<n;i++){
				char [] c=sc.next().toCharArray();
				for(int j=0;j<m;j++)
					oil[i][j]=c[j]=='@';
			}
			c=0;
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					if(!v[i][j] && oil[i][j]){
						c++;
						dfs(i,j);
					}
			pw.println(c);
		}
		pw.flush();
		pw.close();
	}
	static int [] dx={1,1,1,0,0,-1,-1,-1};
	static int [] dy={0,1,-1,1,-1,0,1,-1};
	public static void dfs(int r,int c){
		v[r][c]=true;
		for(int i=0;i<8;i++){
			int rr=r+dx[i];
			int cc=c+dy[i];
			if(valid(rr, cc))
				dfs(rr, cc);
		}
	}
	
	public static boolean valid(int r,int c){
		return r>=0 && r<n && c>=0 && c<m && oil[r][c] && !v[r][c];
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
package v_119;

import java.io.*;
import java.util.*;
public class UVA11902 {
	static int n;
	static boolean [][] adj,ans;
	static boolean []v;
	static int removed;
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		int id=1;
		while(t-->0){
			n=sc.nextInt();
			v=new boolean [n];
			adj=new boolean [n][n];
			ans=new boolean [n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					adj[i][j]=sc.nextInt()==0? false : true;
			for(int i=0;i<n;i++){
				removed=i;
				Arrays.fill(v, false);
				if(i>0)
					dfs(0);
				for(int j=0;j<n;j++)
					if(!v[j])
						ans[i][j]=true;
			}
			Arrays.fill(v, false);
			removed=-1;
			dfs(0);
			for(int i=0;i<n;i++)
				if(!v[i])
					for(int j=0;j<n;j++)
						ans[j][i]=false;
			pw.printf("Case %d:\n",id);
			StringBuilder sb=new StringBuilder();
			sb.append("+");
			for(int i=0;i<2*n-1;i++)
				sb.append("-");
			sb.append("+");
			pw.println(sb);
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
					pw.print("|"+(ans[i][j]? "Y" : "N"));
				pw.println("|");
				pw.println(sb);
			}
			id++;
		}
		pw.flush();
		pw.close();
	}
	
	public static void dfs(int u){
		v[u]=true;
		for(int i=0;i<n;i++)
			if(adj[u][i] && !v[i] && i!=removed)
				dfs(i);
	}
	
	static class pair implements Comparable<pair>{
		int id,hairs,dis;
		
		pair(int i,int h,int d){
			id=i;
			hairs=h;
			dis=d;
		}
		
		public int compareTo(pair o) {
			if(hairs!=o.hairs)
				return o.hairs-hairs;
			return o.dis-dis;
		}
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
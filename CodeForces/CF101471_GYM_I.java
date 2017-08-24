package codeforces;
import java.io.*;
import java.util.*;
public class CF101471_GYM_I {
	static boolean [] v;
	static ArrayList<Integer> [] adj;
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int m=sc.nextInt();
		int n=sc.nextInt();
		adj=new ArrayList[26];
		for(int i=0;i<26;i++)
			adj[i]=new ArrayList<Integer>();
		while(m-->0){
			int u=sc.next().charAt(0)-'a';
			int v=sc.next().charAt(0)-'a';
			adj[u].add(v);
		}
		v=new boolean [26];
		while(n-->0){
			String a=sc.next();
			String b=sc.next();
			boolean f=true;
			if(a.length()!=b.length())
				f=false;
			else
			for(int i=0;i<a.length();i++){
				char c1=a.charAt(i);
				char c2=b.charAt(i);
				Arrays.fill(v, false);
				if(c1==c2)
					continue;
				dfs(c1-'a');
				if(!v[c2-'a'])
					f=false;
			}
			pw.println(f? "yes" : "no" );
		}
		
		pw.flush();
		pw.close();
	}
	
	public static void dfs(int u){
		v[u]=true;
		for(int i  : adj[u])
			if(!v[i])
				dfs(i);
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

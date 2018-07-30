package codeforces;
import java.io.*;
import java.util.*;
public class CF101471_GYM_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		m=sc.nextInt();
		adj=new ArrayList [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		int [][] a=new int [n][m];
		int [] maxR=new int [n];
		int [] maxC=new int [m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				a[i][j]=sc.nextInt();
				maxR[i]=Math.max(maxR[i], a[i][j]);
				maxC[j]=Math.max(maxC[j], a[i][j]);
			}
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(maxR[i]==maxC[j] && a[i][j]!=0)
					adj[i].add(j);
		maxMatching();
		boolean [] done=new boolean [n];
		int [][] res=new int [n][m];
		for(int j=0;j<m;j++)
			if(match[j]!=-1){
				res[match[j]][j]=maxC[j];
				done[match[j]]=true;
			}
		for(int i=0;i<n;i++)
			if(!done[i]){
				for(int j=0;j<m;j++)
					if(a[i][j]!=0 && maxC[j]>=maxR[i]){
						res[i][j]=maxR[i];
						break;
					}
			}
		for(int j=0;j<m;j++)
			if(match[j]==-1){
				for(int i=0;i<n;i++)
					if(a[i][j]!=0 && maxR[i]>=maxC[j]){
						res[i][j]=maxC[j];
						break;
					}
			}
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(a[i][j]>0)
					res[i][j]=Math.max(res[i][j], 1);
		long ans=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				ans+=(a[i][j]-res[i][j]);
		pw.println(ans);
		pw.flush();
		pw.close();
	}
	
	static int n,m,vid;
	static int [] match;
	static ArrayList<Integer> [] adj;
	static int [] vis;
	
	static int maxMatching(){
		int ans=0;
		match=new int [m];
		vis=new int [n];
		Arrays.fill(match, -1);
		for(int i=0;i<n;i++){
			vid++;
			if(canMatch(i))
				ans++;
		}
		return ans;
	}
	
	static boolean canMatch(int u){
		vis[u]=vid;
		for(int v : adj[u])
			if(match[v]==-1 || (vis[match[v]]!=vid && canMatch(match[v]) )){
				match[v]=u;
				return true;
			}
		return false;
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
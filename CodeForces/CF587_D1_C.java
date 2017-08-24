package codeforces;
import java.io.*;
import java.util.*;
public class CF587_D1_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		int m=sc.nextInt();
		int q=sc.nextInt();
		adj=new ArrayList [n];
		minIDs=new ArrayList [n];
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<Integer>();
			minIDs[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<n-1;i++){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			adj[u].add(v);
			adj[v].add(u);
		}
		for(int i=0;i<m;i++)
			minIDs[sc.nextInt()-1].add(i+1);
		for(int i=0;i<n;i++)
			Collections.sort(minIDs[i]);
		if(n>1)
			preProcessing();
		ans=new ArrayList<Integer>();
		while(q-->0){
			ans.clear();
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			int a=sc.nextInt();
			if(n>1)
				query(u, v);
			else
				ans=merge(ans, minIDs[0]);
			pw.print(Math.min(a, ans.size())+" ");
			for(int i=0;i<Math.min(a, ans.size());i++)
				pw.print(ans.get(i)+" ");
			pw.println();
		}
		
		pw.flush();
		pw.close();
	}
	
	static int n;
	static int [][] ansector;
	static ArrayList<Integer> [][] mins;
	static int [] parent,level;
	static ArrayList<Integer> [] adj;
	static ArrayList<Integer> [] minIDs;
	static ArrayList<Integer> ans;
	
	static void preProcessing(){
		parent=new int [n];
		level=new int [n];
		parent[0]=-1;
		dfs(0, 0);
		int log=(int)Math.ceil(Math.log(n)/Math.log(2));
		ansector=new int [n][log];
		mins=new ArrayList [n][log];
		for(int i=0;i<n;i++)
			for(int j=0;j<log;j++)
				mins[i][j]=new ArrayList<Integer>();
		for(int [] x : ansector)
			Arrays.fill(x, -1);
		for(int i=0;i<n;i++){
			if(parent[i]==-1)
				mins[i][0]=minIDs[i];
			else
				mins[i][0]=merge(minIDs[i], minIDs[parent[i]]);
			ansector[i][0]=parent[i];				
		}
		for(int j=1;(1<<j)<n;j++)
			for(int i=0;i<n;i++)
				if(ansector[i][j-1]!=-1){
					mins[i][j]=merge(mins[i][j-1], mins[ansector[i][j-1]][j-1]);
					ansector[i][j]=ansector[ansector[i][j-1]][j-1];
				}
	}
	
	public static void dfs(int u,int h){
		level[u]=h;
		for(int v : adj[u])
			if(v!=parent[u]){
				parent[v]=u;
				dfs(v, h+1);
			}
	}
	
	public static void query(int u,int v){
		if(level[u]<level[v]){
			int tmp=u;
			u=v;
			v=tmp;
		}
		int log=1;
		for(log=1;(1<<log)<=level[u];log++);
		log--;
		
		for(int i=log;i>=0;i--)
			if(level[u]-(1<<i)>=level[v]){
				ans=merge(ans, mins[u][i]);
				u=ansector[u][i];
			}
		
		if(u==v){
			ans=merge(ans, minIDs[u]);
			ans=merge(ans, minIDs[v]);
			return;
		}
		
		for(int i=log;i>=0;i--)
			if(ansector[u][i]!=-1 && ansector[u][i]!=ansector[v][i]){
				ans=merge(ans, mins[u][i]);
				ans=merge(ans, mins[v][i]);
				u=ansector[u][i];
				v=ansector[v][i];
			}
		ans=merge(ans, mins[u][0]);
		ans=merge(ans, mins[v][0]);
	}
	
	static ArrayList<Integer> merge(ArrayList<Integer> a,ArrayList<Integer> b){
		ArrayList<Integer> ret=new ArrayList<Integer>();
		int i=0,j=0,c=0;
		while(c<10 && (i<a.size()) || j<b.size()){
			while(i<a.size() && j<b.size() && a.get(i)==b.get(j))
				i++;
			if(i<a.size() && j<b.size()){
				if(a.get(i)<b.get(j))
					ret.add(a.get(i++));
				else
					ret.add(b.get(j++));
			}else
				if(i<a.size())
					ret.add(a.get(i++));
				else
					ret.add(b.get(j++));
			c++;
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
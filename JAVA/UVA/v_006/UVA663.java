package v_006;
import java.io.*;
import java.util.*;
public class UVA663 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		while(true){
			n=m=sc.nextInt();
			if(n==0)
				break;
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			int [] x1=new int [n];
			int [] y1=new int [n];
			int [] x2=new int [n];
			int [] y2=new int [n];
			for(int i=0;i<n;i++){
				x1[i]=sc.nextInt();
				x2[i]=sc.nextInt();
				y1[i]=sc.nextInt();
				y2[i]=sc.nextInt();
			}
			int [] x=new int [n];
			int [] y=new int [n];
			for(int i=0;i<n;i++){
				x[i]=sc.nextInt();
				y[i]=sc.nextInt();
				for(int j=0;j<n;j++){
					if(x[i]>x1[j] && x[i]<x2[j] && y[i]>y1[j] && y[i]<y2[j]){
						adj[i].add(j);
					}
				}
			}
			maxMatching();
			adj2=new ArrayList [2*n];
			for(int i=0;i<2*n;i++)
				adj2[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				for(int j : adj[i])
					if(match[j]==i)
						adj2[i].add(j+n);
					else
						adj2[j+n].add(i);
			matchRev=new int [n];
			for(int i=0;i<m;i++)
				matchRev[match[i]]=i;
			ArrayList<pair> ans=new ArrayList<pair>();
			vis=new int [2*n];
			Arrays.fill(vis, -1);
			for(int i=0;i<n;i++){
				cur=i;
				ok=true;
				dfs(i);
				if(ok)
					ans.add(new pair(i+1, (char)(matchRev[i]+'A')));
			}
			Collections.sort(ans);
			pw.println("Heap "+(id++));
			if(ans.size()==0)
				pw.print("none");
			boolean f=true;
			for(pair s : ans){
				if(!f)
					pw.print(" ");
				pw.print(s);
				f=false;
			}
			pw.println();
			pw.println();
		}
		
		pw.flush();
		pw.close();
	}
	static boolean ok;
	static int cur;
	static ArrayList<Integer> [] adj2;
	static void dfs(int u){
		vis[u]=cur;
		for(int v : adj2[u])
			if(vis[v]!=cur){
				dfs(v);
			}else
				if(v==cur)
					ok=false;
	}
	
	static class pair implements Comparable<pair>{
		int x;
		char c;
		pair(int x,char c){
			this.x=x;
			this.c=c;
		}
		public int compareTo(pair o) {
			return c-o.c;
		}
		public String toString(){
			return "("+c+","+x+")";
		}
	}
	
	static int n,m,vid;
	static int [] match,matchRev;
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

import java.io.*;
import java.util.*;
public class BOTTOM {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			n=sc.nextInt();
			if(n==0)
				break;
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			int m=sc.nextInt();
			int [] x=new int [m];
			int [] y=new int [m];
			for(int i=0;i<m;i++){
				x[i]=sc.nextInt()-1;
				y[i]=sc.nextInt()-1;
				adj[x[i]].add(y[i]);
			}
			SCC();
			compDeg=new int [cntSCC];
			for(int i=0;i<m;i++){
				int c1=comp[x[i]];
				int c2=comp[y[i]];
				if(c1!=c2)
					compDeg[c1]++;
			}
			ArrayList<Integer> ans=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				if(compDeg[comp[i]]==0)
					ans.add(i+1);
			boolean f=true;
			for(int i : ans){
				if(!f)
					pw.print(" ");
				f=false;
				pw.print(i);
			}
			pw.println();
		}
		
		pw.flush();
		pw.close();
	}
	static int n,cntSCC;
	static ArrayList<Integer> [] adj;
	static Stack<Integer> stack;
	static int time;
	static int [] dfs_num,dfs_low,comp,compDeg;
	static boolean [] inSCC;
	
	public static void SCC(){
		stack=new Stack<Integer>();
		dfs_num=new int [n];
		dfs_low=new int [n];
		comp=new int [n];
		inSCC=new boolean [n];
		for(int i=0;i<n;i++)
			if(dfs_num[i]==0)
				SCC(i);
	}
	
	public static void SCC(int u){
		dfs_num[u]=dfs_low[u]=++time;
		stack.push(u);
		
		for(int v : adj[u]){
			if(dfs_num[v]==0)
				SCC(v);
			if(!inSCC[v])
				dfs_low[u]=Math.min(dfs_low[u], dfs_low[v]);
		}
		
		if(dfs_low[u]==dfs_num[u]){
			while(true){
				int x=stack.pop();
				inSCC[x]=true;
				comp[x]=cntSCC;
				if(x==u)
					break;
			}
			cntSCC++;
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
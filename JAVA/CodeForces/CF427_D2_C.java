package codeforces;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class CF427_D2_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		int [] cst=new int [n];
		for(int i=0;i<n;i++)
			cst[i]=sc.nextInt();
		adj=new ArrayList [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		int m=sc.nextInt();
		while(m-->0){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			adj[u].add(v);
		}
		SCC();
		TreeMap<Integer, Integer> min=new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> cnt=new TreeMap<Integer, Integer>();
		
		for(int i=0;i<n;i++){
			int com=comp[i];
			if(!min.containsKey(com) || cst[i]<min.get(com)){
				min.put(com, cst[i]);
				cnt.put(com, 1);
			}else
				if(cst[i]==min.get(com))
					cnt.put(com, cnt.get(com)+1);
		}
		long ans=0;
		long ways=1;
		int mod=(int)(1e9+7);
		for(Entry<Integer, Integer> e : min.entrySet()){
			ans+=e.getValue();
			ways=(ways*cnt.pollFirstEntry().getValue())%mod;
		}
		
		pw.println(ans+" "+ways);
		pw.flush();
		pw.close();
	}
	static int [] comp;
	static Stack<Integer> stack;
	static int n,cntSCC;
	static int time;
	static ArrayList<Integer> [] adj;
	static int [] dfs_num,dfs_low;
	static boolean [] inSCC;
	
	public static void SCC(){
		comp=new int [n];
		stack=new Stack<Integer>();
		inSCC=new boolean [n];
		dfs_low=new int [n];
		dfs_num=new int [n];
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
			cntSCC++;
			while(true){
				int x=stack.pop();
				comp[x]=cntSCC;
				inSCC[x]=true;
				if(x==u)
					break;
			}
		}
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
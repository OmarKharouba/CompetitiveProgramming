package v_108;

import java.io.*;
import java.util.*;
public class UVA10806 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			n=sc.nextInt();
			if(n==0)
				break;
			n+=2;
			m=sc.nextInt();
			init();
			addAugEdge(0, 1, 0, 2);
			addAugEdge(n-2, n-1, 0, 2);
			while(m-->0){
				int u=sc.nextInt();
				int v=sc.nextInt();
				int c=sc.nextInt();
				addAugEdge(u, v, c, 1);
				addAugEdge(v, u, c, 1);
			}
			pair p=minCostMaxFlow(0, n-1);
			if(p.f==2)
				pw.println(p.c);
			else
				pw.println("Back to jail");
		}
		
		pw.flush();
		pw.close();
	}
	
	static int n,m;
	
	static int inf=(int)(1e9);
	static int p,vid;
	static int [] head,next,from,to,cost,cap;
	static int [] dist,flow,par,vis;
	
	static void init(){
		p=vid=0;
		head=new int [n];
		Arrays.fill(head, -1);
		next=new int [4*m+5];
		from=new int [4*m+5];
		to=new int [4*m+5];
		cost=new int [4*m+5];
		cap=new int [4*m+5];
		dist=new int [n];
		flow=new int [n];
		par=new int [n];
		vis=new int [n];
	}
	
	static void addEdge(int f,int t,int cst,int cp){
		next[p]=head[f];
		from[p]=f;
		to[p]=t;
		cost[p]=cst;
		cap[p]=cp;
		head[f]=p++;
	}
	
	static void addAugEdge(int a,int b,int cst,int cp){
		addEdge(a, b, cst, cp);
		addEdge(b, a, -cst, 0);
	}
	
	static boolean bellman(int src){
		Arrays.fill(dist, inf);
		Arrays.fill(flow, 0);
		dist[src]=0;
		flow[src]=inf;
		vid++;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(src);
		vis[src]=vid;
		while(!q.isEmpty()){
			int f=q.poll();
			vis[f]=0;
			for(int k=head[f]; k!=-1; k=next[k]){
				int t=to[k];
				int c=cost[k];
				int d=dist[f]+c;
				if(cap[k]!=0 && dist[t]>d){
					dist[t]=d;
					flow[t]=Math.min(flow[f], cap[k]);
					par[t]=k;
					if(vis[t]!=vid){
						vis[t]=vid;
						q.add(t);
					}
				}
			}
		}
		
		return true;
	}
	
	static pair minCostMaxFlow(int src,int snk){
		int c=0,f=0;
		while(true){
			bellman(src);
			if(flow[snk]==0)
				break;
			f+=flow[snk];
			c+=dist[snk]*flow[snk];
			for(int i=snk;i!=src;i=from[par[i]]){
				int k=par[i];
				cap[k]-=flow[snk];
				cap[k^1]+=flow[snk];
			}
		}
		return new pair(f,c);
	}
	
	static class pair{
		int f,c;
		pair(int f,int c){
			this.f=f;
			this.c=c;
		}
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("boring.in")));
			} catch (FileNotFoundException e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
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
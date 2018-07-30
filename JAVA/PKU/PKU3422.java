package PKU;

import java.io.*;
import java.util.*;
public class PKU3422 {
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out, true);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		int [][] a=new int [n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		N=2*n*n+1;
		M=2*((n*n)*4);
		init();
		int src=N-1;
		addAugEdge(src, 0, 0, k);
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				if(i<n-1)
					addAugEdge(i*n+j+n*n, (i+1)*n+j, 0, k);
				if(j<n-1)
					addAugEdge(i*n+j+n*n, i*n+j+1, 0, k);
				addAugEdge(i*n+j, i*n+j+n*n, 0, k);
				addAugEdge(i*n+j, i*n+j+n*n, -a[i][j], 1);
			}
		pair p=minCostMaxFlow(src, N-2);
		pw.println(-p.c);
		
		pw.flush();
		pw.close();
	}

	static int N,M;
	static int inf=(int)(1e9);
	static int p,vid;
	static int [] head,next,from,to,cap,cost,dist;
	static int [] flow,par,vis;
	
	static void init(){
		p=vid=0;
		head=new int [N];
		Arrays.fill(head, -1);
		next=new int [M];
		from=new int [M];
		to=new int [M];
		cost=new int [M];
		cap=new int [M];
		dist=new int [N];
		flow=new int [N];
		par=new int [N];
		vis=new int [N];
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
	
	static void bellman(int src){
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
	}
	
	static pair minCostMaxFlow(int src,int snk){
		int c=0;
		int f=0;
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
		int f;
		int c;
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
				br = new BufferedReader(new FileReader(new File("test.in")));
			} catch (Exception e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
}
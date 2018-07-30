package LiveArchive;
import java.io.*;
import java.util.*;

public class LA_3562 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		while(true){
			int n=sc.nextInt();
			int m=sc.nextInt();
			if(n==0 && m==0)
				break;
			N=n+m+2;
			M=2*(n*m+n+m);
			init();
			int [] c1=new int [n];
			int [] c2=new int [m];
			for(int i=0;i<n;i++)
				c1[i]=sc.nextInt();
			for(int i=0;i<m;i++)
				c2[i]=sc.nextInt();
			int [][] cst=new int [n][m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++){
					double c=sc.nextDouble();
					if(c!=-1)
						cst[i][j]=(int)Math.round(c*100);
					else
						cst[i][j]=-1;
				}
			for(int i=0;i<n;i++){
				addAugEdge(0, i+1, 0, c1[i]);
				for(int j=0;j<m;j++)
					if(cst[i][j]!=-1)
						addAugEdge(i+1, n+1+j, cst[i][j], c1[i]);
			}
			for(int j=0;j<m;j++)
				addAugEdge(n+1+j, N-1, 0, c2[j]);
			double min=minCostMaxFlow(0, N-1).c;
			init();
			for(int i=0;i<n;i++){
				addAugEdge(0, i+1, 0, c1[i]);
				for(int j=0;j<m;j++)
					if(cst[i][j]!=-1)
						addAugEdge(i+1, n+1+j,(int) -cst[i][j], c1[i]);
			}
			for(int j=0;j<m;j++)
				addAugEdge(n+1+j, N-1, 0, c2[j]);
			double max=-minCostMaxFlow(0, N-1).c;
			pw.printf("Problem %d: %.2f to %.2f\n",(id++),min/100.0,max/100.0);
		}
		
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
		double c=0;
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
		double c;
		pair(int f,double c){
			this.f=f;
			this.c=c;
		}
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	    	  try {
	    		  br=new BufferedReader(new FileReader(new File("test.in")));
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
	 
	      String nextLine(){
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

package v_003;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class UVA318 {
	
	static final int INF = (int)1e9;
	static ArrayList<Edge>[] adjList;
	static int V;
	static int[] dist;
	
	static class Edge implements Comparable<Edge>
	{
		int node, cost;
		
		Edge(int a, int b) { node = a;	cost = b; }
		
		public int compareTo(Edge e){ return cost - e.cost;	}
	}
	
	
	static int dijkstra(int S)
	{
		dist = new int[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[S] = 0;
		pq.add(new Edge(S, 0));
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(cur.cost > dist[cur.node])
				continue;
			for(Edge nxt: adjList[cur.node])
				if(cur.cost + nxt.cost < dist[nxt.node])
					pq.add(new Edge(nxt.node, dist[nxt.node] = cur.cost + nxt.cost ));
		}
		return -1;
	}
	
	public static void main(String[]args)throws NumberFormatException,IOException{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		DecimalFormat df=new DecimalFormat("#0.0");
		int id=1;
		while(true){
			V=sc.nextInt();
			int m=sc.nextInt();
			if(V==0 && m==0)
				break;
			
			adjList=new ArrayList[V];
			for(int i=0;i<V;i++)
				adjList[i]=new ArrayList<Edge>();
			
			while(m-->0){
				int u=sc.nextInt()-1,v=sc.nextInt()-1,c=sc.nextInt();
				adjList[u].add(new Edge(v, c));
				adjList[v].add(new Edge(u, c));
			}
			
			dijkstra(0);
			int type=1,x=1,y=1;
			double max=0;
			for(int i=0;i<V;i++){
				if(dist[i]>max){
					max=dist[i];
					type=1;
					x=i+1;
				}
				for(Edge nxt : adjList[i]){
					if(Math.abs(dist[i]-dist[nxt.node])<nxt.cost){
						double tmp=Math.max(dist[i], dist[nxt.node])+0.5*(nxt.cost-Math.abs(dist[i]-dist[nxt.node]));
						if(tmp>max){
							max=tmp;
							x=i+1;
							y=nxt.node+1;
							type=2;
						}
					}
				}
			}
			
			pw.println("System #"+id++);
			if(type==1){
				pw.println("The last domino falls after "+(df.format(max))+" seconds, at key domino "+x+".");
			}else{
				pw.println("The last domino falls after "+(df.format(max))+" seconds, between key dominoes "+x+" and "+y+".");
			}
			
			pw.println();
		}
		
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
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

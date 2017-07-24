package v_115;
import java.io.*;
import java.util.*;
	public class UVA11506 {
		public static void main(String[] args)throws Throwable {
			MyScanner sc=new MyScanner();
			PrintWriter pw=new PrintWriter(System.out,true);
			
			while(true){
				int n=sc.nextInt();
				if(n==0)
					break;
				int m=sc.nextInt();
				N=n*2;
				M=2*(m*2+n);
				init();
				addAugEdge(0, n, inf);
				addAugEdge(n-1, 2*n-1, inf);
				for(int i=0;i<n-2;i++){
					int id=sc.nextInt()-1;
					int c=sc.nextInt();
					addAugEdge(id, id+n, c);
				}
				while(m-->0){
					int u=sc.nextInt()-1;
					int v=sc.nextInt()-1;
					int c=sc.nextInt();
					addAugEdge(u+n, v, c);
					addAugEdge(v+n, u, c);
				}
				src=0;
				snk=N-1;
				pw.println(maxFlow());
			}
			
			pw.flush();
			pw.close();
		}
		static int inf=(int)1e9;
		static int N,M,p;
		static int src,snk,vid;
		static int [] vis;
		static int[] head, nxt, to, cap;
		
		static void init(){
			p=0;
			vis=new int [N];
			head=new int [N];
			nxt=new int [M];
			to=new int [M];
			cap=new int [M];
			Arrays.fill(head, -1);
		}
		
		static void addEdge(int f,int t,int c){
			nxt[p]=head[f];
			to[p]=t;
			cap[p]=c;
			head[f]=p++;
		}
		
		static void addAugEdge(int a,int b,int c){
			addEdge(a, b, c);
			addEdge(b, a, 0);
		}
		
		static int dfs(int i,int flow){
			if(i==snk)
				return flow;
			if(flow==0)
				return 0;
			if(vis[i]==vid)
				return 0;
			vis[i]=vid;
			for (int k = head[i]; k!=-1; k = nxt[k]) {
		        int j = to[k];
		        int c = cap[k];
		        int f = dfs(j, Math.min(flow, c));
		        if (f>0) {
		            cap[k]-=f;
		            cap[k^1]+=f;
		            return f;
		        }
		    }
		    return 0;
		}
		
		static int maxFlow() {
		    if (src == snk)
		        return inf;
		    int flow = 0, f=0;
		    vid++;
		    while(true){
		    	f=dfs(src, inf);
		    	if(f==0)
		    		break;
		    	flow+=f;
		    	vid++;
		    }
		    return flow;
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
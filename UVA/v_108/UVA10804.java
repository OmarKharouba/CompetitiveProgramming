package v_108;
import java.io.*;
import java.util.*;
	public class UVA10804 {
		public static void main(String[] args)throws Throwable {
			MyScanner sc=new MyScanner();
			PrintWriter pw=new PrintWriter(System.out,true);
			
			int t=sc.nextInt();
			int tc=1;
			while(t-->0){
				int n=sc.nextInt();
				int m=sc.nextInt();
				int k=sc.nextInt();
				N=n+m+2;
				M=2*(n+m+n*m);
				init();
				double [] x1=new double [n];
				double [] y1=new double [n];
				double [] x2=new double [m];
				double [] y2=new double [m];
				for(int i=0;i<n;i++){
					x1[i]=sc.nextDouble();
					y1[i]=sc.nextDouble();
				}
				for(int i=0;i<m;i++){
					x2[i]=sc.nextDouble();
					y2[i]=sc.nextDouble();
				}
				double start=0,end=1e18,ans=-1;
				for(int id=0;id<200;id++){
					double s=((start+end)/2);
					init();
					for(int i=0;i<m;i++){
						for(int j=0;j<n;j++){
							double d=Math.sqrt((x2[i]-x1[j])*(x2[i]-x1[j])+(y2[i]-y1[j])*(y2[i]-y1[j]));
							if(d<=s){
								addAugEdge(j+1, n+1+i, 1);
							}
						}
					}
					for(int i=1;i<=n;i++)
						addAugEdge(0, i, 1);
					for(int i=0;i<m;i++)
						addAugEdge(n+1+i, N-1, 1);
					src=0;
					snk=N-1;
					int flow=maxFlow();
					if(flow+k>=n){
						ans=s;
						end=s;
					}else
						start=s;
				}
				pw.printf("Case #%d:\n",(tc++));
				if(ans!=-1)
					pw.printf("%.3f\n",ans);
				else
					pw.println("Too bad.");
				pw.println();
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
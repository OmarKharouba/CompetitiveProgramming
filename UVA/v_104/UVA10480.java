package v_104;
import java.io.*;
import java.util.*;
	public class UVA10480 {
		public static void main(String[] args)throws Throwable {
			MyScanner sc=new MyScanner();
			PrintWriter pw=new PrintWriter(System.out,true);
			src=0;
			snk=1;
			while(true){
				N=sc.nextInt();
				if(N==0)
					break;
				int m=sc.nextInt();
				M=m*4;
				init();
				while(m-->0){
					int u=sc.nextInt()-1;
					int v=sc.nextInt()-1;
					int c=sc.nextInt();
					addAugEdge(u, v, c);
					addAugEdge(v, u, c);
				}
				maxFlow();
				source=new boolean [M];
				dfs(0);
				TreeSet<String> set=new TreeSet<String>();
				for(int i=0;i<N;i++)
					if(source[i])
						for(int k=head[i];k!=-1;k=nxt[k])
							if(cap[k]==0 && !source[to[k]]){
								int x=Math.min(i+1, to[k]+1);
								int y=Math.max(i+1, to[k]+1);
								set.add(x+" "+y);
							}
				for(String s : set)
					pw.println(s);
				pw.println();
			}
			
			pw.flush();
			pw.close();
		}
		static boolean [] source;
		
		static void dfs(int u){
			source[u]=true;
			for(int k=head[u];k!=-1;k=nxt[k])
				if(cap[k]>0){
					int ch=to[k];
					if(!source[ch])
						dfs(ch);
				}
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
package v_002;
import java.io.*;
import java.util.*;
	public class UVA259 {
		public static void main(String[] args)throws Throwable {
			MyScanner sc=new MyScanner();
			PrintWriter pw=new PrintWriter(System.out,true);
			N=38;
			M=6000;
			src=0;
			snk=37;
			while(sc.br.ready()){
				init();
				for(int i=27;i<37;i++)
					addAugEdge(i, 37, 1);
				int sum=0;
				while(sc.br.ready()){
					String s=sc.nextLine();
					if(s.length()==0)
						break;
					s=s.substring(0, s.length()-1);
					String [] sa=s.split(" ");
					int c=sa[0].charAt(0)-'A'+1;
					int cap=sa[0].charAt(1)-'0';
					sum+=cap;
					addAugEdge(0, c, cap);
					for(char ch : sa[1].toCharArray())
						addAugEdge(c, ch-'0'+27, 1);
				}
				int flow=maxFlow();
				if(flow!=sum)
					pw.println("!");
				else{
					char [] ans=new char [10];
					Arrays.fill(ans, '_');
					for(int i=1;i<=26;i++){
						for(int k=head[i];k!=-1;k=nxt[k]){
							if(cap[k]==0)
								ans[to[k]-27]=(char)('A'+i-1);
						}
					}
					pw.println(new String(ans));
				}
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
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class DIVREL {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		int [] a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
//		n=31;
//		a=new int [n];
//		int c=1;
//		for(int i=0;i<n;i++){
//			a[i]=c;
//			c*=2;
//		}
//		
//		
		N=n*2+2;
		M=2*N*N;
		init();
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if(a[i]%a[j]==0 || a[j]%a[i]==0){
					addAugEdge(i+1, n+1+j, 1);
				}
		for(int i=1;i<=n;i++)
			addAugEdge(0, i, 1);
		snk=N-1;
		for(int i=n+1;i<=2*n;i++)
			addAugEdge(i, snk, 1);
		
		pw.println(n-maxFlow());
		source=new boolean [N];
		dfs(0);
		boolean [] v=new boolean [n];
		for(int i=1;i<=n;i++){
			for(int k=head[i];k!=-1;k=nxt[k]){
				if(to[k]>0 && cap[k]==0){
					if(!source[i])
						v[i-1]=true;
					if(source[to[k]])
						v[to[k]-1-n]=true;
				}
			}
		}
		TreeSet<Integer> maxSet=new TreeSet<Integer>();
		for(int i=0;i<n;i++)
			if(!v[i])
				maxSet.add(a[i]);
		for(int i : maxSet)
			pw.print(i+" ");
		pw.flush();
		pw.close();
	}
	static int n;
	static int inf=(int)1e9;
	static int N,M,p;
	static int src,snk,vid;
	static int [] vis;
	static int[] head, nxt, to, cap;
	
	static boolean [] source;
	
	static void dfs(int u){
		source[u]=true;
		for(int k=head[u];k!=-1;k=nxt[k])
			if(!source[to[k]] && cap[k]>0)
				dfs(to[k]);
	}
	
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

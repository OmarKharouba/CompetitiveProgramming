package PKU;
import java.io.*;
import java.util.*;
public class PKU2763 {
	
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		n=sc.nextInt();
		int q=sc.nextInt();
		int last=sc.nextInt()-1;
		init();
		for(int i=0;i<n-1;i++){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			int c=sc.nextInt();
			adj[u].add(v);
			adj[v].add(u);
			edge_idx[u].add(i);
			edge_idx[v].add(i);
			edge_cost[i]=c;
		}
		hld();
		for(int i=0;i<n-1;i++)
			updatePos(edge_to[i], edge_cost[i]);
		while(q-->0){
			int x=sc.nextInt();
			if(x==0){
				int u=sc.nextInt()-1;
				pw.println(queryPath(last, u));
				last=u;
			}else{
				int y=sc.nextInt()-1;
				int c=sc.nextInt();
				updatePos(edge_to[y], c);
			}
		}
		pw.flush();
		pw.close();
	}
	
	static int n,N;
	static int [] st;
	static int [] a;
	static int [] parent,depth,heavy,root,segTreePos,edge_to,edge_cost;
	static int valueOnEdge=1;
	static ArrayList<Integer> [] adj,edge_idx;
	
	static void init(){
		edge_idx=new ArrayList [n];
		adj=new ArrayList [n];
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<Integer>();
			edge_idx[i]=new ArrayList<Integer>();
		}
		parent=new int [n];
		depth=new int [n];
		heavy=new int [n];
		root=new int [n];
		segTreePos=new int [n];
		edge_to=new int [n-1];
		edge_cost=new int [n-1];
	}
	
	static int dfs(int u){
		int size=1,maxSubTree=0;
		for(int i=0;i<adj[u].size();i++){
			int v=adj[u].get(i);
			int idx=edge_idx[u].get(i);
			if(v!=parent[u]){
				parent[v]=u;
				edge_to[idx]=v;
				depth[v]=depth[u]+1;
				int subSize=dfs(v);
				if(subSize>maxSubTree){
					maxSubTree=subSize;
					heavy[u]=v;
				}
				size+=subSize;
			}
		}
		return size;
	}
	
	static void hld(){
		Arrays.fill(heavy, -1);
		parent[0]=-1;
		dfs(0);
		for(int i=0,pos=0;i<n;i++){
			if(parent[i]==-1 || heavy[parent[i]]!=i){
				for(int j=i;j!=-1;j=heavy[j]){
					root[j]=i;
					segTreePos[j]=pos++;
				}
			}
		}
		N=1;
		while(N<n) N<<=1;
		st=new int [N<<1];
	}
	
	static int queryPath(int u,int v){
		int ret=0;
		while(root[u]!=root[v]){
			if(depth[root[v]]>depth[root[u]]){
				ret+=query(segTreePos[root[v]], segTreePos[v]);
				v=parent[root[v]];
			}else{
				ret+=query(segTreePos[root[u]], segTreePos[u]);
				u=parent[root[u]];
			}
		}
		if(valueOnEdge==0 || u!=v){			
			if(depth[u]<depth[v])
				ret+=query(segTreePos[u]+valueOnEdge, segTreePos[v]);
			else
				ret+=query(segTreePos[v]+valueOnEdge, segTreePos[u]);
		}
		return ret;
	}
	
	static void updatePos(int node,int val){
		int idx=segTreePos[node];
		update_point(idx, val);
	}
	
	static void update_point(int idx,int val){
		idx+=N-1;
		st[idx]=val;
		while(idx>1){
			idx/=2;
			st[idx]=st[2*idx]+st[2*idx+1];
		}
	}
	
	static int query(int i,int j){
		return query(1,N,1,i,j);
	}
	
	static int query(int s,int e,int p,int i,int j){
		if(j<s || i>e)
			return 0;
		if(s>=i && e<=j)
			return st[p];
		int q1=query(s, (s+e)/2, 2*p, i, j);
		int q2=query((s+e)/2+1, e, 2*p+1, i, j);
		return q1+q2;
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

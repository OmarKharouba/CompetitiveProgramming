package v_017;
import java.io.*;
import java.util.*;
public class UVA1728 {
	
	static class pair implements Comparable<pair>{
		int val,last;
		
		pair(int v,int l){
			val=v;
			last=l;
		}
		
		public int compareTo(pair o) {
			return val-o.val;
		}
	}
	
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		int t=sc.nextInt();
		while(t-->0){
			n=sc.nextInt();
			int m=sc.nextInt();
			adj=new ArrayList [n];
			values=new ArrayList [n];
			for(int i=0;i<n;i++){
				adj[i]=new ArrayList<Integer>();
				values[i]=new ArrayList<pair>();
			}
			int [] x=new int [m];
			int [] y=new int [m];
			int [] z=new int [m];
			for(int i=0;i<m;i++){
				x[i]=sc.nextInt()-1;
				y[i]=sc.nextInt()-1;
				z[i]=sc.nextInt();
				if(i<n-1){
					adj[x[i]].add(y[i]);
					adj[y[i]].add(x[i]);
				}
			}
			p=new int [n];
			level=new int [n];
			level[0]=0;
			p[0]=-1;
			dfs(0);
			c=new int [n];
			for(int i=0;i<n-1;i++)
				if(level[x[i]]>level[y[i]])
					c[x[i]]=z[i];
				else
					c[y[i]]=z[i];
			
			int log=(int)(Math.ceil(Math.log(n)/Math.log(2)));
			ansector=new int [n][log];
			max=new int [n][log];
//			for(int [] an : ansector)
//				Arrays.fill(an, -1);
			for(int i=0;i<n;i++){
				ansector[i][0]=p[i];
				max[i][0]=c[i];
			}
			for(int j=1;j<log;j++)
				for(int i=0;i<n;i++)
					if(ansector[i][j-1]!=-1){
						ansector[i][j]=ansector[ansector[i][j-1]][j-1];
						max[i][j]=Math.max(max[i][j-1], max[ansector[i][j-1]][j-1]);
					}
			long ans=0;
			for(int i=n-1;i<m;i++){
				pair LCA=query(x[i], y[i]);
				pair p=new pair(z[i], LCA.last);
				values[x[i]].add(p);
				values[y[i]].add(p);
				ans+=-(i+1)+1L*(i+1)*(i+1)*(z[i]-LCA.val);
			}
			min=new int [n];
			Arrays.fill(min, 2000);
			go(0);
			for(int i=0;i<n-1;i++){
				int minV=min[x[i]];
				if(level[y[i]]>level[x[i]])
					minV=min[y[i]];
				ans+=-1L*(i+1)*(i+1)+1L*(i+1)*(minV<2000? minV-z[i] : -1);
			}
			pw.println("Case "+(id++)+": "+ans);
		}
		
		pw.flush();
		pw.close();
	}
	static ArrayList<pair> [] values;
	static ArrayList<Integer> [] adj;
	static int n;
	static int [] level,p,c,min;
	static int [][] ansector,max;
	
	public static PriorityQueue<pair> go(int u){
		PriorityQueue<pair> ret=new PriorityQueue<pair>();
		for(int v : adj[u])
			if(v!=p[u])
				ret.addAll(go(v));
		ret.addAll(values[u]);
		while(!ret.isEmpty() && level[ret.peek().last]>=level[u])
			ret.poll();
		if(!ret.isEmpty())
			min[u]=ret.peek().val;
		return ret;
	}
	public static void dfs(int u){
		for(int v : adj[u])
			if(v!=p[u]){
				p[v]=u;
				level[v]=level[u]+1;
				dfs(v);
			}
	}
	
	public static pair query(int u,int v){
		if(level[u]<level[v]){
			int tmp=u;
			u=v;
			v=tmp;
		}
		int ret=0;
		int log=1;
		for(log=1;(1<<log)<=level[u];log++);
		log--;
		
		for(int i=log;i>=0;i--)
			if(level[u]-(1<<i)>=level[v]){
				ret=Math.max(ret, max[u][i]);
				u=ansector[u][i];
			}
		if(u==v)
			return new pair(ret,u);
		
		for(int i=log;i>=0;i--)
			if(ansector[u][i]!=-1 && ansector[u][i]!=ansector[v][i]){
				u=ansector[u][i];
				v=ansector[v][i];
				ret=Math.max(ret, max[u][i]);
				ret=Math.max(ret, max[v][i]);
			}
		ret=Math.max(ret, Math.max(c[u], c[v]));
		return new pair(ret, p[u]);
	}
	
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("alost.in")));
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
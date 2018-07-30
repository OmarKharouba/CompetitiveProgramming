import java.io.*;
import java.util.*;
public class FOXLINGS {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>();
		int [] x=new int [m];
		int [] y=new int [m];
		int cnt=0;
		for(int i=0;i<m;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			x[i]=u;
			y[i]=v;
			if(!map.containsKey(u))
				map.put(u, cnt++);
			if(!map.containsKey(v))
				map.put(v, cnt++);
		}
		DSU d=new DSU(cnt);
		for(int i=0;i<m;i++){
			d.union(map.get(x[i]), map.get(y[i]));
		}
		pw.println(d.cntSets+n-cnt);
		pw.flush();
		pw.close();
	}
	
	static class DSU {
		int n,cntSets;
		int [] rank,parent,setSize;
		
		public DSU(int n) {
			cntSets=n;
			this.n=n;
			rank=new int [n];
			parent=new int [n];
			setSize=new int [n];
			for(int i=0;i<n;i++){
				setSize[i]=1;
				parent[i]=i;
			}
		}
		
		public int findSet(int i){
			return parent[i]==i? i : (parent[i]=findSet(parent[i]));
		}
		
		public boolean union(int u,int v){
			int x=findSet(u);
			int y=findSet(v);
			if(x==y)
				return false;
			if(rank[x]<rank[y]){
				setSize[y]+=setSize[x];
				parent[x]=y;
			}else{
				setSize[x]+=setSize[y];
				if(rank[x]==rank[y])
					rank[x]++;
				parent[y]=x;
			}
			cntSets--;
			return true;
		}
		
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("car.in")));
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
package v_125;
import java.io.*;
import java.util.*;
public class UVA12533 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(sc.br.ready()){
			compC=0;
			n=sc.nextInt();
			deg=new int [n];
			next=new int [n];
			p=new int [n];
			add=new int [n];
			rev=new ArrayList [n];
			for(int i=0;i<n;i++)
				rev[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				int v=sc.nextInt()-1;
				next[i]=v;
				deg[v]++;
			}
			v=new boolean [n];
			for(int i=0;i<n;i++){
				p[i]=i;
				if(!v[i] && deg[i]==0)
					pre(i);
			}
			for(int i=0;i<n;i++){
				if(!v[i])
					reverse(i,0,i);
			}
			
			Arrays.fill(v, false);
			idx=new int [n];
			comp=new int [n];
			compSize=new int [n];
			for(int i=0;i<n;i++)
				if(!v[i] && p[i]==i){
					idxC=0;
					dfs(i);
					compC++;
				}
			
			int log=(int)Math.ceil(Math.log(n)/Math.log(2));
			ansector=new int [n][log];
			for(int [] x : ansector)
				Arrays.fill(x, -1);
			for(int i=0;i<n;i++)
				ansector[i][0]=next[i];				
			for(int j=1;(1<<j)<n;j++)
				for(int i=0;i<n;i++)
					if(ansector[i][j-1]!=-1)
						ansector[i][j]=ansector[ansector[i][j-1]][j-1];
			
			int q=sc.nextInt();
			while(q-->0){
				int u=sc.nextInt()-1;
				int v=sc.nextInt()-1;
				
				int pu=p[u],pv=p[v];
				if(comp[pu]!=comp[pv])
					pw.println(-1);
				else
					if(pu!=pv){
						int idx1=idx[pu],idx2=idx[pv];
						int size=compSize[comp[pu]];
						int ans=Math.min(Math.abs(idx1-idx2), size-Math.abs(idx1-idx2));
						pw.println(ans+add[u]+add[v]);
					}else{
						int LCA=query(u, v);
						pw.println(add[u]+add[v]-2*add[LCA]);
					}
				
			}
		}
		
		
		pw.flush();
		pw.close();
	}
	static ArrayList<Integer> [] rev;
	static int n,compC,idxC;
	static boolean [] v;
	static int [] p,deg,next,add,idx,comp,compSize;
	static int [][] ansector;
	
	public static void reverse(int u,int dis,int par){
		add[u]=dis;
		p[u]=par;
		for(int v : rev[u])
			reverse(v, dis+1, par);
	}
	
	public static void pre(int u){
		v[u]=true;
		rev[next[u]].add(u);
		deg[next[u]]--;
		if(deg[next[u]]==0)
			pre(next[u]);
	}
	
	public static void dfs(int u){
		v[u]=true;
		idx[u]=idxC++;
		compSize[compC]++;
		comp[u]=compC;
		if(!v[next[u]])
			dfs(next[u]);
	}
	
	public static int query(int u,int v){
		if(add[u]<add[v]){
			int tmp=u;
			u=v;
			v=tmp;
		}
		int log=1;
		for(log=1;(1<<log)<=add[u];log++);
		log--;
		
		for(int i=log;i>=0;i--)
			if(add[u]-(1<<i)>=add[v])
				u=ansector[u][i];
		if(u==v)
			return u;
		
		for(int i=log;i>=0;i--)
			if(ansector[u][i]!=-1 && ansector[u][i]!=ansector[v][i]){
				u=ansector[u][i];
				v=ansector[v][i];
			}
		return next[u];
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

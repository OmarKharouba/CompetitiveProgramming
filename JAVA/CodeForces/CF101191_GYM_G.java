import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CF101191_GYM_G {
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		n=Integer.parseInt(br.readLine());
		adj=new ArrayList [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		for(int i=0;i<n-1;i++){
			String [] sa=br.readLine().split(" ");
			int u=Integer.parseInt(sa[0])-1;
			int v=Integer.parseInt(sa[1])-1;
			adj[u].add(v);
			adj[v].add(u);
		}
		paid=new long [n];
		free=new long [n];
		par=new int [n];
		cnt=new int [n];
		par[0]=-1;
		dfs(0);
//		System.out.println(Arrays.toString(paid));
//		System.out.println(Arrays.toString(free));
		dfs2(0);
//		System.out.println(Arrays.toString(paid));
//		System.out.println(Arrays.toString(free));
		
		long ans=0;
		for(long i : paid)
			ans+=i;
		
		pw.println(ans/2);
		pw.flush();
		pw.close();
	}
	static ArrayList<Integer> [] adj;
	static int [] par,cnt;
	static int n;
	static long [] paid,free;
	
	static void dfs2(int u){
		for(int v : adj[u])
			if(v!=par[u]){
				long parP=paid[u]-free[v]-cnt[v];
				long parF=free[u]-paid[v];
				int parC=n-cnt[v];
				paid[v]+=parF+parC;
				free[v]+=parP;
				dfs2(v);
			}
	}
	
	static void dfs(int u){
		int c=adj[u].size();
		if(u!=0)
			c--;
		for(int v : adj[u])
			if(v!=par[u]){
				par[v]=u;
				dfs(v);
				paid[u]+=free[v];
				free[u]+=paid[v];
				cnt[u]+=cnt[v];
			}
		if(c>0)
			paid[u]+=cnt[u];
		cnt[u]++;
	}
	
}
package TJU;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class TJU1077 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			n=sc.nextInt();
			if(n==0)
				break;
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				String s=sc.next();
				if(s.length()>2){
					String [] sa=s.split(":");
					int node=sa[0].charAt(0)-'A';
					for(char c : sa[1].toCharArray())
						adj[node].add(c-'A');
				}
			}
			String ans="4 channels needed.";
			boolean one=true;
			for(int i=0;i<n;i++)
				if(adj[i].size()>0)
					one=false;
			if(one)
				ans="1 channel needed.";
			else{	
				c=new int [n];
				Arrays.fill(c, -1);
				boolean two=true;
				for(int i=0;i<n;i++)
					if(c[i]==-1){						
						c[i]=0;
						two &=bipartite(i);
					}
				if(two)
					ans="2 channels needed.";
				else{
					boolean three=true;
					vis=new boolean [n];
					Arrays.fill(c, -1);
					active=new ArrayList<Integer>();
					for(int i=0;i<n;i++)
						if(!vis[i]){
							active.clear();
							dfs(i);
							found=false;
							tripartite(0);
							three &=found;
						}
					if(three)
						ans="3 channels needed.";
				}
			}
			pw.println(ans);
		}
		
		pw.flush();
		pw.close();
	}
	static int n;
	static ArrayList<Integer> [] adj;
	static int [] c;
	static boolean [] vis;
	static boolean found;
	static ArrayList<Integer> active;
	
	static void tripartite(int i){
		if(i==active.size()){
			found=true;
			return;
		}
		int u=active.get(i);
		loop :for(int color=0;color<3;color++){
			for(int v : adj[u])
				if(c[v]==color)
					continue loop;
			c[u]=color;
			tripartite(i+1);
			if(found)
				return;
			c[u]=-1;
		}
	}
	
	static void dfs(int u){
		active.add(u);
		vis[u]=true;
		for(int v : adj[u])
			if(!vis[v])
				dfs(v);
	}
	
	static boolean bipartite(int u){
		boolean ans=true;
		for(int v : adj[u]){	
			if(c[v]==c[u])
				return false;
			if(c[v]!=-1)
				continue;
			c[v]=1-c[u];
			ans &=bipartite(v);
		}
		return ans;
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

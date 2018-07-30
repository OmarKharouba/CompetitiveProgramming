package v_011;

import java.io.*;
import java.util.*;
public class UVA1148 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			n=sc.nextInt();
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				int u=sc.nextInt();
				int m=sc.nextInt();
				while(m-->0){
					int v=sc.nextInt();
					adj[u].add(v);
				}
			}
			v=new boolean [n];
			dis=new int [n];
			x=sc.nextInt();
			y=sc.nextInt();
			bfs();
			pw.println(x+" "+y+" "+dis[y]);
			if(t>0)
				pw.println();
		}
		
		
		pw.flush();
		pw.close();
	}
	static int [] dis;
	static int n,x,y;
	static ArrayList<Integer> [] adj;
	static boolean [] v;
	
	static void bfs(){
		Queue<Integer> q=new LinkedList<Integer>();
		v[x]=true;
		q.add(x);
		dis[x]=-1;
		while(!q.isEmpty()){
			int u=q.poll();
			for(int ch : adj[u])
				if(!v[ch]){
					dis[ch]=dis[u]+1;
					v[ch]=true;
					q.add(ch);
				}
		}
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("boring.in")));
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
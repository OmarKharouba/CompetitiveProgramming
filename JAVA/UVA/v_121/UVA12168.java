package v_121;
import java.io.*;
import java.util.*;
public class UVA12168 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			int c=sc.nextInt();
			int d=sc.nextInt();
			int v=sc.nextInt();
			n=m=v;
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			char [] ch=new char [v];
			int [] stay=new int [v];
			int [] leave=new int [v];
			for(int i=0;i<v;i++){
				String s=sc.next();
				stay[i]=Integer.parseInt(s.substring(1));
				leave[i]=Integer.parseInt(sc.next().substring(1));
				ch[i]=s.charAt(0);
				for(int j=0;j<i;j++){	
					if(ch[j]!=ch[i] && (stay[j]==leave[i] || stay[i]==leave[j])){
						if(ch[i]=='C')
							adj[i].add(j);
						else
							adj[j].add(i);
					}
				}
			}
			pw.println(v-maxMatching());
		}
		
		pw.flush();
		pw.close();
	}
	
	static int n,m,vid;
	static int [] match;
	static ArrayList<Integer> [] adj;
	static int [] vis;
	
	static int maxMatching(){
		int ans=0;
		match=new int [m];
		vis=new int [n];
		Arrays.fill(match, -1);
		for(int i=0;i<n;i++){
			vid++;
			if(canMatch(i))
				ans++;
		}
		return ans;
	}
	
	static boolean canMatch(int u){
		vis[u]=vid;
		for(int v : adj[u])
			if(match[v]==-1 || (vis[match[v]]!=vid && canMatch(match[v]) )){
				match[v]=u;
				return true;
			}
		return false;
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
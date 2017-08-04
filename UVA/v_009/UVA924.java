package v_009;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class UVA924 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(sc.br.ready()){
			n=sc.nextInt();
			adj=new ArrayList [n];
			for(int i=0;i<n;i++)
				adj[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				int c=sc.nextInt();
				while(c-->0){
					int v=sc.nextInt();
					adj[i].add(v);
				}
			}
			int t=sc.nextInt();
			while(t-->0){
				int src=sc.nextInt();
				// level --> count
				TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>();
				Queue<Integer> q=new LinkedList<Integer>();
				boolean [] v=new boolean [n];
				int [] level=new int [n];
				q.add(src);
				v[src]=true;
				while(!q.isEmpty()){
					int parent=q.poll();
					for(int child : adj[parent])
						if(!v[child]){
							level[child]=level[parent]+1;
							v[child]=true;
							if(map.containsKey(level[child]))
								map.put(level[child], map.get(level[child])+1);
							else
								map.put(level[child],1);
							q.add(child);
						}
				}
				int cnt=0;
				int ans=-1;
				for(Entry<Integer, Integer> e : map.entrySet()){
					if(e.getValue()>cnt){
						cnt=e.getValue();
						ans=e.getKey();
					}
				}
				if(cnt>0){
					pw.println(cnt+" "+ans);
				}else{
					pw.println(0);
				}
			}
		}
		
		
		pw.flush();
		pw.close();
	}
	
	static int n;
	static ArrayList<Integer> [] adj;
	
	
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
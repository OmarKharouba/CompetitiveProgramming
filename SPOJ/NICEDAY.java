import java.util.*;
import java.io.*;
public class NICEDAY {
	static int n;
	static int [] ft;
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		int t=sc.nextInt();
		while(t-->0){
			n=sc.nextInt();
			pair [] p=new pair[n];
			for(int i=0;i<n;i++)
				p[i]=new pair(sc.nextInt(), sc.nextInt(), sc.nextInt());
			Arrays.sort(p);
			ft=new int [n+1];
			Arrays.fill(ft, inf);
			int cnt=0;
			for(int i=0;i<n;i++){
				if(get(p[i].y)>=p[i].z)
					cnt++;
				update(p[i].y, p[i].z);
			}
			pw.print(cnt);
		}
		
		
		pw.flush();
		pw.close();
	}
	
	static class pair implements Comparable<pair>{
		int x,y,z;
		pair(int a,int b,int c){
			x=a;
			y=b;
			z=c;
		}
		public int compareTo(pair o) {
			return x-o.x;
		}
	}
	static int inf=(int)(1e9);
	static int get(int idx){
		int ans=inf;
		while(idx>0){
			ans=Math.min(ans, ft[idx]);
			idx-=(idx & -idx);
		}
		return ans;
	}
	static void update(int idx,int val){
		while(idx<=n){
			ft[idx]=Math.min(ft[idx], val);
			idx+=(idx & -idx);
		}
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
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

import java.util.*;
import java.io.*;
public class FENTREE {
	static int n;
	static long [] ft;
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		n=sc.nextInt();
		ft=new long [n+1];
		for(int i=0;i<n;i++)
			update(i+1,sc.nextInt());
		int q=sc.nextInt();
		while(q-->0){
			char c=sc.next().charAt(0);
			int a=sc.nextInt();
			int b=sc.nextInt();
			if(c=='q'){
				pw.println(query(a, b));
			}else{
				update(a, b);
			}
		}
		pw.flush();
		pw.close();
	}
	
	static void update(int idx,int val){
		while(idx<=n){
			ft[idx]+=val;
			idx+=(idx & -idx);			
		}
	}
	
	static long query(int a,int b){
		return query(b)-query(a-1);
	}
	
	static long query(int idx){
		long ans=0;
		while(idx>0){
			ans+=ft[idx];
			idx-=(idx & -idx);
		}
		return ans;
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

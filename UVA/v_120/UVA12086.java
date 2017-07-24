package v_120;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA12086 {
	static int N;
	static int [] st;
	static int [] a;
	
	public static void main(String[] args) throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			if(id>1)
				pw.println();
			pw.println("Case "+(id++)+":");
			N=1;
			while(N<n) N<<=1;
			a=new int [N+1];
			for(int i=1;i<=n;i++)
				a[i]=sc.nextInt();
			st=new int [N<<1];
			build(1,N,1);
			while(true){
				String c=sc.next();
				if(c.equals("END"))
					break;
				int x=sc.nextInt();
				int y=sc.nextInt();
				if(c.equals("S")){
					update_point(x, y);
				}else{
					pw.println(query(x, y));
				}
			}
		}
		pw.flush();
		pw.close();
	}
	
	static void build(){
		build(1,N,1);
	}
	
	static int build(int s,int e,int p){
		if(s==e)
			return st[p]=a[s];
		else{
			
			return st[p]=build(s, (s+e)/2, 2*p)+build((s+e)/2+1, e, 2*p+1);
		}
	}
	
	static void update_point(int idx,int val){
		idx+=N-1;
		st[idx]=val;
		while(idx>1){
			idx/=2;
			st[idx]=st[2*idx]+st[2*idx+1];
		}
	}
	
	static int query(int i,int j){
		return query(1,N,1,i,j);
	}
	
	static int query(int s,int e,int p,int i,int j){
		if(j<s || i>e)
			return 0;
		if(s>=i && e<=j)
			return st[p];
		int q1=query(s, (s+e)/2, 2*p, i, j);
		int q2=query((s+e)/2+1, e, 2*p+1, i, j);
		return q1+q2;
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

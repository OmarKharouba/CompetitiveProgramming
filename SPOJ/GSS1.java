import java.io.*;
import java.util.*;
public class GSS1 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		N=1;
		while(N<n) N<<=1;
		a=new int [N+1];
		for(int i=1;i<=n;i++)
			a[i]=sc.nextInt();
		sum=new int [N<<1];
		maxR=new int [N<<1];
		maxL=new int [N<<1];
		build();
		
		int m=sc.nextInt();
		while(m-->0){
			int x=sc.nextInt();
			int y=sc.nextInt();
			tri t=query(x, y);
			pw.println(Math.max(t.x, Math.max(t.y, t.z)));
		}
		
		pw.flush();
		pw.close();
	}
	static int N;
	static int [] a,sum,maxL,maxR;
	
	static void build(){
		build(1,N,1);
	}
	
	static void build(int s,int e,int p){
		if(s==e){
			sum[p]=a[s];
			maxR[p]=maxL[p]=a[s]>0? a[s] : 0;
		}
		else{
			build(s, (s+e)/2, 2*p);
			build((s+e)/2+1, e, 2*p+1);
			sum[p]=sum[2*p]+sum[2*p+1];
			maxR[p]=Math.max(maxR[2*p+1], sum[2*p+1]+maxR[2*p]);
			maxL[p]=Math.max(maxL[2*p], sum[2*p]+maxL[2*p+1]);
		}
	}
	
	static tri query(int i,int j){
		return query(1,N,1,i,j);
	}
	
	static tri query(int s,int e,int p,int i,int j){
		if(j<s || i>e)
			return new tri(0, 0, 0);
		if(s>=i && e<=j)
			return new tri(maxL[p], sum[p], maxR[p]);
		tri q1=query(s, (s+e)/2, 2*p, i, j);
		tri q2=query((s+e)/2+1, e, 2*p+1, i, j);
		tri t=new tri(0, 0, 0);
		t.y=q1.y+q2.y;
		t.z=Math.max(q2.z, q2.y+q1.z);
		t.x=Math.max(q1.x, q1.y+q2.x);
		return t;
	}
	
	static class tri{
		int x,y,z;
		tri(int a,int b,int c){
			x=a;
			y=b;
			z=c;
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

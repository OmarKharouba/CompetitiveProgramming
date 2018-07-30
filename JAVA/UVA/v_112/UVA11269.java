package v_112;
import java.io.*;
import java.util.*;
public class UVA11269 {
	static int n;
	static int [] a,b;
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int t=2;
		while(t-->0){
//		while(sc.br.ready()){
			int n=sc.nextInt();
			int [] b=new int [n];
			int [] c=new int [n];
			pair [] a=new pair [n];
			for(int i=0;i<n;i++)
				b[i]=sc.nextInt();
			for(int i=0;i<n;i++)
				a[i]=new pair(b[i], sc.nextInt());
			Arrays.sort(a);
			b[0]=a[0].x;
			c[0]=b[0]+a[0].y;
			for(int i=1;i<n;i++){
				b[i]=b[i-1]+a[i].x;
				c[i]=Math.max(c[i-1], b[i])+a[i].y;
			}
			pw.println(c[n-1]);
		}
		
		
		pw.flush();
		pw.close();
	}
	
	static class pair implements Comparable<pair>{
		int x,y;
		pair(int a,int b){
			x=a;
			y=b;
		}
		
		public int compareTo(pair o){
			int o1=x+o.y+Math.max(y, o.x);
			int o2=o.x+y+Math.max(o.y, x);;
			return o1-o2;
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

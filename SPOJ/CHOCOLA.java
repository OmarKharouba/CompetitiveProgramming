import java.util.*;
import java.io.*;
public class CHOCOLA {
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		int t=sc.nextInt();
		while(t-->0){
			int m=sc.nextInt()-1;
			int n=sc.nextInt()-1;
			PriorityQueue<Integer> x=new PriorityQueue<Integer>();
			PriorityQueue<Integer> y=new PriorityQueue<Integer>();
			for(int i=0;i<m;i++)
				x.add(-1*sc.nextInt());
			for(int i=0;i<n;i++)
				y.add(-1*sc.nextInt());
			int donex=1,doney=1;
			long ans=0;
			while(!x.isEmpty() || !y.isEmpty()){
				if(y.isEmpty()){
					ans+=-1*x.poll()*doney;
					donex++;
				}else
					if(x.isEmpty()){
						ans+=-1*y.poll()*donex;
						doney++;
					}else{
						if(x.peek()<y.peek()){
							ans+=-1*x.poll()*doney;
							donex++;
						}else{
							ans+=-1*y.poll()*donex;
							doney++;
						}
					}
			}
			pw.println(ans);
		}
		pw.flush();
		pw.close();
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

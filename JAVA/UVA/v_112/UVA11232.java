package v_112;
import java.io.*;
import java.util.*;
public class UVA11232 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			double w=sc.nextInt();
			if(w==0)
				break;
			double h=sc.nextInt();
			double ans=0;
			double start=0,end=h;
			for(int i=0;i<100;i++){
				double m=(start+end)/2;
				double r=Math.min(w, m)/2.0;
				double cir=2*Math.PI*r;
				double max=0;
				if(cir<=w)
					max=Math.max(max, Math.PI*r*r*(h-m));
				if(max==0)
					end=m;
				else{
					ans=Math.max(ans, max);
					start=m;
				}
			}
			start=0;
			end=h;
			for(int i=0;i<100;i++){
				double m=(start+end)/2;
				double r=Math.min(w, m)/2.0;
				double cir=2*Math.PI*r;
				double max=0;
				if(cir<=h-m)
					max=Math.max(max, Math.PI*r*r*w);
				if(max==0)
					end=m;
				else{
					ans=Math.max(ans, max);
					start=m;
				}
			}
			
			
			pw.printf("%.3f\n", ans);
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

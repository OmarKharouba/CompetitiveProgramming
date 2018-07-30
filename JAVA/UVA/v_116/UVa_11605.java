import java.io.*;
import java.util.*;
public class UVa_11605 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		for(int id=1;id<=t;id++){
			int x=sc.nextInt();
			int y=sc.nextInt();
			int z=sc.nextInt();
			int kk=sc.nextInt();
			double ans=0;
			for(int i=1;i<=x;i++)
				for(int j=1;j<=y;j++)
					for(int k=1;k<=z;k++){
						double px=(2.0*i*(x+1-i)-1)/(x*x);
						double py=(2.0*j*(y+1-j)-1)/(y*y);
						double pz=(2.0*k*(z+1-k)-1)/(z*z);
						double p=px*py*pz;
						ans+=(1-Math.pow(1-2*p, kk))/2;
					}
			
			pw.printf("Case %d: %f\n",id,ans);
		}
		
		pw.flush();
		pw.close();
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
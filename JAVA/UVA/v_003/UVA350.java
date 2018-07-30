package v_003;
import java.io.*;
import java.util.*;
public class UVA350 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		int id=1;
		while(true){
			int z=sc.nextInt();
			int i=sc.nextInt();
			int m=sc.nextInt();
			int l=sc.nextInt();
			if(z==0 && i==0 && m==0 && l==0)
				break;
			l=(l%m+m)%m;
			int [] v=new int [m];
			Arrays.fill(v, -1);
			int c=0;
			while(v[l]==-1){
				v[l]=c;
				c++;
				l=((z*l+i)%m+m)%m;
			}
			c-=v[l];
			System.out.printf("Case %d: %d\n",id,c);
			id++;
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

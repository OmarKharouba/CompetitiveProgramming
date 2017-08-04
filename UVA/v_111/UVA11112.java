package v_111;
import java.io.*;
import java.util.*;
public class UVA11112 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			int x=sc.nextInt();
			if(x==0)
				break;
			int y=sc.nextInt();
			int z=sc.nextInt();
			if(Math.abs(x-z)%y!=0)
				pw.println("No accounting tablet");
			else{
				int w=Math.abs(x-z)/y;
				int ans=w/3;
				w%=3;
				ans+=w/2;
				w%=2;
				ans+=w;
				pw.println(ans);
			}
		}
		
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("car.in")));
			} catch (FileNotFoundException e) {
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
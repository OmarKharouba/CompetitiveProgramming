package v_102;
import java.io.*;
import java.util.*;
public class UVA10223 {
	static long [] cnt;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		TreeMap<Long, Integer> map=new TreeMap<Long, Integer>();
		cnt=new long [25];
		for(int i=0;i<25;i++)
			map.put(solve(i),i);
		while(sc.br.ready()){
			long n=sc.nextLong();
			System.out.println(map.get(n));
		}
		
		pw.flush();
		pw.close();
	}
	
	public static long solve(int i){
		if(i<=1)
			return cnt[i]=1;
		if(cnt[i]!=0)
			return cnt[i];
		long c=0;
		for(int j=0;j+1<=i;j++){
			c+=solve(j)*solve(i-1-j);
		}
		return cnt[i]=c;
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

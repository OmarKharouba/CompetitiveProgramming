package v_008;
import java.io.*;
import java.util.*;
public class UVA847 {
	static TreeMap<Long, Boolean> map;
	static long n;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		map=new TreeMap<Long, Boolean>();
		while(sc.br.ready()){
			map.clear();
			n=sc.nextLong();
			pw.println(dp(1)? "Stan wins." : "Ollie wins.");
		}
			
		pw.flush();
		pw.close();
	}
	
	public static boolean dp(long i){
		if(i>=n)
			return false;
		if(map.containsKey(i))
			return map.get(i);
		boolean ans=false;
		for(int k=2;k<=9;k++)
			if(!dp(i*k))
				ans=true;
		map.put(i, ans);
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

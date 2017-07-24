package v_001;
import java.io.*;
import java.util.*;
public class UVA128 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			String s=sc.nextLine();
			if(s.equals("#"))
				break;
			long sum=0;
			int mod=34943;
			for(char c : s.toCharArray())
				sum=((sum<<8)+c)%mod;
			sum %=mod ;
			for(int i=0;i<16;i++)
				sum=(sum<<1)%mod;
			sum=(mod-sum+mod)%mod;
			String ans=hex(sum);
			while(ans.length()<4)
				ans="0"+ans;
			ans=ans.substring(0, 2)+" "+ans.substring(2); 
			pw.println(ans);
		}
		
		pw.flush();
		pw.close();
	}
	
	static String hex(long x){
		String ans="";
		while(x>0){
			long r=x%16;
			x/=16;
			if(r<10)
				ans=r+ans;
			else{
				r-=10;
				ans=(char)('A'+r)+ans;
			}
		}
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
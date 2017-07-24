import java.io.*;
import java.util.*;
public class EPALIN {
	static int n;
	static int [] pi;
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(sc.br.ready()){
			String s=sc.next();
			String t=new StringBuilder(s).reverse().toString();
			n=2*s.length()+1;
			KMP((t+"$"+s).toCharArray());
			int pos=s.length()-pi[n-1];
			pw.print(s);
			for(int i=pos-1;i>=0;i--)
				pw.print(s.charAt(i));
			pw.println();
		}
		
		pw.flush();
		pw.close();
	}
	
	public static void KMP(char [] s){
		pi=new int [n]; 
		int j=0;
		for(int i=1;i<n;i++){
			while(j>0 && s[i]!=s[j])
				j=pi[j-1];
			if(s[i]==s[j])
					j++;
			pi[i]=j;
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

import java.util.*;
import java.io.*;
public class PERIOD {
	static int l;
	static char [] str;
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		int t=sc.nextInt();
		for(int i=1;i<=t;i++){
			n=sc.nextInt();
			prefixFunction(sc.next().toCharArray());
			pw.println("Test case #"+i);
			for(int j=1;j<n;j++){
				int len=j+1;
				int block=len-pi[j];
				if(pi[j]>0 && len%block==0){
					pw.println((j+1)+" "+len/block);
				}
			}
			pw.println();
		}
		pw.flush();
		pw.close();
	}
	static int n;
	static int [] pi;
	public static void prefixFunction(char [] s){
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

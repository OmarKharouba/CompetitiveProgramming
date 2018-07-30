import java.io.*;
import java.util.*;
public class NHAY {
	static int n;
	static int [] pi;
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		while(sc.br.ready()){
			int x=sc.nextInt();
			String s=sc.next();
			String t=sc.next();
			StringBuilder sb=new StringBuilder();
			sb.append(s);
			sb.append("$");
			sb.append(t);
			n=sb.length();
			prefixFunction(sb.toString().toCharArray());
			ArrayList<Integer> ans=new ArrayList<Integer>();
			for(int i=x+1;i<n;i++)
				if(pi[i]==x){
					ans.add(i-2*x);
				}
			if(ans.isEmpty())
				pw.println();
			else{
				for(Integer e : ans)
					pw.println(e);
			}
		}
		pw.flush();
		pw.close();
	}
	
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

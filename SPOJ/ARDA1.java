import java.util.*;
import java.io.*;
public class ARDA1 {
	static int n1,n2,m1,m2;
	static String [] pa,ta;
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		n1=sc.nextInt();
		n2=sc.nextInt();
		pa=new String [n1];
		for(int i=0;i<n1;i++)
			pa[i]=sc.next();
		m1=sc.nextInt();
		m2=sc.nextInt();
		pi=new int [m1][n1][];
		ta=new String [m1];
		for(int i=0;i<m1;i++)
			ta[i]=sc.next();
		boolean done=false;
		for(int i=0;i+n1-1<m1;i++)
			for(int j=0;j+n2-1<m2;j++){
				boolean ok=true;
				inner : for(int k=0;k<n1;k++){
					if(pi[i+k][k]==null)
						prefixFunction(i+k, k);
					if(pi[i+k][k][j+2*n2]!=n2){
						ok=false;
						break inner;
					}
				}
				if(ok){
					done=true;
					pw.println("("+(i+1)+","+(j+1)+")");
				}
			}
		if(!done)
			pw.println("NO MATCH FOUND...");
		pw.flush();
		pw.close();
	}
	static int [][][] pi;
	public static void prefixFunction(int t,int p){
		pi[t][p]=new int [n2+m2+1];
		char [] s=(pa[p]+"$"+ta[t]).toCharArray();
		int j=0;
		for(int i=1;i<n2+m2+1;i++){
			while(j>0 && s[i]!=s[j])
				j=pi[t][p][j-1];
			if(s[i]==s[j])
					j++;
			pi[t][p][i]=j;
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

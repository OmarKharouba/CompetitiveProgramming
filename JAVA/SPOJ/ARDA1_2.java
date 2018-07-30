import java.util.*;
import java.io.*;
public class ARDA1_2 {
	static int n1,n2,m1,m2;
	static char [][] pa,ta;
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		n1=sc.nextInt();
		n2=sc.nextInt();
		pa=new char [n1][n2];
		for(int i=0;i<n1;i++)
			pa[i]=sc.next().toCharArray();
		m1=sc.nextInt();
		m2=sc.nextInt();
		ta=new char [m1][m2];
		for(int i=0;i<m1;i++)
			ta[i]=sc.next().toCharArray();
		boolean done=false;
		for(int i=0;i+n1-1<m1;i++)
			for(int j=0;j+n2-1<m2;j++){
				boolean ok=true;
				inner : for(int k=0;k<n1;k++){
					for(int h=0;h<n2;h++){
						if(pa[k][h]!=ta[i+k][j+h]){
							ok=false;
							break inner;
						}
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

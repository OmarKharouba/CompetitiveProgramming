package atcoder;
import java.io.*;
import java.util.*;
public class arc080_b {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int [] a=new int [k];
		for(int i=0;i<k;i++)
			a[i]=sc.nextInt();
		int p=0;
		int [][] ans=new int [n][m];
		boolean e=true;
		for(int i=0;i<n;i++){
			if(e){
				for(int j=0;j<m;j++){
					ans[i][j]=p+1;
					a[p]--;
					if(a[p]==0)
						p++;
				}
			}else{
				for(int j=m-1;j>=0;j--){
					ans[i][j]=p+1;
					a[p]--;
					if(a[p]==0)
						p++;
				}
			}
			e=!e;
		}
		
		
		for(int i=0;i<n;i++){
			boolean f=true;
			for(int j : ans[i]){
				if(!f)
					pw.print(" ");
				pw.print(j);
				f=false;
			}
			pw.println();
		}
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
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
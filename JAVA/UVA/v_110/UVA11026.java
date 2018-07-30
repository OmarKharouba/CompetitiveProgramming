package v_110;
import java.io.*;
import java.util.*;
public class UVA11026 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			int n=sc.nextInt();
			int m=sc.nextInt();
			if(n==0 && m==0)
				break;
			int [] a=new int [n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			long [][] arr=new long [n][n];
			arr[0][0]=a[0];
			for(int i=1;i<n;i++){
				arr[i][0]=(arr[i-1][0]+a[i])%m;
				for(int j=1;j<n;j++){
					arr[i][j]=(arr[i-1][j]+arr[i-1][j-1]*a[i])%m;
				}
			}
			long mx=0;
			for(int i=0;i<n;i++)
				mx=Math.max(mx, arr[n-1][i]);
			pw.println(mx);
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
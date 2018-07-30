package codeforces;
import java.io.*;
import java.util.*;
public class CF582_D1_B {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int t=sc.nextInt();
		int [] a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int [] lis=new int [n];
		int max=0;
		for(int i=n-1;i>=0;i--){
			lis[i]=1;
			for(int j=n-1;j>i;j--)
				if(a[j]>=a[i] && lis[j]+1>lis[i])
					lis[i]=lis[j]+1;
			max=Math.max(max, lis[i]);
		}
		int [] dif=new int [n];
		int [] old=Arrays.copyOf(lis, lis.length);
		int lst=Math.min(305, t-1);
		for(int i=0;i<lst;i++){
			for(int j=n-1;j>=0;j--){
				int mx=0;
				for(int k=0;k<n;k++)
					if(a[j]<=a[k])
						mx=Math.max(mx, lis[k]+1);
				lis[j]=mx;
				max=Math.max(max, lis[j]);
			}
			for(int j=0;j<n;j++)
				dif[j]=lis[j]-old[j];
			old=Arrays.copyOf(lis, lis.length);
		}
		t=t-lst-1;
		for(int i=0;i<n;i++)
			max=Math.max(max, lis[i]+t*dif[i]);
		pw.println(max);
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
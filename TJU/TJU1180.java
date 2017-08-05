package TJU;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class TJU1180 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		while(true){			
			int n=sc.nextInt();
			int m=sc.nextInt();
			if(n==-1 && m==-1)
				break;
			int [] a=new int [n];
			ArrayList<Integer> set=new ArrayList<Integer>();
			for(int x=1;x<=n;x++)
				set.add(x);
			for(int i=0;i<n;i++){
				int start=0,end=set.size()-1,ans=-1;
				int can=(int)(1L*(n-1-i)*(n-2-i)/2);
				while(start<=end){
					int mid=((start+end)>>1);
					int rem=m-mid;
					if(rem<=can){
						ans=mid;
						end=mid-1;
					}else
						start=mid+1;
				}
				m-=ans;
				a[i]=set.get(ans);
				set.remove(ans);
			}
			for(int i=0;i<n;i++){				
				if(i>0)
					pw.print(" ");
				pw.print(a[i]);
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

import java.io.*;
import java.util.*;
public class CF835_D2_D {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		String s=sc.next();
		char [] c=s.toCharArray();
		int n=s.length();
		boolean [][] pal=new boolean [n][n];
		for(int i=0;i<n;i++){
			pal[i][i]=true;
			if(i<n-1)
				pal[i][i+1]=c[i]==c[i+1];
		}
		for(int i=n-1;i>=0;i--)
			for(int j=i+2;j<n;j++)
				pal[i][j]=c[i]==c[j] && pal[i+1][j-1];
		int [] cnt=new int [n];
		
		for(int i=0;i<n;i++)
			for(int j=i;j<n;j++){
				if(pal[i][j]){
					int lev=1;
					int k=j;
					while(k>i){
						k=(i+k-1)/2;
						if(!pal[i][k])
							break;
						lev++;
					}
					cnt[lev-1]++;
				}
			}
		for(int i=n-2;i>=0;i--)
			cnt[i]+=cnt[i+1];
		for(int i : cnt)
			pw.print(i+" ");
		pw.flush();
		pw.close();
	}
	
	static class pair{
		int x,y;
		pair(int a,int b){
			x=a;
			y=b;
		}
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
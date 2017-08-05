import java.io.*;
import java.util.*;
public class CF837_D12_D {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		long [] a=new long [n];
		int [] two=new int [n];
		int [] five=new int [n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextLong();
			long x=a[i];
			while(x%2==0){
				two[i]++;
				x/=2;
			}
			x=a[i];
			while(x%5==0){
				five[i]++;
				x/=5;
			}
		}
		int inf=(int)1e8;
		int [][][] mem=new int [2][201][5001];
		for(int [] x : mem[0])
			Arrays.fill(x, -inf);
		mem[0][0][0]=0;
		int p=0;
		for(int i=n-1;i>=0;i--){
			p=p^1;
			for(int c=0;c<=k;c++){
				for(int f=0;f<=5000;f++){
					int ans=mem[p^1][c][f];
					if(f>=five[i] && c>0)
						ans=Math.max(ans, two[i]+mem[p^1][c-1][f-five[i]]);
					mem[p][c][f]=ans;
				}
			}
		}
		
		int max=0;
		for(int i=0;i<5001;i++)
			max=Math.max(max, Math.min(i, mem[p][k][i]));
		
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
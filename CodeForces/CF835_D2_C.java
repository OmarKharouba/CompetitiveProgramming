import java.io.*;
import java.util.*;
public class CF835_D2_C {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int q=sc.nextInt();
		int c=sc.nextInt();
		int [][][] cum=new int [11][101][101];
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			int y=sc.nextInt();
			int s=sc.nextInt();
			cum[s][x][y]++;
		}
		for(int k=0;k<11;k++){
			for(int i=0;i<101;i++)
				for(int j=0;j<101;j++){
					if(j>0)
						cum[k][i][j]+=cum[k][i][j-1];
					if(i>0)
						cum[k][i][j]+=cum[k][i-1][j];
					if(j>0 && i>0)
						cum[k][i][j]-=cum[k][i-1][j-1];
				}
		}
		
		while(q-->0){
			int t=sc.nextInt();
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			
			long ans=0;
			for(int k=0;k<11;k++){
				int sum=cum[k][x2][y2];
				if(x1>0)
					sum-=cum[k][x1-1][y2];
				if(y1>0)
					sum-=cum[k][x2][y1-1];
				if(x1>0 && y1>0)
					sum+=cum[k][x1-1][y1-1];
				int newS=(k+t)%(c+1);
				ans+=sum*newS;
//				if(k<=1)
//					System.out.println(k+" "+sum+" "+newS);
			}
			pw.println(ans);
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
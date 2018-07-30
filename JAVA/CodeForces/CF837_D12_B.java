import java.io.*;
import java.util.*;
public class CF837_D12_B {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		char [][] a=new char [n][m];
		for(int i=0;i<n;i++)
			a[i]=sc.next().toCharArray();
		int x=n/3;
		int y=m/3;
		boolean ans=false;
		char c1=a[0][0],c2=a[x][0],c3=a[2*x][0];
		if(n%3==0 && c1!=c2 && c2!=c3 && c1!=c3){
			boolean ok=true;
			for(int i=0;i<x;i++)
				for(int j=0;j<m;j++)
					if(a[i][j]!=c1)
						ok=false;
			for(int i=x;i<2*x;i++)
				for(int j=0;j<m;j++)
					if(a[i][j]!=c2)
						ok=false;
			for(int i=2*x;i<n;i++)
				for(int j=0;j<m;j++)
					if(a[i][j]!=c3)
						ok=false;
			if(ok)
				ans=true;
		}
		c1=a[0][0];c2=a[0][y];c3=a[0][2*y];
		if(m%3==0 && c1!=c2 && c2!=c3 && c1!=c3){
			boolean ok=true;
			for(int i=0;i<n;i++)
				for(int j=0;j<y;j++)
					if(a[i][j]!=c1)
						ok=false;
			for(int i=0;i<n;i++)
				for(int j=y;j<2*y;j++)
					if(a[i][j]!=c2)
						ok=false;
			for(int i=0;i<n;i++)
				for(int j=2*y;j<m;j++)
					if(a[i][j]!=c3)
						ok=false;
			if(ok)
				ans=true;
		}
		if(ans)
			pw.println("YES");
		else
			pw.println("NO");
		
		
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
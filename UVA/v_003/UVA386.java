package v_003;
import java.io.*;
import java.util.*;
public class UVA386 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		ArrayList<triple> [] ans=new ArrayList [201];
		for(int i=0;i<=200;i++)
			ans[i]=new ArrayList<triple>();
		for(long i=2;i<=200;i++)
			for(long j=i+1;i*i*i+j*j*j<=8000000;j++)
				for(long k=j+1;i*i*i+j*j*j+k*k*k<=8000000;k++){
					long sum=i*i*i+j*j*j+k*k*k;
					long root=(long)Math.cbrt(sum);
					if(root*root*root==sum)
						ans[(int)root].add(new triple((int)i, (int)j, (int)k));
				}
		for(int i=6;i<=200;i++)
			for(triple t : ans[i])
				System.out.printf("Cube = %d, Triple = (%d,%d,%d)\n",i,t.a,t.b,t.c);
		
		pw.flush();
		pw.close();
	}
	
	static class triple{
		int a,b,c;
		triple(int x,int y,int z){
			a=x;
			b=y;
			c=z;
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

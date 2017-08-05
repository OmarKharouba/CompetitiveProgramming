import java.io.*;
import java.util.*;
public class CF835_D2_B {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int k=sc.nextInt();
		String n=sc.next();
		int [] c=new int [10];
		for(char ch : n.toCharArray())
			c[ch-'0']++;
		
		long sum=0;
		for(int i=0;i<10;i++)
			sum+=i*c[i];
		long rem=k-sum;
		int cnt=0;
		for(int i=0;i<10 && rem>0;i++){
			int dif=9-i;
			long max=dif*c[i];
			if(max<=rem){
				cnt+=c[i];
				rem-=max;
			}else{
				cnt+=(int)Math.ceil(1.0*rem/dif);
				break;
			}
		}
		
		pw.println(cnt);
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
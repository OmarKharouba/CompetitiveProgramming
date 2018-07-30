package v_101;
import java.io.*;
import java.util.*;
public class UVA10114 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		while(true){
			int duration=sc.nextInt();
			if(duration<0)
				break;
			double down=sc.nextDouble();
			double loan=sc.nextDouble();
			double installment=loan/duration;
			int n=sc.nextInt()-1;
			double [] per=new double [duration];
			Arrays.fill(per, -1);
			sc.nextInt();
			double d0=sc.nextDouble();
			double value=down+loan-d0*(loan+down);
			for(int i=0;i<n;i++){
				per[sc.nextInt()-1]=sc.nextDouble();
			}
			for(int i=0;i<duration;i++){
				if(per[i]==-1){
					if(i==0)
						per[i]=d0;
					else
						per[i]=per[i-1];
				}
			}
			if(loan<value){
				pw.println("0 months");
				continue;
			}
			int ans=-1;
			for(int i=0;i<duration;i++){
				value-=per[i]*value;
				loan-=installment;
				if(loan<value){
					ans=i;
					break;
				}
			}
			pw.println((ans+1)+(ans==0? " month" : " months"));
		}
		
		pw.flush();
		pw.close();
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

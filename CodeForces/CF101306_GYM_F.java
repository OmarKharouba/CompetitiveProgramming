import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;


public class CF101306_GYM_F {
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
			String [] sa=br.readLine().split(" ");
			int n=Integer.parseInt(sa[0]);
			int m=Integer.parseInt(sa[1]);
			int x=Integer.parseInt(sa[2]);
			int i=Math.min(m, n/2);
			long ans=1L*i*(n-i)*x;
			pw.println(i+" "+ans);
		}
		pw.flush();
		pw.close();
	}
}
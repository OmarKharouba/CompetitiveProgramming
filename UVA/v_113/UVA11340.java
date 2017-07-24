package v_113;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
public class UVA11340 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=1;i<=t;i++){
			int n=Integer.parseInt(bf.readLine());
			char[] c=new char[n];
			int[] a=new int[n];
			for(int j=0;j<n;j++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				c[j]=sa[0].charAt(0);
				a[j]=Integer.parseInt(sa[1]);
			}
			int m=Integer.parseInt(bf.readLine());
			long cnt=0;
			for(int j=0;j<m;j++){
				String s=bf.readLine();
				cnt+=f(s,c,a);
			}
			DecimalFormat df=new DecimalFormat("#0.00");
			System.out.println(df.format(cnt/100.0)+"$");
		}
	}
	
	public static long f(String s,char[]c,int[]a){
		long r=0;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			for(int j=0;j<c.length;j++){
				if(ch==c[j]){
					r+=a[j];
					break;
				}
			}
		}
		return r;
	}
}
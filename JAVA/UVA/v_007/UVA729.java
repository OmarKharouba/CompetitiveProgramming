package v_007;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA729 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		int max=t;
		while(t-->0){
			if(t+1<max)
				System.out.println();
			bf.readLine();
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int h=Integer.parseInt(sa[1]);
			f("",n-h,h);
		}
	}
	
	public static void f(String s,int zero,int one){
		if(zero==0 && one==0){
			System.out.println(s);
			return;
		}
		if(zero>0)
			f(s+"0",zero-1,one);
		if(one>0)
			f(s+"1",zero,one-1);
	}
}
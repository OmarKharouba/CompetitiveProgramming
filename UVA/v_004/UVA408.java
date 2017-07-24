package v_004;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA408 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			int step=Integer.parseInt(sa[0]);
			int mod=Integer.parseInt(sa[1]);
			int[]a=new int[mod];
			a[0]=1;
			for(int seed=0;(seed+step)%mod!=0;seed=(seed+step)%mod){
				a[(seed+step)%mod]=1;
			}
			for(int i=0;i<(10-(step+"").length());i++){
				System.out.print(" ");
			}
			System.out.print(step);
			for(int i=0;i<(10-(mod+"").length());i++){
				System.out.print(" ");
			}
			System.out.print(mod);
			for(int i=0;i<4;i++){
				System.out.print(" ");
			}
			f(a);
			System.out.println();
		}
		bf.close();
	}
	
	public static void f(int[]a){
		for(int i=0;i<a.length;i++){
			if(a[i]==0){
				System.out.println("Bad Choice");
				return;
			}
		}
		System.out.println("Good Choice");
	}
}

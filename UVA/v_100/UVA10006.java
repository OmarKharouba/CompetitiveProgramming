package v_100;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10006 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int n=1;
		while((n=Integer.parseInt(bf.readLine()))!=0){
			if((!prime(n))&&f(n))
				System.out.println("The number "+n+" is a Carmichael number.");
			else
				System.out.println(n+" is normal.");
		}
		bf.close();
	}
	
	public static boolean prime(int x){
		for (int i=2;i<x/2;i++){
			if(x%i==0)
				return false;
		}
		return true;
	}
	
	public static boolean f(int n){
		for (int a=2;a<n;a++){
			if(pow(a,n,n)!=a)
				return false;
		}
		return true;
	}
	
	public static long pow(int x,int y,int n){
		if(y==0)
			return 1%n;
		if(y%2==0){
			long z=pow(x,y/2,n);
			return (z*z)%n;
		}
		return ((x%n)*pow(x,y-1,n))%n;
	}
}

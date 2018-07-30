package v_003;
import java.io.IOException;
import java.util.Scanner;
public class UVA374 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int b=sc.nextInt();
			int p=sc.nextInt();
			int m=sc.nextInt();
			System.out.println(pow(b,p,m));
		}
		sc.close();
	}
	
	public static int pow(int x,int y,int n){
		if(y==0)
			return 1%n;
		if(y%2==0){
			int z=pow(x,y/2,n);
			return (z*z)%n;
		}
		return ((x%n)*pow(x,y-1,n))%n;
	}
}

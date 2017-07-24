package v_106;

import java.io.IOException;
import java.util.Scanner;
public class UVA10656 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		Scanner sc=new Scanner(System.in);
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			boolean f=false;
			for(int i=0;i<n;i++){
				int x=sc.nextInt();
				if(x>0){
					if(!f)
						System.out.print(x);
					else
						System.out.print(" "+x);
					f=true;
				}
			}
			if(!f)
				System.out.print(0);
			System.out.println();
		}
		sc.close();
	}
}
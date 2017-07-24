package v_110;

import java.io.IOException;
import java.util.Scanner;
public class UVA11093 {
	public static void main(String[]ar0gs)throws IOException{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=1;i<=t;i++){
			int n=sc.nextInt();
			int[]a=new int[n];
			int[]b=new int[n];
			for(int j=0;j<n;j++){
				a[j]=sc.nextInt();
			}
			for(int j=0;j<n;j++){
				b[j]=sc.nextInt();
			}
			int r=0;
			for(int j=0;j<n;j++){
				int sum=0;
				boolean flag=true;
				for(int k=0;k<n && flag;k++){
					sum+=a[(j+k)%n];
					if(sum>=b[(j+k)%n])
						sum-=b[(j+k)%n];
					else{
						flag=false;
						j+=k;
					}
				}
				if(flag){
					r=j+1;
					break;
				}
			}
			System.out.println("Case "+i+": "+((r==0)? "Not possible" : "Possible from station "+r));
		}
		sc.close();
	}
}
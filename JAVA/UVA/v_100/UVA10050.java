package v_100;

import java.io.IOException;
import java.util.Scanner;
public class UVA10050 {
	public static void main(String[]ar0gs)throws IOException{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=1;i<=t;i++){
			int d=sc.nextInt();
			boolean[]a=new boolean [d+1];
			int n=sc.nextInt();
			int cnt=0;
			for(int j=0;j<n;j++){
				int x=sc.nextInt();
				for(int k=x;k<=d;k+=x){
					if(!a[k] && k%7!=0 && (k+1)%7!=0){
						cnt++;
						a[k]=true;
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
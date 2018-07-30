package v_115;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA11581 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			int[]a=new int[9];
			bf.readLine();
			int sum=0;
			for(int j=0;j<3;j++){
				String s=bf.readLine();
				for(int k=0;k<3;k++){
					a[3*j+k]=Integer.parseInt(""+s.charAt(k));
					sum+=a[3*j+k];
				}
			}
			int r=-1;
			while(sum!=0){
				int[]b=new int[9];
				b[0]=(a[1]+a[3])%2;
				b[1]=(a[0]+a[2]+a[4])%2;
				b[2]=(a[1]+a[5])%2;
				b[3]=(a[0]+a[4]+a[6])%2;
				b[4]=(a[1]+a[3]+a[5]+a[7])%2;
				b[5]=(a[2]+a[4]+a[8])%2;
				b[6]=(a[3]+a[7])%2;
				b[7]=(a[4]+a[6]+a[8])%2;
				b[8]=(a[5]+a[7])%2;
				sum=0;
				for(int j=0;j<9;j++){
					a[j]=b[j];
					sum+=a[j];
				}
				r++;
			}
			System.out.println(r);
		}
	}
}
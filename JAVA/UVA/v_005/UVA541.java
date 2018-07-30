package v_005;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA541 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			int[][]a=new int[n][n];
			int xp=0,xc=0,yp=0,yc=0;
			for(int i=0;i<n;i++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				int sum=0;
				for(int j=0;j<n;j++){
					a[i][j]=Integer.parseInt(sa[j]);
					sum+=a[i][j];
				}
				if(sum%2==1){
					xp=i+1;
					xc++;
				}
			}
			for(int i=0;i<n;i++){
				int sum=0;
				for(int j=0;j<n;j++){
					sum+=a[j][i];
				}
				if(sum%2==1){
					yp=i+1;
					yc++;
				}
			}
			System.out.println((yc==0 && xc==0)? "OK" : (yc==1 && xc==1)? "Change bit ("+xp+","+yp+")" : "Corrupt");
		}
	}
}
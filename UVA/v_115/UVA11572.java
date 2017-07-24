package v_115;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA11572 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(bf.readLine());
		for(int h=0;h<k;h++){
			int n=Integer.parseInt(bf.readLine());
			int[]a=new int[n];
			int max=0;
			for(int j=0;j<n;j++){
				a[j]=Integer.parseInt(bf.readLine());
				if(a[j]>max)
					max=a[j];
			}
			boolean[]b=new boolean[max+1];
			int i=0,j=0,c=0;
			int cnt=0;
			while(j<n){
				if(b[a[j]]){
					while(a[i]!=a[j]){
						b[a[i]]=false;
						i++;
						c--;
					}
					b[a[i]]=false;
					i++;
					c--;
				}
				c++;
				b[a[j]]=true;
				j++;
				if(c>cnt)
					cnt=c;
			}
			System.out.println(cnt);
		}
	}
}
package v_114;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA11496 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int[]a=new int[n+2];
			for(int i=0;i<n;i++){
				a[i+1]=Integer.parseInt(sa[i]);
			}
			a[0]=a[n];
			a[n+1]=a[1];
			int cnt=0;
			for(int i=1;i<n+1;i++){
				if((a[i+1]> a[i] && a[i-1]>a[i]) || (a[i+1]< a[i] && a[i-1]<a[i]))
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}
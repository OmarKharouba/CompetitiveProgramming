package v_005;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA591 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int[]a=new int[n];
			int sum=0;
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(sa[i]);
				sum+=a[i];
			}
			int r=0;
			for(int i=0;i<n;i++){
				int av=sum/n;
				if(a[i]>av)
					r+=a[i]-av;
			}
			System.out.println("Set #"+cnt);
			System.out.println("The minimum number of moves is "+r+".");
			System.out.println();
			cnt++;
		}
	}
}
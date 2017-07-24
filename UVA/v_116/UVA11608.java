package v_116;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA11608 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n<0)
				break;
			System.out.println("Case "+cnt+":");
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int[]a=new int[12];
			for(int i=0;i<12;i++){
				a[i]=Integer.parseInt(sa[i]);
			}
			s=bf.readLine();
			sa=s.split(" ");
			int[]b=new int[12];
			for(int i=0;i<12;i++){
				b[i]=Integer.parseInt(sa[i]);
			}
			for(int i=0;i<12;i++){
				if(b[i]<=n){
					System.out.println("No problem! :D");
					n-=b[i];
				}
				else
					System.out.println("No problem. :(");
				n+=a[i];
			}
			cnt++;
		}
	}
}
package v_004;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA414 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			int total=0,min=25;
			for(int i=0;i<n;i++){
				String s=bf.readLine();
				int cnt=0;
				for(int j=1;j<24;j++){
					if(s.charAt(j)!='X')
						cnt++;
				}
				total+=cnt;
				if(cnt<min)
					min=cnt;
			}
			System.out.println(total-min*n);
		}
	}
}
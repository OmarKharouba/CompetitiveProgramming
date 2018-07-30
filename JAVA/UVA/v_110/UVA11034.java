package v_110;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA11034 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(bf.readLine());
		for(int i=1;i<=k;i++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int len=Integer.parseInt(sa[0])*100;
			int m=Integer.parseInt(sa[1]);
			int[]right=new int[m];
			int[]left=new int[m];
			int startR=0,endR=0,startL=0,endL=0;
			for(int j=0;j<m;j++){
				s=bf.readLine();
				sa=s.split(" ");
				int x=Integer.parseInt(sa[0]);
				if(sa[1].equals("left")){
					left[endL]=x;
					endL++;
				}else{
					right[endR]=x;
					endR++;
				}
			}
			int cnt=0;
			while (startL<endL || startR<endR){
				if(startL<endL){
					int sum=0;
					for(int j=0;startL<endL && sum+left[startL]<=len;j++){
						int c=left[startL];
						sum+=c;
						startL++;
					}
				}
				cnt++;
				if(startL<endL && startR==endR)
					cnt++;
				if(startR<endR){
					cnt++;
					int sum=0;
					for(int j=0;startR<endR && sum+right[startR]<=len;j++){
						int c=right[startR];
						sum+=c;
						startR++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
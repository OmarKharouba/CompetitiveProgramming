package v_006;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA665 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(bf.readLine());
		for(int i=0;i<m;i++){
			bf.readLine();
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int k=Integer.parseInt(sa[1]);
			boolean[]coin=new boolean[n+1];
			for(int j=0;j<k;j++){
				s=bf.readLine();
				sa=s.split(" ");
				int p=Integer.parseInt(sa[0]);
				int[]a=new int[p*2];
				for(int h=0;h<a.length;h++){
					a[h]=Integer.parseInt(sa[h+1]);
				}
				char c=bf.readLine().charAt(0);
				if(c=='='){
					for(int h=0;h<a.length;h++){
						coin[a[h]]=true;
					}
				}
				else{
					for(int h=1;h<n+1;h++){
						boolean flag=true;
						for(int g=0;g<a.length && flag;g++){
							if(h==a[g])
								flag=false;
						}
						if(flag)
							coin[h]=true;
					}
				}	
			}
			int r=0;
			int cnt=0;
			for(int j=1;j<coin.length && cnt<2;j++){
				if(!coin[j]){
					cnt++;
					r=j;
				}
			}
			System.out.println((cnt<2)? r : 0);
			if(i<m-1)
				System.out.println();
		}
	}
}
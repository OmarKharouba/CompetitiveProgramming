package v_121;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA12150{
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			int[]a=new int[n];
			int sum=0;
			boolean flag=true;
			for(int i=0;i<n;i++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				int x=Integer.parseInt(sa[0]);
				int y=Integer.parseInt(sa[1]);
				sum+=y;
				if(i+y>=0 && i+y<n){
					if(a[i+y]==0)
						a[i+y]=x;
					else
						flag=false;
				}else
					flag=false;
			}
			if(sum!=0)
				flag=false;
			if(flag){
				for(int i=0;i<n;i++){
					if(i<n-1)
						System.out.print(a[i]+" ");
					else
						System.out.println(a[i]);
				}
			}
			else
				System.out.println(-1);
		}
	}
}
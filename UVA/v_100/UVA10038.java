package v_100;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA10038 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			boolean[]a=new boolean[n];
			for(int j=2;j<sa.length;j++){
				int x=Integer.parseInt(sa[j]);
				int y=Integer.parseInt(sa[j-1]);
				if(Math.abs(x-y)<n)
					a[Math.abs(x-y)]=true;
			}
			boolean r=true;
			for(int j=1;j<n;j++){
				r=r && a[j];
			}
			System.out.println((r)? "Jolly" : "Not jolly");
		}
	}
}
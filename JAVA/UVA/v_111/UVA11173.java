package v_111;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11173 {
 	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(bf.readLine());
		for(int h=0;h<x;h++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int k=Integer.parseInt(sa[1]);
			int pow=(int)Math.pow(2, n);
			int r=0;
			for(int i=n-1;i>=0;i--){
				if(k>=pow/2){
					r+=Math.pow(2, i);
					k=pow-1-k;
				}
				pow/=2;
			}
			System.out.println(r);
		}
	}
}

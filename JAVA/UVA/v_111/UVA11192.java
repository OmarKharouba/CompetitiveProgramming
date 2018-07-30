package v_111;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA11192 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			if(n==0)
				break;
			s=sa[1];
			int x=s.length()/n;
			String r="";
			for(int i=x-1;i<s.length();i+=x){
				for(int j=i;j>i-x;j--){
					r+=s.charAt(j);
				}
			}
			System.out.println(r);
		}
	}
}
package v_124;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA12405 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			int l=Integer.parseInt(bf.readLine());
			String s=bf.readLine();
			int cnt=0;
			for(int j=0;j<l;j++){
				if(s.charAt(j)=='.'){
					cnt++;
					j+=2;
				}
			}
			System.out.println("Case "+(i+1)+": "+cnt);
		}
	}
}
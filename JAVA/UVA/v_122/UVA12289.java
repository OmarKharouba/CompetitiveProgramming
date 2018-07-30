package v_122;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA12289 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(bf.readLine());
		for(int i=0;i<x;i++){
			String s=bf.readLine();
			if(s.length()>3)
				System.out.println(3);
			else{
				char a=s.charAt(0);
				char b=s.charAt(1);
				char c=s.charAt(2);
				if((a=='o' && b=='n') || (a=='o' && c=='e') || (c=='e' && b=='n'))
					System.out.println(1);
				else
					System.out.println(2);
			}
		}
	}
}

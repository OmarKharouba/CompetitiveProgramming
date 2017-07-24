package v_115;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11547 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(bf.readLine());
		for(int i=0;i<x;i++){
			int y=Integer.parseInt(bf.readLine());
			String r=""+((((((y*567)/9)+7492)*235)/47)-498);
			System.out.println(r.charAt(r.length()-2));
		}
	}
}

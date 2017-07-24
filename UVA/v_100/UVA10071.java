package v_100;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10071 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			int v=Integer.parseInt(sa[0]);
			int t=Integer.parseInt(sa[1]);
			System.out.println(2*v*t);
		}
	}
}

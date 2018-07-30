package v_004;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA401 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=bf.readLine())!=null){
			String r="";
			if(palindrome(s)){
				if(mirror(s)){
					r=s+" -- is a mirrored palindrome.";
				}
				else{
					r=s+" -- is a regular palindrome.";
				}
			}
			else{
				if(mirror(s)){
					r=s+" -- is a mirrored string.";
				}
				else{
					r=s+" -- is not a palindrome.";
				}
			}
			System.out.println(r);
			System.out.println();
		}
		bf.close();
	}
	
	public static boolean palindrome(String s){
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
	
	public static boolean mirror(String s){
		String r=reverse(s);
		if(r.equals("f"))
			return false;
		else{
			String s2=s+r;
			return palindrome(s2);
			
		}
	}
	
	public static String reverse(String s){
		String r="";
		for(int i=0;i<s.length();i++){
			char c=rev(s.charAt(i));
			if(c=='f')
				return "f";
			else{
				r+=c;
			}
		}
		return r;
	}
	
	public static char rev(char c){
		switch(c){
		case 'A' :
		case 'H' :
		case 'I' :
		case 'M' :
		case 'O' :
		case 'T' :
		case 'U' :
		case 'V' :
		case 'W' :
		case 'X' :
		case 'Y' :
		case '8' :
		case '1' : return c;
		case 'E' : return '3';
		case 'J' : return 'L';
		case 'L' : return 'J';
		case 'S' : return '2';
		case 'Z' : return '5';
		case '2' : return 'S';
		case '3' : return 'E';
		case '5' : return 'Z';
		default : return 'f';
			
		}
	}
}

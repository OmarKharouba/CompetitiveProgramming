package v_119;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11933 {
 	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int x=Integer.parseInt(bf.readLine());
			if(x==0)
				break;
			String s=f(x);
			int a=0,b=0;
			int cnt=0;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='1'){
					cnt++;
					if(cnt%2==1)
						a+=Math.pow(2, i);
					else
						b+=Math.pow(2, i);
				}
			}
			System.out.println(a+" "+b);
		}
	}
 	
 	public static String f(int x){
 		String r="";
 		while(x>0){
 			r+=x%2;
 			x/=2;
 		}
 		return r;
 	}
}

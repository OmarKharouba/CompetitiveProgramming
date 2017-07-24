package v_100;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10018 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			long z;
			StringBuffer s=new StringBuffer(bf.readLine());
			int c=0;
			do{
				long x=Long.parseLong(s.toString());
				s.reverse();
				long y=Long.parseLong(s.toString());
				z=x+y;
				s=new StringBuffer(z+"");
				c++;
			}while(!(palindrom(z)));
			System.out.println(c+" "+z);
		}
	}
	
	public static boolean palindrom(long x){
		String s=x+"";
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i)!=(s.charAt(s.length()-i-1)))
				return false;
		}
		return true;
	}
}

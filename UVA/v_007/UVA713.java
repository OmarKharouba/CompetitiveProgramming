package v_007;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;
public class UVA713 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			BigInteger r=f(sa[0]).add(f(sa[1]));
			System.out.println(f(r.toString()));
		}
		bf.close();
	}
	
	public static BigInteger f(String s){
		String r="";
		for(int i=0;i<s.length();i++){
			r=s.charAt(i)+r;
		}
		while(r.charAt(0)=='0'){
			r=r.substring(1);
		}
		return(new BigInteger(r));
	}
}

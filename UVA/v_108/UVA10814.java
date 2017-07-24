package v_108;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;
public class UVA10814{
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			String s=bf.readLine();
			String[]sa=s.split(" / ");
			BigInteger x=new BigInteger(sa[0]);
			BigInteger y=new BigInteger(sa[1]);
			BigInteger g=x.gcd(y);
			System.out.println(x.divide(g)+" / "+y.divide(g));
		}
	}
}
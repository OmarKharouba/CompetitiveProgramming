package v_101;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;
public class UVA10106 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			BigInteger x=new BigInteger(s);
			BigInteger y=new BigInteger(bf.readLine());
			System.out.println(x.multiply(y));
		}
		bf.close();
	}
}

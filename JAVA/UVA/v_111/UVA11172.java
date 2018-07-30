package v_111;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11172 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		while(n-->0){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int a=Integer.parseInt(sa[0]);
			int b=Integer.parseInt(sa[1]);
			System.out.println((a==b)? "=" : (a>b)? ">" : "<");
		}
	}
}

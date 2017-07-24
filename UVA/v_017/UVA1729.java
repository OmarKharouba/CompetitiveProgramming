package v_017;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA1729 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		int c=1;
		for(int i=0;i<t;i++){
			
			System.out.println("Case "+c+": ");
			c++;
		}
	}
}

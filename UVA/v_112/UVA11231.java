package v_112;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11231 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int m=Integer.parseInt(sa[0]);
			int n=Integer.parseInt(sa[1]);
			int c=Integer.parseInt(sa[2]);
			if(m==0&& n==0&& c==0)
				break;
			if(c==0)
				System.out.println((int)Math.floor((m-7)*(n-7)/2.0));
			else
				System.out.println((int)Math.ceil((m-7)*(n-7)/2.0));
		}
		bf.close();
	}
}


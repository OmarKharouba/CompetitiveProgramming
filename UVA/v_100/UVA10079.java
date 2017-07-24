package v_100;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10079 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int x=Integer.parseInt(bf.readLine());
			if(x<0)
				break;
			System.out.println(f(x));
		}
		bf.close();
	}
	
	public static long f(int x){
		if(x==0)
			return 1;
		long r=2;
		for(int i=2;i<=x;i++){
			r+=i;
		}
		return r;
	}
}


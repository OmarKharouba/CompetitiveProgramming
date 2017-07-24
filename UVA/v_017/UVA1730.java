package v_017;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA1730 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			long r=0;
			for(int i=2;i<=n;i++){
				r+=f(i);
			}
			System.out.println(r);
		}
	}
	
	public static long f(int n){
		long r=0;
		for(int i=1;i*i<=n;i++){
			if(n%i==0){
				if(i*i==n)
					r+=i;
				else{
					r+=i;
					r+=(n/i);
				}
			}
		}
		return r;
	}
}

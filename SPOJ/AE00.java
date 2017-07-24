
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class AE00 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		int cnt=0;
		for(int i=1;i<=n;i++){
			for(int j=i;j<=n && i*j<=n;j++){
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
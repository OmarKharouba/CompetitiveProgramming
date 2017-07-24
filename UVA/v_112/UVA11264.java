package v_112;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11264 {
	static int n;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int n=Integer.parseInt(bf.readLine());
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int[]a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(sa[i]);
			}
			int cnt=1;
			long sum=0;
			for(int i=0;i<n-1;i++){
				if(sum+a[i]<a[i+1]){
					sum+=a[i];
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
package v_124;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA12455 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			int l=Integer.parseInt(bf.readLine());
			int n=Integer.parseInt(bf.readLine());
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int[]a=new int[n];
			for(int j=0;j<n;j++){
				a[j]=Integer.parseInt(sa[j]);
			}
			boolean flag=false;
			for(int mask=(1 << n)-1; mask>=0;mask--){
				int sum=0;
				for(int j=0;j<n;j++){
					if((mask & (1 << j))!=0){
						sum+=a[j];
					}
				}
				if(sum==l)
					flag=true;
			}
			System.out.println((flag)? "YES" : "NO");
		}
	}
}

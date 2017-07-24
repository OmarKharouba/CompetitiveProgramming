package v_130;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.TreeMap;
public class UVA13032 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=1;i<=t;i++){
			int n=Integer.parseInt(bf.readLine());
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int[]a=new int[n];
			for(int j=0;j<n;j++){
				a[j]=Integer.parseInt(sa[j]);
			}
			long max=1;
			Arrays.sort(a);
			for(int j=0;j<n;j++){
				if(a[j]>j){
					long y=(a[j]-j)%1000000007;
					max=(max*y)%1000000007;
				}else{
					max=0;
					break;
				}
			}
			System.out.println("Case "+i+": "+max);
		}
	}
}
package v_110;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA11059 {
	static int n;
	static ArrayList<Integer> a;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		int cnt=1;
		while((s=bf.readLine())!=null){
			int n=Integer.parseInt(s);
			s=bf.readLine();
			bf.readLine();
			String[]sa=s.split(" ");
			int[]a=new int[n];
			long[][]b=new long[n][n];
			long max=0;
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(sa[i]);
				b[i][i]=a[i];
				if(a[i]>max)
					max=a[i];
			}
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					b[i][j]=1L*b[i][j-1]*b[j][j];
					if(b[i][j]>max)
						max=b[i][j];
				}
			}
			
			System.out.println("Case #"+cnt+": The maximum product is "+max+".");
			System.out.println();
			cnt++;
		}
	}
}
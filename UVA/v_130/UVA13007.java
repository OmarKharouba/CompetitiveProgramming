package v_130;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
public class UVA13007 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		PrintWriter pw=new PrintWriter(System.out, true);
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int m=Integer.parseInt(sa[1]);
			int now=0,then=0;
			for(int i=0;i<m;i++){
				s=bf.readLine();
				sa=s.split(" ");
				int b=Integer.parseInt(sa[0]);
				int[]a=new int[n];
				int sum=0;
				for(int j=0;j<n;j++){
					a[j]=Integer.parseInt(sa[j+1]);
					sum+=a[j];
				}
				if(sum<=b)
					now+=a[0];
				sum-=a[0];
				for(int j=10000;j>0;j/=10){
					if(sum+j<=b){
						then+=j;
						break;
					}
				}
			}
			System.out.println(then-now);
		}
	}
}

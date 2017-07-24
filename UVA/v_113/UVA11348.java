package v_113;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
public class UVA11348 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df=new DecimalFormat("#0.000000");
		int k=Integer.parseInt(bf.readLine());
		for(int i=1;i<=k;i++){
			int n=Integer.parseInt(bf.readLine());
			boolean[][]a=new boolean[10001][n];
			for(int j=0;j<n;j++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				int m=Integer.parseInt(sa[0]);
				for(int h=0;h<m;h++){
					int x=Integer.parseInt(sa[h+1]);
					a[x][j]=true;
				}
			}
			int[]c=new int[n];
			double total=0;
			for(int j=0;j<10001;j++){
				int cnt=0,p=0;
				for(int h=0;h<n;h++){
					if(a[j][h]){
						cnt++;
						p=h;
					}
				}
				if(cnt==1){
					c[p]++;
					total++;
				}
			}
			System.out.print("Case "+i+":");
			for(int j=0;j<n;j++){
				double d=(c[j]/total)*100;
				System.out.print(" "+df.format(d)+"%");
			}
			System.out.println();
		}
	}
}

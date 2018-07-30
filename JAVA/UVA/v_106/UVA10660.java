package v_106;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10660 {
 	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			int[][]a=new int[5][5]; 
			int n=Integer.parseInt(bf.readLine());
			for(int j=0;j<n;j++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				int x=Integer.parseInt(sa[0]);
				int y=Integer.parseInt(sa[1]);
				int p=Integer.parseInt(sa[2]);
				a[x][y]=p;
			}
			int r1=0,r2=0,r3=0,r4=0,r5=0;
			int minmin=Integer.MAX_VALUE;
			for(int j1=0;j1<25;j1++)
				for(int j2=j1+1;j2<25;j2++)
					for(int j3=j2+1;j3<25;j3++)
						for(int j4=j3+1;j4<25;j4++)
							for(int j5=j4+1;j5<25;j5++){
								int sum=0;
								for(int k=0;k<25;k++){
									int d1=(Math.abs(j1/5-k/5)+Math.abs(j1%5-k%5))*a[k/5][k%5];
									int d2=(Math.abs(j2/5-k/5)+Math.abs(j2%5-k%5))*a[k/5][k%5];
									int d3=(Math.abs(j3/5-k/5)+Math.abs(j3%5-k%5))*a[k/5][k%5];
									int d4=(Math.abs(j4/5-k/5)+Math.abs(j4%5-k%5))*a[k/5][k%5];
									int d5=(Math.abs(j5/5-k/5)+Math.abs(j5%5-k%5))*a[k/5][k%5];
									int min=Math.min(Math.min(d1, Math.min(d2,d3)), Math.min(d4,d5));
									sum+=min;
								}
								if(sum<minmin){
									minmin=sum;
									r1=j1;
									r2=j2;
									r3=j3;
									r4=j4;
									r5=j5;
								}
							}
			System.out.println(r1+" "+r2+" "+r3+" "+r4+" "+r5);
		}
	} 
}

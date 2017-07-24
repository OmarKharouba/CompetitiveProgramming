package v_004;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
public class UVA441 {
 	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			if(n==0)
				break;
			if(cnt!=0)
				System.out.println();
			cnt++;
			int[]a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(sa[i+1]);
			}
			Arrays.sort(a);
			for(int i1=0;i1<n;i1++)
				for(int i2=i1+1;i2<n;i2++)
					for(int i3=i2+1;i3<n;i3++)
						for(int i4=i3+1;i4<n;i4++)
							for(int i5=i4+1;i5<n;i5++)
								for(int i6=i5+1;i6<n;i6++)
									System.out.println(a[i1]+" "+a[i2]+" "+a[i3]+" "+a[i4]+" "+a[i5]+" "+a[i6]);
		}
	}
}

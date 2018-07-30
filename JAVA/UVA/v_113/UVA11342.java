package v_113;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVA11342 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		int[]a=new int[225];
		for(int i=0;i<225;i++){
			a[i]=i*i;
		}
		StringBuilder sb=new StringBuilder();
		while(n-->0){
			String ans="-1";
			int x=Integer.parseInt(bf.readLine());
			boolean f=true;
			for(int i=0;i<225 && f;i++){
				for(int j=i;j<225 && f;j++){
					int z=x-(i*i+j*j);
					boolean flag=false;
					int start=0,end=224;
					while(start<=end){
						int mid=((start+end)>>1);
						if(a[mid]==z){
							flag=true;
							break;
						}else
							if(a[mid]<z)
								start=mid+1;
							else
								end=mid-1;
					}
					if(flag){
						ans=i+" "+j+" "+(int)Math.sqrt(z);
						f=false;
					}
				}
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
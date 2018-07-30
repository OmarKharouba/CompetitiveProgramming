package v_004;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA467 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		int cnt=1;
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			int[]a=new int[sa.length];
			int min=90;
			for(int i=0;i<a.length;i++){
				a[i]=Integer.parseInt(sa[i]);
				if(a[i]<min)
					min=a[i];
			}
			int r=-1;
			for(int i=1;i<=3600;i++){
				boolean flag=true;
				for(int j=0;j<a.length && flag;j++){
					if(i<min || i%(2*a[j])>=a[j]-5)
						flag=false;
				}
				if(flag){
					r=i;
					break;
				}
			}
			System.out.println((r==-1)? "Set "+cnt+" is unable to synch after one hour." : "Set "+cnt+" synchs again at "+(r/60)+" minute(s) and "+(r%60)+" second(s) after all turning green.");
			cnt++;
		}
	}
}
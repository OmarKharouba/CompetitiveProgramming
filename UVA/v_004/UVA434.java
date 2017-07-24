package v_004;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA434 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			int n=Integer.parseInt(bf.readLine());
			int[]a=new int[n];
			int[]b=new int[n];
			String s=bf.readLine();
			String[]sa=s.split(" ");
			String s2=bf.readLine();
			String[]sa2=s2.split(" ");
			for(int j=0;j<n;j++){
				a[j]=Integer.parseInt(sa[j]);
				b[j]=Integer.parseInt(sa2[j]);
			}
			int least=0,most=0;
			boolean[]c=new boolean[n];
			for(int j=0;j<n;j++){
				int samep=-1;
				for(int k=0;k<n;k++){
					most+=Math.min(b[j], a[k]);
					if(b[j]==a[k] && !c[k] && samep==-1)
						samep=k;
				}
				if(samep>=0)
					c[samep]=true;
				least+=b[j];	
			}
			for(int j=0;j<n;j++){
				if(!c[j])
					least+=a[j];
			}
			System.out.println("Matty needs at least "+least+" blocks, and can add at most "+(most-least)+" extra blocks.");
		}
	}
}
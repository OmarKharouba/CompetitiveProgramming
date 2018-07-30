package v_119;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11926 {
 	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int m=Integer.parseInt(sa[1]);
			if(n==0 && m==0)
				break;
			boolean[]a=new boolean[1000001];
			boolean flag=true;
			for(int i=0;i<n ;i++){
				s=bf.readLine();
				sa=s.split(" ");
				int start=Integer.parseInt(sa[0]);
				int end=Integer.parseInt(sa[1]);
				for(int j=start;j<end && flag;j++){
					if(a[j])
						flag=false;
					a[j]=true;
				}
			}
			for(int i=0;i<m ;i++){
				s=bf.readLine();
				sa=s.split(" ");
				int start=Integer.parseInt(sa[0]);
				int end=Integer.parseInt(sa[1]);
				int p=Integer.parseInt(sa[2]);
				for(int j=start;j<end && flag;j++){
					for(int k=j;k<a.length && flag;k+=p){
						if(a[k])
							flag=false;
						a[k]=true;
					}
				}
			}
			System.out.println((flag)? "NO CONFLICT" : "CONFLICT");
		}
	}
}
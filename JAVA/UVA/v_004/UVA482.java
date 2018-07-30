package v_004;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA482 {
	public static void main(String[]ar0gs)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			bf.readLine();
			String s=bf.readLine();
			String[]sa=s.split(" ");
			s=bf.readLine();
			String[]sa2=s.split(" ");
			String[]r=new String[sa.length];
			for(int j=0;j<sa.length;j++){
				int x=Integer.parseInt(sa[j]);
				r[x-1]=sa2[j];
			}
			for(int j=0;j<r.length;j++){
				System.out.println(r[j]);
			}
			if(i!=n-1)
				System.out.println();
		}
	}
}
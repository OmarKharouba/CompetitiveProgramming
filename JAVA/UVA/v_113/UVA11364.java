package v_113;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11364 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(bf.readLine());
		for(int i=0;i<x;i++){
			bf.readLine();
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int[]a=new int[sa.length];
			for(int j=0;j<a.length;j++){
				a[j]=Integer.parseInt(sa[j]);
			}
			int min=a[0];
			int max=a[0];
			for(int j=0;j<a.length;j++){
				if(a[j]>max)
					max=a[j];
				else
					if(a[j]<min)
						min=a[j];
			}
			System.out.println((max-min)*2);
		}
	}
}

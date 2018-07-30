package v_115;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11565 {
 	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		for(int h=0;h<n;h++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int a=Integer.parseInt(sa[0]);
			int b=Integer.parseInt(sa[1]);
			int c=Integer.parseInt(sa[2]);
			boolean flag=false;
			int x=0,y=0,z=0;
			for(int i=-100;i<=100 && !flag;i++){
				for(int j=-100;j<=100 && !flag;j++){
					x=i;
					y=j;
					z=a-x-y;
					if(x!=y && x!=z && y!=z && x+y+z==a && x*y*z==b && x*x+y*y+z*z==c){
						flag=true;
					}
				}
			}
			System.out.println((flag)? x+" "+y+" "+z : "No solution.");
		}
	} 
}

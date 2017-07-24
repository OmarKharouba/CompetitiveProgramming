package v_114;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11498 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(bf.readLine());
		while(x!=0){
			String r=bf.readLine();
			String[]ra=r.split(" ");
			int[]mn=new int[ra.length];
			for(int j=0;j<mn.length;j++){
				mn[j]=Integer.parseInt(ra[j]);
			}
			int m=mn[0],n=mn[1];
			for(int i=0;i<x;i++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				int[]a=new int[sa.length];
				for(int j=0;j<a.length;j++){
					a[j]=Integer.parseInt(sa[j]);
				}
				int X=a[0],Y=a[1];
				String out="divisa";
				if(X>m && Y>n)
					out="NE";
				else
					if(X>m && Y<n)
						out="SE";
					else
						if(X<m && Y>n)
							out="NO";
						else
							if(X<m && Y<n)
								out="SO";
				System.out.println(out);
			}
			x=Integer.parseInt(bf.readLine());
		}
	}
}

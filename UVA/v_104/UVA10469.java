package v_104;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10469 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			int x=Integer.parseInt(sa[0]);
			int y=Integer.parseInt(sa[1]);
			String xs=bin(x);
			String ys=bin(y);
			int[]z=new int[32];
			for(int i=0;i<32;i++){
				if(xs.charAt(i)==ys.charAt(i))
					z[i]=0;
				else
					z[i]=1;
			}
			int sum=0;
			for(int i=0;i<32;i++){
				if(z[31-i]==1)
					sum+=Math.pow(2,i);
			}
			System.out.println(sum);
		}
	}
	
	public static String bin(int x){
		String s="";
		while(x!=0){
			s=x%2+s;
			x=x/2;
		}
		while(s.length()<32){
			s="0"+s;
		}
		return s ;
	}
}

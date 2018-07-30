package v_101;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA10141 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int r=Integer.parseInt(sa[0]);
			int n=Integer.parseInt(sa[1]);
			if(r==0 && n==0)
				break;
			while(r-->0){
				bf.readLine();
			}
			String car="";
			int max=0;
			double price=Double.MAX_VALUE;
			while(n-->0){
				String name=bf.readLine();
				s=bf.readLine();
				sa=s.split(" ");
				double p=Double.parseDouble(sa[0]);
				int x=Integer.parseInt(sa[1]);
				if(x>max || (x==max && p<price)){
					max=x;
					price=p;
					car=name;
				}
				while(x-->0){
					bf.readLine();
				}
			}
			if(cnt>1)
				System.out.println();
			System.out.println("RFP #"+cnt);
			cnt++;
			System.out.println(car);
		}
	}
}
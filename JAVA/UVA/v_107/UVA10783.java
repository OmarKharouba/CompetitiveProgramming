package v_107;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10783 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			int x=Integer.parseInt(bf.readLine());
			int y=Integer.parseInt(bf.readLine());
			int sum=0;
			for(int j=x;j<=y;j++){
				if(j%2==1)
					sum+=j;
			}
			System.out.println("Case "+(i+1)+": "+sum);
		}
	}
}

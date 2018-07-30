package v_110;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA11044 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		for(int i=0;i<n;i++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int x=Integer.parseInt(sa[0]);
			int y=Integer.parseInt(sa[1]);
			System.out.println((x/3)*(y/3));
		}
	}
}


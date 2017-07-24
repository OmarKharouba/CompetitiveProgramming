package v_125;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA12577 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		while(true){
			String s=bf.readLine();
			if(s.equals("*"))
				break;
			if(s.equalsIgnoreCase("Hajj"))
				System.out.println("Case "+cnt+": Hajj-e-Akbar");
			else
				System.out.println("Case "+cnt+": Hajj-e-Asghar");
			cnt++;
		}
	}
}


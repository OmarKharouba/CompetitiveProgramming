package v_002;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UVA272{
	public static void main(String[] args)  throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s="";
		int c=0;
		while((s=bf.readLine())!=null){
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='"')
					if(c%2==0){
						s=s.substring(0, i)+"``"+s.substring(i+1,s.length());
						c++;
					}
					else{
						s=s.substring(0, i)+"``"+s.substring(i+1,s.length());
						c++;
					    }
			}
			System.out.println(s);
		}
	}
}
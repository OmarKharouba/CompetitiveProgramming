package v_128;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA12854 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			s=bf.readLine();
			String[]sa2=s.split(" ");
			boolean flag=true;
			for(int i=0;i<sa.length;i++)
				if(sa[i].equals(sa2[i]))
					flag=false;
			System.out.println(flag? "Y" : "N");
		}
	}
}
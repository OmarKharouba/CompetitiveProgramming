package v_122;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA12250 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String x=bf.readLine();
		int i=1;
		while(!x.equals("#")){
			String out="";
			switch(x){
			case "HELLO": out="ENGLISH" ; break;
			case "HALLO": out="GERMAN" ; break;
			case "HOLA": out="SPANISH" ; break;
			case "BONJOUR": out="FRENCH" ; break;
			case "CIAO": out="ITALIAN" ; break;
			case "ZDRAVSTVUJTE": out="RUSSIAN" ; break;
			default: out="UNKNOWN" ; break;
			}
			System.out.println("Case "+i+": "+out);
			x=bf.readLine();
			i++;
		}
	}
}

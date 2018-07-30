package v_017;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA1727 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int month=m(sa[0]);
			int day=d(sa[1]);
			int cnt=0;
			for(int j=0;j<month;j++){
				if((day+j)%7<2)
					cnt++;
			}
			System.out.println(cnt);
		}
	}
	
	public static int m(String month){
		switch(month){
		case "FEB": return 28;
		case "APR":
		case "JUN":
		case "SEP":
		case "NOV": return 30;
		default: return 31;
		}
	}
	
	public static int d(String day){
		switch(day){
		case "FRI": return 0; 
		case "SAT": return 1;
		case "SUN": return 2;
		case "MON": return 3;
		case "TUE": return 4;
		case "WED": return 5;
		default: return 6;
		}
	}
}

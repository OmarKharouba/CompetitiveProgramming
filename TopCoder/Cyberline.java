import java.util.Arrays;


public class Cyberline {
	public static void main(String[] args) {
		System.out.println(lastCyberword("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"));
	}
	
	public static 	String lastCyberword(String cyberline){
		String[] sa=cyberline.split("([^a-zA-Z0-9@-]+)");
		String ans="";
		for(int i=sa.length-1;i>=0;i--){
			String s=sa[i].replace("-", "");
			if(s.length()>0){
				ans=s;
				break;
			}
		}
		return ans;
	}
}

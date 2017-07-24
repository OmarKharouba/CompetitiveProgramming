package v_006;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA637 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			System.out.println("Printing order for "+n+" pages:");
			int start=1,end=n;
			end+=(4-(n%4))%4;
			for(int i=1;i<=(n+3)/4;i++){
				System.out.println("Sheet "+i+", front: "+((end>n)? "Blank" : end)+", "+((start==0)? "Blank" : start));
				start++;
				end--;
				if(start<=n)
				System.out.println("Sheet "+i+", back : "+((start==0)? "Blank" : start)+", "+((end>n)? "Blank" : end));
				start++;
				end--;
			}
		}
	}
}
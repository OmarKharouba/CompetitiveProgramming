package v_116;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA11683 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int h=Integer.parseInt(sa[0]);
			int n=Integer.parseInt(sa[1]);
			if(h==0 && n==0)
				break;
			int[]a=new int[n];
			s=bf.readLine();
			sa=s.split(" ");
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(sa[i]);
			}
			int cnt=h-a[0];
			for(int i=1;i<n;i++){
				if(a[i]<a[i-1])
					cnt+=(a[i-1]-a[i]);
			}
			System.out.println(cnt);
		}
	}
}


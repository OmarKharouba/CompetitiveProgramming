package v_116;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11679 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		String[]sa=s.split(" ");
		int b=Integer.parseInt(sa[0]);
		int n=Integer.parseInt(sa[1]);
		while(!(b==0&&n==0)){
			s=bf.readLine();
			sa=s.split(" ");
			int[]banks=new int[b];
			for(int i=0;i<b;i++){
				banks[i]=Integer.parseInt(sa[i]);
			}
			for(int i=0;i<n;i++){
				s=bf.readLine();
				sa=s.split(" ");
				int d=Integer.parseInt(sa[0]);
				int c=Integer.parseInt(sa[1]);
				int v=Integer.parseInt(sa[2]);
				banks[d-1]-=v;
				banks[c-1]+=v;
			}
			char result='S';
			for(int i=0;i<b;i++){
				if(banks[i]<0)
					result='N';
			}
			System.out.println(result);
			
			s=bf.readLine();
			sa=s.split(" ");
			b=Integer.parseInt(sa[0]);
			n=Integer.parseInt(sa[1]);
		}
	}
}

package v_017;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
public class UVA1726 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		PrintWriter pw=new PrintWriter(System.out, true);
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			int[] S=new int[11];
			int[] US=new int[11];
			int q=Integer.parseInt(bf.readLine());
			for(int j=0;j<q;j++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				int dif=Integer.parseInt(sa[0]);
				int stat=Integer.parseInt(sa[1]);
				char res=sa[2].charAt(0);
				if(res=='c' && stat==1)
					S[dif]++;
				else
					if(res=='i' && stat==0)
						US[dif]++;
			}
			int cnt=0;
			for(int j=1;j<11;j++){
				for(int k=1;k<j;k++){
					cnt+=(US[k]*S[j]);
				}
			}
			pw.println(cnt);
		}
	}
}

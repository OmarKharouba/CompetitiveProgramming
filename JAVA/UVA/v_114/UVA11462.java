package v_114;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class UVA11462 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		PrintWriter pw=new PrintWriter(System.out,true);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int []a=new int[101];
			for(int i=0;i<n;i++){
				a[Integer.parseInt(sa[i])]++;
			}
			int cnt=0;
			StringBuilder sb=new StringBuilder();
			for(int i=1;i<=100;i++){
				for(int j=0;j<a[i];j++){
					if(cnt==0)
						sb.append(i);
					else
						sb.append(" "+i);
					cnt=1;
				}
			}
			pw.println(sb.toString());
		}
	}
}
package v_130;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
public class UVA13012 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		PrintWriter pw=new PrintWriter(System.out, true);
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			int n=Integer.parseInt(s);
			s=bf.readLine();
			String[]sa=s.split(" ");
			int r=0;
			for(int i=0;i<5;i++){
				int x=Integer.parseInt(sa[i]);
				if(x==n)
					r++;
			}
			System.out.println(r);
		}
	}
}

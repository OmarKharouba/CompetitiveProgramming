package v_130;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA13026 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			int n=Integer.parseInt(bf.readLine());
			String[] a=new String[n];
			for(int j=0;j<n;j++){
				a[j]=bf.readLine();
			}
			String num=bf.readLine();
			System.out.println("Case "+(i+1)+":");
			for(int j=0;j<n;j++){
				boolean flag=num.length()==a[j].length();
				int c=0;
				for(int k=0;k<a[j].length() && flag;k++){
					if(num.charAt(k)!=a[j].charAt(k))
						c++;
					if(c>1)
						flag=false;
				}
				if(flag)
					System.out.println(a[j]);
			}
		}
	}
}

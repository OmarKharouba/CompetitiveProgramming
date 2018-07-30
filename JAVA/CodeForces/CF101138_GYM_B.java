import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class CF101138_GYM_B {
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
			String s=br.readLine();
			if(s.length()==1)
				pw.println("YES");
			else{
				int n=s.length();
				boolean ok=Integer.bitCount(n)==1;
				if(ok)
					for(int i=0;i<n;i+=2){
						if(s.charAt(i)=='A' && s.charAt(i+1)=='A')
							ok=false;
					}
				pw.println(ok? "YES" : "NO");
			}
		}
		pw.flush();
		pw.close();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;


public class CF100495_GYM_K {
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		DecimalFormat df=new DecimalFormat("0.000000000");
		int t=Integer.parseInt(br.readLine());
		int id=1;
		while(t-->0){
			String [] sa=br.readLine().split(" ");
			long x=Integer.parseInt(sa[0]);
			long y=Integer.parseInt(sa[1]);
			long r=Integer.parseInt(sa[2]);
			sa=br.readLine().split(" ");
			long x2=Integer.parseInt(sa[0]);
			long y2=Integer.parseInt(sa[1]);
			long r2=Integer.parseInt(sa[2]);
			double d=(x-x2)*(x-x2)+(y-y2)*(y-y2);
			double ans=0;
			if(d>=(r+r2)*(r+r2))
				ans=Math.PI*r*r;
			else{
				ans=Math.PI*r*r;
				if(r>=r2 && d<=(r-r2)*(r-r2)){
					ans-=Math.PI*r2*r2;
				}else
					if(r2>=r && d<=(r2-r)*(r2-r)){
						ans=0;
					}else{
						double a=2*Math.acos((r*r+d-r2*r2)/(2*r*Math.sqrt(d)));
						double b=2*Math.acos((-r*r+d+r2*r2)/(2*r2*Math.sqrt(d)));
						double ar1=0.5*b*r2*r2-0.5*r2*r2*Math.sin(b);
						double ar2=0.5*a*r*r-0.5*r*r*Math.sin(a);
						ans-=(ar1+ar2);
					}
			}
			pw.printf("Case #%d: ",(id++));
			pw.println(df.format(ans));
		}
		pw.flush();
		pw.close();
	}
}
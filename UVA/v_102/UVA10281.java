package v_102;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class UVA10281 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		DecimalFormat df=new DecimalFormat("0.00");
		long speed=0;
		long lastT=0;
		double lastD=0;
		long time=0;
//		int t=2;
//		while(t-->0){
		while(sc.br.ready()){
			String s=sc.nextLine();
			String [] sa=s.split(" ");
			String [] tt=sa[0].split(":");
			time=Integer.parseInt(tt[0])*3600+Integer.parseInt(tt[1])*60+Integer.parseInt(tt[2]);
			if(sa.length==2){
				long dt=time-lastT;
				double dis=speed*dt/3600.0;
				lastD+=dis;
				lastT=time;
				speed=Integer.parseInt(sa[1]);
			}else{
				long dt=time-lastT;
				double dis=speed*dt/3600.0;
				pw.println(sa[0]+" "+df.format(lastD+dis)+" km");
			}
		}
		
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}

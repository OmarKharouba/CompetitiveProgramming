package v_002;
import java.io.*;
import java.util.*;
public class UVA256 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		String [][] arr=new String [4][];
//		for(int i=0;i<=99999999;i++){
//			for(int j=0;j<4;j++){
//				String s=f(""+i,2*(j+1));
//				if(s.length()>0)
//					arr[j].add(s);
//			}
//		}
		
		String [] a2={"00","01","81"};
		arr[0]=a2;
		String [] a4={"0000","0001","2025","3025","9801"};
		arr[1]=a4;
		String [] a6={"000000","000001","088209","494209","998001"};
		arr[2]=a6;
		String [] a8={"00000000","00000001","04941729","07441984","24502500","25502500","52881984","60481729","99980001"};
		arr[3]=a8;
		
		while(sc.br.ready()){
			int n=sc.nextInt()/2-1;
			for(String s : arr[n])
				pw.println(s);
		}
		
		pw.flush();
		pw.close();
	}
	
	public static String f(String s,int b){
		if(s.length()>b)
			return "";
		while(s.length()<b)
			s="0"+s;
		long ans=0L;
		ans+=Integer.parseInt(s.substring(0, s.length()/2));
		ans+=Integer.parseInt(s.substring(s.length()/2));
		if(ans*ans==Integer.parseInt(s))
			return s;
		return "";
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

package v_008;
import java.io.*;
import java.util.*;
public class UVA834 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		while(sc.br.ready()){
			int x=sc.nextInt();
			int y=sc.nextInt();
			ArrayList<Integer> ans=new ArrayList<Integer>();
			while(x!=1){
				ans.add(x/y);
				x%=y;
				int tmp=x;
				x=y;
				y=tmp;
			}
			if(y>0)
				ans.add(y);
			if(ans.size()==1)
				ans.add(0, 0);
			pw.print("["+ans.get(0));
			for(int i=1;i<ans.size();i++)
				if(i==1)
					pw.print(";"+ans.get(i));
				else
					pw.print(","+ans.get(i));
			pw.println("]");
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

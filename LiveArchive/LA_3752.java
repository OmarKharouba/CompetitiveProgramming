package LiveArchive;
import java.io.*;
import java.util.*;

public class LA_3752 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		while(true){
			String s=sc.next();
			if(s.equals("end"))
				break;
			int cnt=0;
			char [] top=new char [26];
			for(char c : s.toCharArray()){
				boolean done=false;
				for(int i=0;i<cnt;i++)
					if(c<=top[i]){
						done=true;
						top[i]=c;
						break;
					}
				if(!done)
					top[cnt++]=c;
			}
			pw.println("Case "+(id++)+": "+cnt);
		}
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	    	  try {
	    		  br=new BufferedReader(new FileReader(new File("test.in")));
			} catch (Exception e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
}

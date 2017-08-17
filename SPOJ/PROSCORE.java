import java.io.*;
import java.util.*;
public class PROSCORE {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		int id=1;
		while(t-->0){
			int n=sc.nextInt();
			int m=sc.nextInt();
			boolean [][] a=new boolean [n][m];
			int [] c=new int [n];
			int [] cp=new int [m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++){
					a[i][j]=sc.nextInt()==1;
					if(a[i][j]){
						c[i]++;
						cp[j]++;
					}
				}
			boolean c1=true,c2=true,c3=true;
			for(int i=0;i<m;i++)
				if(cp[i]==0)
					c1=false;
			for(int i=0;i<n;i++){
				if(c[i]==0)
					c2=false;
				if(c[i]==m)
					c3=false;
			}
			int ans=0;
			if(c1)
				ans+=4;
			if(c2)
				ans+=2;
			if(c3)
				ans++;
			pw.println("Case "+(id++)+": "+ans);
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

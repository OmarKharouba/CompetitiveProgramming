package v_001;
import java.io.*;
import java.util.*;
public class UVA111 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=Integer.parseInt(sc.nextLine());
		while(sc.br.ready()){
			int [] a=new int [n];
			int [] lis=new int [n];
			String [] sa=sc.nextLine().split(" ");
			for(int i=0;i<n;i++)
				a[Integer.parseInt(sa[i])-1]=i+1;
			int [] c=new int [n];
			for(int i=0;i<n;i++)
				c[a[i]-1]=i;
			while(sc.br.ready()){
				sa=sc.nextLine().split(" ");
				if(sa.length==1){
					n=Integer.parseInt(sa[0]);
					break;
				}
				int [] b=new int [n];
				for(int i=0;i<n;i++)
					b[Integer.parseInt(sa[i])-1]=i+1;
				int max=0;
				for(int i=0;i<n;i++){
					lis[i]=1;
					for(int j=0;j<i;j++)
						if(c[b[j]-1]<c[b[i]-1] && lis[j]+1>lis[i])
							lis[i]=lis[j]+1;
					max=Math.max(max, lis[i]);
				}
				pw.println(max);
			}
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

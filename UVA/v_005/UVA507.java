package v_005;
import java.io.*;
import java.util.*;
public class UVA507 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new  StringBuilder();
		int id=1;
		int t =sc.nextInt();
		while(t-->0){
			int n=sc.nextInt()-1;
			int []a=new int [n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			
			long max=Long.MIN_VALUE;
			int x=0,y=0;
			
			long tmp=0;
			int xt=0,yt=0;
			
			
			for(int i=0;i<n;i++){
				tmp+=a[i];
				yt++;
				if(tmp<0){
					tmp=0;
					xt=i+1;
					yt=i+1;
				}else
					if(tmp>max || (tmp==max && yt-xt>y-x) || (tmp==max && yt-xt==y-x && xt+1<x)){
						max=tmp;
						x=xt+1;
						y=yt+1;
					}
				
			}
			
			

//			
//			for(int i=0;i<n;i++){
//				for(int j=i;j<n;j++){
//					long tmp=a[j];
//					if(i>0)
//						tmp-=a[i-1];
//					if(tmp>max || (tmp==max && j-i+1>y-x) || (tmp==max && j-i+1==y-x && i+1<x)){
//						max=tmp;
//						x=i+1;
//						y=j+2;
//					}
//				}
//			}
			
			
			if(max>0)
				pw.println("The nicest part of route "+id+" is between stops "+x+" and "+y);
			else
				pw.println("Route "+id+" has no nice parts");
			id++;
		}
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
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
	      
	      boolean ready()throws Exception{
	    	  return br.ready();
	      }

	   }
}

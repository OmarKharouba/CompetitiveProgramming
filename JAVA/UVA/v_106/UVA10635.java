package v_106;
import java.io.*;
import java.util.*;
public class UVA10635 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		int id=1;
		int t=sc.nextInt();
		while(t-->0){
			int d=sc.nextInt();
			int n=sc.nextInt()+1;
			int m=sc.nextInt()+1;
			first=new int [d*d];
			Arrays.fill(first, -1);
			int [] b=new int [m];
			for(int i=0;i<n;i++)
				first[sc.nextInt()-1]=i;
			for(int i=0;i<m;i++)
				b[i]=sc.nextInt();
			pw.printf("Case %d: %d\n", id++, lis(b,m));
		}
		
		pw.flush();
		pw.close();
	}
	static int [] first;
	
	public static int lis(int [] a,int n){
		ArrayList<Integer> l=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			int idx=first[a[i]-1];
			if(idx==-1)
				continue;
			int pos=Collections.binarySearch(l, idx);
			if(pos<0)
				pos=-(pos+1);
			if(pos>=l.size())
				l.add(idx);
			else
				l.set(pos, idx);
		}
		return l.size();
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

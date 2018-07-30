package v_105;
import java.io.*;
import java.util.*;
public class UVA10534 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(sc.br.ready()){
			int n=sc.nextInt();
			int [] a=new int [n];
			int [] b=new int [n];
			for(int i=0;i<n;i++)
				b[n-1-i]=a[i]=sc.nextInt();
			int [] left=lis(a,false);
			int [] right=lis(b,true);
			int max=0;
			for(int i=0;i<n;i++)
				max=Math.max(max, 2*Math.min(right[i], left[i])-1);
			pw.println(max);
		}
		
		pw.flush();
		pw.close();
	}
	
	public static int[] lis(int [] a,boolean rev){
		int n=a.length;
		int[] lis=new int [n];
		ArrayList<Integer> l=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			int pos=Collections.binarySearch(l, a[i]);
			if(pos<0)
				pos=-(pos+1);
			if(pos>=l.size())
				l.add(a[i]);
			else
				l.set(pos, a[i]);
			if(!rev)
				lis[i]=l.size();
			else
				lis[n-1-i]=l.size();
		}
		return lis;
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

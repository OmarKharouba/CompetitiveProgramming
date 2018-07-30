package v_106;
import java.io.*;
import java.util.*;
public class UVA10664 {
	static int n;
	static int total;
	static int [] a;
	static Boolean [][] mem;
	public static void main(String[]args)throws Throwable{
		PrintWriter pw=new PrintWriter(System.out,true);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			String s=bf.readLine();
			String []sa=s.split(" ");
			n=sa.length;
			a=new int [n];
			total=0;
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(sa[i]);
				total+=a[i];
			}
			boolean flag=(total%2==0);
			if(flag){
				mem=new Boolean [n][4001];
				flag=dp(0,0);
			}
			pw.println(flag? "YES" : "NO");
		}
		
		pw.flush();
		pw.close();
	}
	
	public static boolean dp(int i,int sum){
		
		if(i==n){
			if(sum*2==total)
				return true;
			return false;
		}
		
		if(mem[i][sum]!=null)
			return mem[i][sum];
		
		boolean ans=false;
		ans |=dp(i+1,sum);
		ans |=dp(i+1,sum+a[i]);
		
		
		return mem[i][sum]=ans;
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

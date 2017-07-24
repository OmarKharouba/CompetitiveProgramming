package v_118;
import java.io.*;
import java.util.*;
public class UVA11888 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String rev=new StringBuilder(s).reverse().toString();
			int [] pre=compute_z((s+"$"+rev).toCharArray());
			int [] post=compute_z((rev+"$"+s).toCharArray());
			
			boolean alindrome=false;
			for(int i=0;i<s.length()-1;i++){
				if(pre[n-i-1]==i+1){
					int j=s.length()-i-2;
					if(post[n-j-1]==j+1)
						alindrome=true;
				}
			}
			boolean palindrome=pre[s.length()+1]==s.length();
			pw.println(alindrome? "alindrome" : palindrome? "palindrome" : "simple");
		}
		
		pw.flush();
		pw.close();
	}
	static int n;
	static int [] compute_z(char [] s){
		n=s.length;
		int [] z=new int [n];
		int l=0,r=0,k=0;
		
		for(int i=1;i<n;i++){
			if(i>r){
				l=r=i;
				while(r<n && s[r-l]==s[r])
					r++;
				z[i]=r-l;
				r--;
			}else{
				k=i-l;
				if(z[k]<r-i+1)
					z[i]=z[k];
				else{
					l=i;
					while(r<n && s[r-l]==s[r])
						r++;
					z[i]=r-l;
					r--;
				}				
			}
		}
		return z;
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

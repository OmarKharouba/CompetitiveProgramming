package v_102;
import java.io.*;
import java.util.*;
public class UVA10298 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		while(true){
			String s=sc.nextLine();
			if(s.equals("."))
				break;
			int [] z=compute_z(s.toCharArray());
			ArrayList<Integer> d=new ArrayList<Integer>();
			for(int i=1;1L*i*i<=n;i++)
				if(n%i==0){
					d.add(i);
					if(n/i!=i)
						d.add(n/i);
				}
			Collections.sort(d);
//			System.out.println(Arrays.toString(z));
			int ans=n;
			for(int i : d){
				boolean f=true;
				for(int j=i;j<n;j+=i)
					if(z[j]<i)
						f=false;
				if(f){
					ans=i;
					break;
				}
			}
			pw.println(n/ans);
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

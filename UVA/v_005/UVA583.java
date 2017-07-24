package v_005;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class UVA583 {
	static ArrayList<Integer> primes;
	public static void main(String[]args)throws IOException,NumberFormatException{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new StringBuilder();
		sieve(100000);
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			sb.append(n+" = "+((n<0)? "-1":""));
			boolean first=n>0;
			n=Math.abs(n);
			int i=0,j=primes.get(i);
			while(1L*j*j<=n){
				while(n%j==0){
					n/=j;
					sb.append((first? "" : " x ")+j);
					first=false;
				}
				j=primes.get(++i);
			}
			if(n>1)
				sb.append((first? "" : " x ")+n);
			sb.append("\n");
		}
		pw.print(sb);
		pw.flush();
		pw.close();
	}
	
	public static void sieve(int n){
		boolean[]composit=new boolean[n];
		primes=new ArrayList<Integer>(n/10);
		for(int i=2;i<n;i++){
			if(!composit[i]){
				primes.add(i);
				if(1L*i*i<n)
					for(int j=i*i;j<n;j+=i)
						composit[j]=true;
			}
		}
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

	   }
}

package v_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA160 {
	static ArrayList<Integer> primes;
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		StringBuilder sb=new StringBuilder();
		primes=new ArrayList<Integer>();
		sieve(101);
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			ArrayList<Integer> c=new ArrayList<Integer>();
			for(int i=0;i<primes.size();i++){
				int x=maxpowerprime(primes.get(i), n);
				c.add(x);
			}
			for(int i=c.size()-1;i>=0;i--)
				if(c.get(i)==0)
					c.remove(i);
				else
					break;
			sb.append((n<10? "  " : (n<100? " " : ""))+n+"! =");
			for(int i=0;i<c.size();i++){
				if(i==15)
					sb.append("\n      ");
				sb.append((c.get(i)<10? "  " : " ")+c.get(i));
			}
			sb.append("\n");
		}
		pw.print(sb);
		pw.flush();
		pw.close();
	}
	
	public static int maxpowerprime(int p,int n){
		int cnt=0;
		for(int i=p;i<=n;i*=p)
			cnt+=n/i;
		return cnt;
	}
	
	public static void sieve(int n){
		boolean[] prime=new boolean[n];
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		for(int i=2;i*i<=n;i++){
			if(prime[i]){
				for(int j=i*i;j<n;j+=i){
					prime[j]=false;
				}
			}
		}
		for(int i=2;i<n;i++)
			if(prime[i])
				primes.add(i);
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

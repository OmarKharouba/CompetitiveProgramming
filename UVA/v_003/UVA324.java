package v_003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA324 {
	static ArrayList<Integer> primes;
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		StringBuilder sb=new StringBuilder();
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			int [] a=new int [1000];
			a[0]=1;
			for(int i=2;i<=n;i++){
				int carry=0;
				for(int j=0;j<1000;j++){
					int x=a[j]*i+carry;
					a[j]=x%10;
					carry=x/10;
				}
			}
			int i=999;
			while(a[i]==0)
				i--;
			int [] cnt=new int[10];
			while(true){
				cnt[a[i]]++;
				i--;
				if(i<0)
					break;
			}
			sb.append(n+"! --\n");
			for(int j=0;j<10;j++){
				sb.append((j%5==0? "   (" : "    (")+j+")"+(cnt[j]<10? "    " : (cnt[j]<100? "   " : "  "))+cnt[j]);
				if(j==4 || j==9)
					sb.append("\n");
			}
		}
		pw.print(sb);
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

	   }

}

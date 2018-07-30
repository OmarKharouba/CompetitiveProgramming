package v_011;
import java.io.*;
import java.util.*;
public class UVA1197 {
	static int n;
	static int[]p;
	static int[]r;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		while(true){
			n=sc.nextInt();
			int m=sc.nextInt();
			if(n==0 && m==0)
				break;
			p=new int[n];
			r=new int[n];
			for(int i=0;i<n;i++)
				p[i]=i;
			while(m-->0){
				int k=sc.nextInt()-1;
				int first=sc.nextInt();
				while(k-->0)
					union(first, sc.nextInt());
			}
			int ans=0;
			for(int i=0;i<n;i++)
				if(find(i)==find(0))
					ans++;
			System.out.println(ans);
		}
	}
	
	static void union(int i,int j){
		int x=find(i);
		int y=find(j);
		if(r[x]>r[y]){
			p[y]=x;
		}else{
			p[x]=y;
			if(r[x]==r[y])
				r[y]++;
		}
	}
	
	static int find(int x){
		if(p[x]==x)
			return x;
		return p[x]=find(p[x]);
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

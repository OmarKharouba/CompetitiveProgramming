package v_105;
import java.io.*;
import java.util.*;
public class UVA10505 {
	static int n;
	static int[]p;
	static int[]r;
	static int[]e;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		int t=sc.nextInt();
		while(t-->0){
			n=sc.nextInt();
			p=new int[n];
			r=new int[n];
			e=new int[n];
			for(int i=0;i<n;i++){
				p[i]=i;
				e[i]=-1;
			}
			for(int i=0;i<n;i++){
				int m=sc.nextInt();
				while(m-->0){
					int k=sc.nextInt()-1;
					enemy(i,k);
				}
			}
			int[]c=new int[n];
			boolean[]v=new boolean[n];
			int ans=0;
			for(int i=0;i<n;i++)
				c[find(i)]++;
			for(int i=0;i<n;i++){
				int x=find(i);
				int y=0;
				if(e[x]!=-1)
					y=find(e[x]);
				if(!v[x] && !v[y]){
					v[x]=true;
					v[y]=true;
					ans+=Math.max(c[x], c[y]);
				}
			}
			System.out.println(ans);
		}
	}
	
	static void enemy(int i,int j){
		int x=find(i);
		int y=find(j);
		if(e[x]!=-1)
			union(find(e[x]),y);
		if(e[y]!=-1)
			union(find(e[y]),x);
		e[x]=y;
		e[y]=x;
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

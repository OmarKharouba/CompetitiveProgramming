package v_121;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class UVA12160 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		int cnt=1;
		while(true){
			int x=sc.nextInt();
			int y=sc.nextInt();
			int n=sc.nextInt();
			if(y==0 && x==0 && n==0)
				break;
			int[]a=new int[n];
			boolean[]v=new boolean[10000];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			Queue<pair> q=new LinkedList<pair>();
			q.add(new pair(x,0));
			v[x]=true;
			long ans=-1;
			while(!q.isEmpty()){
				pair p=q.poll();
				if(p.value==y){
					ans=p.cnt;
					break;
				}
				for(int i=0;i<n;i++){
					int z=(p.value+a[i])%10000;
					if(!v[z]){
						v[z]=true;
						q.add(new pair(z,p.cnt+1));
					}
				}
			}
			pw.println("Case "+cnt+": "+((ans==-1)? "Permanently Locked" : ans));
			cnt++;
		}
		pw.flush();
		pw.close();
	}
	
	static class pair{
		int value;
		int cnt;
		pair(int v,int c){
			value=v;
			cnt=c;
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
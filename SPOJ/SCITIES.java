import java.io.*;
import java.util.*;
public class SCITIES {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int m=sc.nextInt();
			N=M=Math.max(n, m);
			init();
			while(true){
				int u=sc.nextInt();
				int v=sc.nextInt();
				int g=sc.nextInt();
				if(u==0 && v==0 && g==0)
					break;
				a[u][v]=-g;
			}
			hungarian();
			int res=0;
			for(int i=1;i<=N;i++)
				res+=-a[i][ans[i]];
			pw.println(res);
		}
		
		pw.flush();
		pw.close();
	}
	
	static int N,M;
	static int inf=(int)1e8;
	static int [][] a;
	static int [] u,v,p,way,minv,ans;
	static boolean [] used;
	
	static void init(){
		a=new int [N+1][M+1];
		u=new int [N+1];
		ans=new int [N+1];
		v=new int [M+1];
		p=new int [M+1];
		way=new int [M+1];
		minv=new int [M+1];
		used=new boolean [M+1];
	}
	
	static void hungarian(){
		for(int i=1;i<=N;i++){
			p[0]=i;
			int j0=0;
			Arrays.fill(minv, inf);
			Arrays.fill(used, false);
			do {
				used[j0]=true;
				int i0=p[j0],delta=inf,j1=0;
				for(int j=1;j<=M;j++)
					if(!used[j]){
						int cur=a[i0][j]-u[i0]-v[j];
						if(cur<minv[j]){
							minv[j]=cur;
							way[j]=j0;
						}
						if(minv[j]<delta){
							delta=minv[j];
							j1=j;
						}
					}
				for(int j=0;j<=M;j++)
					if(used[j]){
						u[p[j]]+=delta;
						v[j]-=delta;
					}
					else
						minv[j]-=delta;
				j0=j1;
			} while (p[j0]!=0);
			do {
				int j1=way[j0];
				p[j0]=p[j1];
				j0=j1;
			} while (j0!=0);
		}
		for(int j=1;j<=M;j++)
			ans[p[j]]=j;
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

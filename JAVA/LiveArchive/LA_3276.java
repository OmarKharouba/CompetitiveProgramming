package LiveArchive;
import java.io.*;
import java.util.*;
public class LA_3276 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		while(true){
			N=sc.nextInt();
			int [] x=new int [N];
			int [] y=new int [N];
			for(int i=0;i<N;i++){
				x[i]=sc.nextInt();
				y[i]=sc.nextInt();
			}
			if(N==0)
				break;
			M=N;
			int min=inf;
			for(int row=1;row<=N;row++){
				init();
				for(int j=0;j<N;j++)
					for(int col=1;col<=N;col++){
						a[j+1][col]=Math.abs(x[j]-row)+Math.abs(y[j]-col);
					}
				hungarian();
				min=Math.min(min, -v[0]);
				init();
				for(int j=0;j<N;j++)
					for(int col=1;col<=N;col++){
						a[j+1][col]=Math.abs(x[j]-col)+Math.abs(y[j]-row);
					}
				hungarian();
				min=Math.min(min, -v[0]);
			}
			init();
			for(int j=0;j<N;j++)
				for(int col=1;col<=N;col++){
					a[j+1][col]=Math.abs(x[j]-col)+Math.abs(y[j]-col);
				}
			hungarian();
			min=Math.min(min, -v[0]);
			init();
			for(int j=0;j<N;j++)
				for(int col=1;col<=N;col++){
					a[j+1][col]=Math.abs(x[j]-col)+Math.abs(y[j]-(N+1-col));
				}
			hungarian();
			min=Math.min(min, -v[0]);
			
			pw.printf("Board %d: %d moves required.\n\n",(id++),min);
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

import java.io.*;
import java.util.*;
public class RDNWK {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		int id=1;
		int inf=(int)1e8;
		while(t-->0){
			int n=sc.nextInt();
			int [][][] dis=new int [n+1][n][n];
			for(int [][] a : dis)
				for(int [] b : a)
					Arrays.fill(b, inf);
			for(int i=0;i<n;i++){
				dis[0][i][i]=0;
				for(int j=i+1;j<n;j++){
					int c=sc.nextInt();
					if(c!=-1){
						dis[0][i][j]=dis[0][j][i]=c;
					}
				}
			}
			int p=sc.nextInt();
			int [] ranking =new int [p];
			for(int i=0;i<p;i++)
				ranking[i]=sc.nextInt()-1;
			for(int h = 1; h <= p; h++){
				int k=ranking[h-1];
				for(int i = 0; i < n; i++)
					for(int j = 0; j < n; j++)
						dis[h][i][j]=dis[h-1][i][j];
				for(int i = 0; i < n; i++)
					for(int j = 0; j < n; j++)
						if(dis[h][i][j]>dis[h-1][i][k]+dis[h-1][k][j])
							dis[h][i][j]=dis[h-1][i][k]+dis[h-1][k][j];
			}
			int q=sc.nextInt();
			pw.print("Case "+(id++)+":");
			while(q-->0){
				int h=sc.nextInt();
				int u=sc.nextInt()-1;
				int v=sc.nextInt()-1;
				if(dis[h][u][v]<inf)
					pw.print(" "+dis[h][u][v]);
				else
					pw.print(" -1");
			}
			pw.println();
		}
		
		pw.flush();
		pw.close();
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

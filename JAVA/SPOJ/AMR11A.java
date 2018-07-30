import java.io.*;
import java.util.*;
public class AMR11A {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int m=sc.nextInt();
			int [][] a=new int [n][m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					a[i][j]=sc.nextInt();
			int start=0,end=(int)(1e6+1),ans=-1;
			while(start<=end){
				int mid=((start+end)>>1);
				int [][] b=new int [n][m];
				boolean [][] ok=new boolean [n][m];
				b[0][0]=a[0][0]+mid;
				ok[0][0]=b[0][0]>0;
				boolean can=b[0][0]>0;
				for(int i=0;i<n;i++)
					for(int j=0;j<m;j++){
						if(i==0 && j==0)
							continue;
						b[i][j]=a[i][j];
						int max=(int)-(1e9+5);
						if(i>0 && ok[i-1][j])
							max=b[i-1][j];
						if(j>0 && ok[i][j-1])
							max=Math.max(max, b[i][j-1]);
						b[i][j]+=max;
						if(b[i][j]>0)
							ok[i][j]=true;
					}
				can &=ok[n-1][m-1];
				if(can){
					ans=mid;
					end=mid-1;
				}else{
					start=mid+1;
				}
			}
			pw.println(ans);
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

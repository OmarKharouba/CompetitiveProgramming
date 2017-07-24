package v_106;
import java.io.*;
import java.util.*;
public class UVA10604 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		int t=sc.nextInt();
		while(t-->0){
			n=sc.nextInt();
			a=new int [n][n];
			b=new int [n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++){
					a[i][j]=sc.nextInt()-1;
					b[i][j]=sc.nextInt();
				}
			int k=sc.nextInt();
			int [] c=new int [6];
			for(int i=0;i<k;i++)
				c[sc.nextInt()-1]++;
			sc.next();
			mem=new int [11][11][11][11][11][11];
			for(int [][][][][] a : mem)
				for(int [][][][] b : a)
					for(int [][][] d : b)
						for(int [][] e : d)
							for(int [] f : e)
								Arrays.fill(f, -1);
			pw.println(dp(c[0],c[1],c[2],c[3],c[4],c[5],k));
		}
		
		pw.flush();
		pw.close();
	}
	static int [][][][][][] mem;
	static int n;
	static int [][] a,b;
	static int inf=(int)1e8;
	public static int dp(int c1,int c2,int c3,int c4,int c5,int c6,int total){
		if(total==1)
			return 0;
		if(mem[c1][c2][c3][c4][c5][c6]!=-1)
			return mem[c1][c2][c3][c4][c5][c6];
		int ans=inf;
		int [] c={c1,c2,c3,c4,c5,c6};
//		System.out.println(Arrays.toString(c));
		for(int i=0;i<n;i++)
			if(c[i]>1){
				c[i]-=2;
				c[a[i][i]]++;
				ans=Math.min(ans, b[i][i]+dp(c[0], c[1], c[2], c[3], c[4], c[5], total-1));
				c[i]+=2;
				c[a[i][i]]--;
			}
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(i!=j && c[i]>0 && c[j]>0){
					c[i]--;
					c[j]--;
					c[a[i][j]]++;
					ans=Math.min(ans, b[i][j]+dp(c[0], c[1], c[2], c[3], c[4], c[5], total-1));
					c[i]++;
					c[j]++;
					c[a[i][j]]--;
				}
		
		
		return mem[c1][c2][c3][c4][c5][c6]=ans;
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
	      
	      boolean ready()throws Exception{
	    	  return br.ready();
	      }

	   }
}

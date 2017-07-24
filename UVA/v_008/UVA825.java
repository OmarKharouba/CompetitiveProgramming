package v_008;

import java.io.*;
import java.util.*;
public class UVA825 {
	static int n;
	static int m;
	static boolean [][] block;
	static int [][] mem;
	public static void main(String[]args)throws Throwable{
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new StringBuilder();
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			bf.readLine();
			String s=bf.readLine();
			String[]sa=s.split(" ");
			n=Integer.parseInt(sa[0]);
			m=Integer.parseInt(sa[1]);
			block=new boolean[n][m];
			mem=new int[n][m];
			for(int i=0;i<n;i++){
				Arrays.fill(mem[i], -1);
				s=bf.readLine();
				sa=s.split(" ");
				int x=Integer.parseInt(sa[0])-1;
				for(int j=1;j<sa.length;j++){
					int y=Integer.parseInt(sa[j])-1;
					block[x][y]=true;
				}
			}
			pw.println(dp(0,0));
			if(t>0)
				pw.println();
		}
		pw.print(sb);
		pw.flush();
		pw.close();
	}
	
	public static int dp(int r,int c){
		if(r==n-1 && c==m-1)
			return 1;
		if(mem[r][c]!=-1)
			return mem[r][c];
		int ans=0;
		if(valid(r,c+1))
			ans+=dp(r, c+1);
		if(valid(r+1,c))
			ans+=dp(r+1, c);
		return mem[r][c]=ans;
	}
	
	public static boolean valid(int r,int c){
		return (r>=0 && r<n && c>=0 && c<m && !block[r][c]);
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

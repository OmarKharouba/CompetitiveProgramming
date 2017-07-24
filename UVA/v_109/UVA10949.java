package v_109;
import java.io.*;
import java.util.*;
public class UVA10949 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int id=1;
		int t=Integer.parseInt(sc.nextLine());
		while(t-->0){
			String [] sa=sc.nextLine().split(" ");
			int R=Integer.parseInt(sa[0]);
			int C=Integer.parseInt(sa[1]);
			char [][] grid=new char [R][C];
			for(int i=0;i<R;i++)
				grid[i]=sc.nextLine().toCharArray();
			sa=sc.nextLine().split(" ");
			int x1=Integer.parseInt(sa[1])-1;
			int y1=Integer.parseInt(sa[2])-1;
			StringBuilder sb=new StringBuilder(""+grid[x1][y1]);
			String dir=sc.nextLine();
			for(char c : dir.toCharArray()){
				switch (c) {
				case 'E':{
					y1++;
					break;
				}
				case 'W':{
					y1--;
					break;
				}
				case 'N':{
					x1--;
					break;
				}
				case 'S':{
					x1++;
					break;
				}
				default:
					break;
				}
				sb.append(grid[x1][y1]);
			}
			char [] a=sb.toString().toCharArray();
			int n=a.length;
			sa=sc.nextLine().split(" ");
			x1=Integer.parseInt(sa[1])-1;
			y1=Integer.parseInt(sa[2])-1;
			sb=new StringBuilder(""+grid[x1][y1]);
			dir=sc.nextLine();
			for(char c : dir.toCharArray()){
				switch (c) {
				case 'E':{
					y1++;
					break;
				}
				case 'W':{
					y1--;
					break;
				}
				case 'N':{
					x1--;
					break;
				}
				case 'S':{
					x1++;
					break;
				}
				default:
					break;
				}
				sb.append(grid[x1][y1]);
			}
			char [] b=sb.toString().toCharArray();
			int m=b.length;
			int p=0;
			int [][] mem=new int [2][m+1];
			for(int i=n-1;i>=0;i--){
				p=1-p;
				for(int j=m-1;j>=0;j--){
					mem[p][j]=mem[p][j+1];
					mem[p][j]=Math.max(mem[p][j], mem[1-p][j]);
					if(a[i]==b[j])
						mem[p][j]=Math.max(mem[p][j], 1+mem[1-p][j+1]);
				}
			}
			int common=mem[p][0];
			pw.printf("Case %d: %d %d\n", id++,n-common,m-common);
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

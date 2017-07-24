package v_008;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
	public class UVA824 {
		public static void main(String[] args)throws Throwable {
			MyScanner sc=new MyScanner();
			PrintWriter pw=new PrintWriter(System.out,true);
			int [] dx={0,-1,-1,-1,0,1,1,1};
			int [] dy={1,1,0,-1,-1,-1,0,1};
			while(true){
				int x=sc.nextInt();
				if(x==-1)
					break;
				int y=sc.nextInt();
				int d=sc.nextInt();
				boolean [][] land=new boolean [3][3];
				land[1][1]=true;
				for(int i=0;i<8;i++){
					int nx=sc.nextInt()-x;
					int ny=sc.nextInt()-y;
					boolean f=sc.nextInt()==1? true : false;
					land[1+ny][1+nx]=f;
				}
				//pw.println(Arrays.deepToString(land));
				int start=(d+6)%8;
				for(int i=0;i<8;i++){
					if(land[1+dy[start]][1+dx[start]])
						break;
					start=(start+1)%8;
				}
				pw.println(start);
			}
			
			pw.flush();
			pw.close();
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
package v_006;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
	public class UVA614 {
		static boolean done;
		static int w,h;
		static String [][] ans;
		static int [][] block;
		static int xf,yf;
		public static void main(String[] args)throws Throwable {
			MyScanner sc=new MyScanner();
			PrintWriter pw=new PrintWriter(System.out,true);
			
			int id=0;
			while(true){
				h=sc.nextInt();
				w=sc.nextInt();
				int xs=sc.nextInt()-1;
				int ys=sc.nextInt()-1;
				xf=sc.nextInt()-1;
				yf=sc.nextInt()-1;
				if(w==0 && h==0)
					break;
				ans=new String [h][w];
				block=new int [h][w];
				for(int i=0;i<h;i++)
					for(int j=0;j<w;j++)
						block[i][j]=sc.nextInt();
				
				
				pw.println("Maze "+(++id+"\n"));
				done=false;
				solve(xs,ys,1);
				
				for(int i=0;i<w;i++)
					pw.print("+---");
				pw.println("+");
				
				for(int i=0;i<h;i++){
					pw.print("|");
					for(int j=0;j<w;j++){
						if(ans[i][j]==null){
							pw.print("   ");
						}else
							if(ans[i][j].equals("?"))
								pw.print("???");
							else{								
								for(int k=0;k<(3-ans[i][j].length());k++)
									pw.print(" ");
								pw.print(ans[i][j]);
							}
						if(block[i][j]%2==1 || j==w-1)
							pw.print("|");
						else
							pw.print(" ");
					}
					pw.println();
					if(i<h-1){
						for(int j=0;j<w;j++)
							if(block[i][j]>1)
								pw.print("+---");
							else
								pw.print("+   ");
						pw.println("+");
					}
				}
				for(int i=0;i<w;i++)
					pw.print("+---");
				pw.println("+");
				
				pw.print("\n\n");
			}
			
			
			pw.flush();
			pw.close();
		}
		
		public static void solve(int x,int y,int c){
			ans[x][y]=""+c;
			if(x==xf && y==yf){
				done=true;
				return;
			}
			if(!done && y>0 && block[x][y-1]%2==0 && ans[x][y-1]==null){
				solve(x, y-1, c+1);
			}
			if(!done && x>0 && block[x-1][y]<2 && ans[x-1][y]==null){
				solve(x-1, y, c+1);
			}
			if(!done && y<w-1 && block[x][y]%2==0 && ans[x][y+1]==null){
				solve(x, y+1, c+1);
			}
			if(!done && x<h-1 && block[x][y]<2 && ans[x+1][y]==null){
				solve(x+1, y, c+1);
			}
			if(!done){
				ans[x][y]="?";
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
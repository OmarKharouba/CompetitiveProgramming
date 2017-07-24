package v_004;
import java.io.*;
import java.util.*;
public class UVA476 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new  StringBuilder();
		
		
		ArrayList<Rectangle> rec=new ArrayList<Rectangle>();
		while(true){
			char c=sc.next().charAt(0);
			if(c=='*')
				break;
			
			double x=sc.nextDouble();
			double y=sc.nextDouble();
			double z=sc.nextDouble();
			double w=sc.nextDouble();
			
			rec.add(new Rectangle(new Point(x,w),new Point(z,y)));	
		}
		
		ArrayList<Point> p=new ArrayList<Point>();
		
		while(true){
			double x=sc.nextDouble();
			double y=sc.nextDouble();
			
			if(x==9999.9 && y== 9999.9)
				break;
			
			p.add(new Point(x, y));
		}
		
		for(int i=0;i<p.size();i++){
			
			boolean done=false;
			for(int j=0;j<rec.size();j++){
				if(rec.get(j).contains(p.get(i))){
					pw.println("Point "+(i+1)+" is contained in figure "+(j+1));
					done=true;
				}
			}
			
			if(!done)
				pw.println("Point "+(i+1)+" is not contained in any figure");
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Rectangle {

		static final double EPS = 1e-9;
		
		Point ll, ur;

		Rectangle(Point a, Point b) { ll = a; ur = b; }

		boolean contains(Point p)
		{
			return p.x+ EPS  < ur.x && p.x - EPS > ll.x && p.y+EPS < ur.y&& p.y - EPS > ll.y;
		}

	}static class Point{
		double x, y;                  

		Point(double a, double b) { x = a; y = b; }
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

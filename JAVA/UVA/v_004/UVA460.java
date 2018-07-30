package v_004;
import java.io.*;
import java.util.*;
public class UVA460 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new  StringBuilder();
		
		int t=sc.nextInt();
		while(t-->0){
			Rectangle a=new Rectangle(new Point(sc.nextInt(),sc.nextInt()),new Point(sc.nextInt(),sc.nextInt()));
			
			Rectangle b=new Rectangle(new Point(sc.nextInt(),sc.nextInt()),new Point(sc.nextInt(),sc.nextInt()));
			
			if(a.intersect(b)==null)
				pw.println("No Overlap");
			else
				pw.println(a.intersect(b).ll.x+" "+a.intersect(b).ll.y+" "+a.intersect(b).ur.x+" "+a.intersect(b).ur.y);
		if(t>0)
			pw.println();
		}
		
		
		pw.flush();
		pw.close();
	}
	
	static class Rectangle {
		
		Point ll, ur;

		Rectangle(Point a, Point b) { ll = a; ur = b; }
		
		boolean contains(Point p)
		{
			return p.x <= ur.x && p.x >= ll.x && p.y <= ur.y && p.y >= ll.y;
		}

		Rectangle intersect(Rectangle r)
		{
			Point ll = new Point(Math.max(this.ll.x, r.ll.x), Math.max(this.ll.y, r.ll.y));
			Point ur = new Point(Math.min(this.ur.x, r.ur.x), Math.min(this.ur.y, r.ur.y));
			if(Math.abs(ur.x - ll.x) > 0 && Math.abs(ur.y - ll.y) > 0 && this.contains(ll) && this.contains(ur) && r.contains(ll) && r.contains(ur))
				return new Rectangle(ll, ur);
			return null;
		}

	}
	
	static class Point{
		int x, y;                  

		Point(int a, int b) { x = a; y = b; }
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

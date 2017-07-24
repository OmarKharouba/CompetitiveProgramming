package v_118;
import java.io.*;
import java.util.*;
public class UVA11854 {
	
	static final double EPS = 1e-9;
	
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new  StringBuilder();
		
		int t=sc.nextInt();
		while(t-->0){
			LineSegment l=new LineSegment(new Point(sc.nextDouble(), sc.nextDouble()), new Point(sc.nextDouble(), sc.nextDouble()));
			double x=sc.nextDouble();
			double y=sc.nextDouble();
			double z=sc.nextDouble();
			double w=sc.nextDouble();
			
			if(x>z){
				double tmp=x;
				x=z;
				z=tmp;
			}
			
			if(w>y){
				double tmp=w;
				w=y;
				y=tmp;
			}
			
			Point ll=new Point(x,w);
			Point lr=new Point(z,w);
			Point ul=new Point(x,y);
			Point ur=new Point(z,y);
			
			boolean ok=(l.intersect(new LineSegment(ll, lr)) || l.intersect(new LineSegment(lr, ur)) || l.intersect(new LineSegment(ur, ul)) || l.intersect(new LineSegment(ll, ul)));
			
			ok |=(l.p.x <= ur.x + EPS && l.p.x + EPS >= ll.x && l.p.y <= ur.y + EPS && l.p.y + EPS >= ll.y);
			
			if(ok)
				pw.println("T");
			else
				pw.println("F");
		}
		
		
		pw.flush();
		pw.close();
	}
	
	static class Point{
		double x, y;                  

		Point(double a, double b) { x = a; y = b; }  
		
		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}
	}
	
	static class LineSegment {

		Point p, q;
		
		LineSegment(Point a, Point b) { p = a; q = b; }
		

		boolean intersect(LineSegment ls)
		{
			Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
			if(l1.parallel(l2))
			{
				if(l1.same(l2))
					return p.between(ls.p, ls.q) || q.between(ls.p, ls.q) || ls.p.between(p, q) || ls.q.between(p, q);
				return false;
			}
			Point c = l1.intersect(l2);
			return c.between(p, q) && c.between(ls.p, ls.q);
		}

	}
	
	static class Line {
		
		double a, b, c;
		
		Line(Point p, Point q)
		{
			if(Math.abs(p.x - q.x) < EPS) {	a = 1; b = 0; c = -p.x;	}
			else
			{
				a = (p.y - q.y) / (q.x - p.x);
				b = 1.0;
				c = -(a * p.x + p.y);
			}
						
		}
		
		Line(Point p, double m) { a = -m; b = 1; c =  -(a * p.x + p.y); } 
		
		boolean parallel(Line l) { return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS; }
		
		boolean same(Line l) { return parallel(l) && Math.abs(c - l.c) < EPS; }
		
		Point intersect(Line l)
		{
			if(parallel(l))
				return null;
			double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
			double y;
			if(Math.abs(b) < EPS)
				 y = -l.a * x - l.c;
			else
				y = -a * x - c;
			
			return new Point(x, y);
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
	      
	      boolean ready()throws Exception{
	    	  return br.ready();
	      }

	   }
}

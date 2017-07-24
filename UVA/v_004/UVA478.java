package v_004;
import java.io.*;
import java.util.*;
public class UVA478 {
	static final double EPS = 1e-9;
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		StringBuilder sb=new  StringBuilder();
		
		
		ArrayList<ArrayList<Double>> rec=new ArrayList<ArrayList<Double>>();
		while(true){
			char c=sc.next().charAt(0);
			if(c=='*')
				break;
			
			ArrayList<Double> cur=new ArrayList<Double>();
			
			if(c=='r'){
				for(int i=0;i<4;i++)
					cur.add(sc.nextDouble());
			}else
				if(c=='c'){
					for(int i=0;i<3;i++)
						cur.add(sc.nextDouble());
				}else
					for(int i=0;i<6;i++)
						cur.add(sc.nextDouble());
			
			rec.add(cur);
			
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
				ArrayList<Double> a=rec.get(j);
				
				int n=a.size();
				
				if(n==4){
					Rectangle r=new Rectangle(new Point(a.get(0),a.get(3)),new Point(a.get(2), a.get(1)));
					if(r.contains(p.get(i))){
						pw.println("Point "+(i+1)+" is contained in figure "+(j+1));
						done =true;
					}
					
				}else
					if(n==3){
						Circle c=new Circle(new Point(a.get(0), a.get(1)), a.get(2));
						if(c.inside(p.get(i))==1){
							pw.println("Point "+(i+1)+" is contained in figure "+(j+1));
							done =true;
						}
						
					}else{
						Triangle t=new Triangle(new Point(a.get(0), a.get(1)), new Point(a.get(2), a.get(3)), new Point(a.get(4), a.get(5)));
						if(t.inside(p.get(i))){
							pw.println("Point "+(i+1)+" is contained in figure "+(j+1));
							done =true;
						}
						
					}
				
				
			}
			
			if(!done)
				pw.println("Point "+(i+1)+" is not contained in any figure");
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Circle{
		double r;
		Point c;
		
		Circle(Point p, double k) { c = p; r = k; }
		
		int inside(Point p)
		{
			double d = p.dist(c);

			return d + EPS < r ? 1 : Math.abs(d - r) < EPS ? 0 : -1;
		}
	}
	
	static class Triangle{
		Point a,b,c;
		
		Triangle (Point x,Point y,Point z){
			a=x; b=y; c=z;
		}
		
		boolean inside(Point p){
			if (Point.collinear(a, b, p) || Point.collinear(a, c, p) || Point.collinear(c, b, p))
				return false;
			
			boolean ok=Point.ccw(a, b, p);
			
			if(Point.ccw(b, c, p)!=ok || Point.ccw(c, a, p)!=ok)
				return false;
			
			return true;
		}
		
	}
	
	static class Rectangle {

		
		Point ll, ur;

		Rectangle(Point a, Point b) { ll = a; ur = b; }

		boolean contains(Point p)
		{
			return p.x+ EPS  < ur.x && p.x - EPS > ll.x && p.y+EPS < ur.y&& p.y - EPS > ll.y;
		}

	}static class Point{
		double x, y;                  

		Point(double a, double b) { x = a; y = b; }
		
		static boolean ccw(Point p, Point q, Point r)
		{
			return new Vector(p, q).cross(new Vector(p, r)) > 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		static double sq(double x) { return x * x; }
		
		static boolean collinear(Point p, Point q, Point r)
		{
			return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
		}
	}
	
	static class Vector{
		double x, y; 
		
		Vector(double a, double b) { x = a; y = b; }

		Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }
		
		double cross(Vector v) { return x * v.y - y * v.x; }
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

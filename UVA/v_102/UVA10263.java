package v_102;
import java.io.*;
import java.util.*;
public class UVA10263 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int t=2;
		while(t-->0){
//		while(sc.br.ready()){
			Point m=new Point(sc.nextDouble(), sc.nextDouble());
			int n=sc.nextInt();
			Point a=new Point(sc.nextDouble(), sc.nextDouble());
			double low=1e17;
			Point best=new Point(0, 0);
			while(n-->0){
				Point b=new Point(sc.nextDouble(), sc.nextDouble());
				Point c=Point.distToLineSegment(m, a, b);
				if(c.dist(m)<=low){
					low=c.dist(m);
					best=c;
				}
				a=b;
			}
			pw.printf("%.4f\n",best.x);
			pw.printf("%.4f\n",best.y);
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		double x, y;                  

		Point(double a, double b) { x = a; y = b; }  
		
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		static double sq(double x) { return x * x; }
		
		Point rotate(double angle)
		{
			double c = Math.cos(angle), s = Math.sin(angle);
			return new Point(x * c - y * s, x * s + y * c);
		}
		// for integer points and rotation by 90 (counterclockwise) : swap x and y, negate x
		
		Point rotate(double theta, Point p)			//rotate around p
		{
			Vector v = new Vector(p, new Point(0, 0));
			return translate(v).rotate(theta).translate(v.reverse());
		}
		
		Point translate(Vector v) { return new Point(x + v.x , y + v.y); }
		
		Point reflectionPoint(Line l) 	//reflection point of p on line l
		{
			Point p = l.closestPoint(this);
			Vector v = new Vector(this, p);
			return this.translate(v).translate(v);
		}
		
		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}
		
		//returns true if it is on the line defined by a and b
		boolean onLine(Point a, Point b) 
		{
			if(a.compareTo(b) == 0) return compareTo(a) == 0;
			return Math.abs(new Vector(a, b).cross(new Vector(a, this))) < EPS;
		}
		
		boolean onSegment(Point a, Point b)
		{
			if(a.compareTo(b) == 0) return compareTo(a) == 0;
			return onRay(a, b) && onRay(b, a);
		}
		
		//returns true if it is on the ray whose start point is a and passes through b
		boolean onRay(Point a, Point b)
		{
			if(a.compareTo(b) == 0) return compareTo(a) == 0;
			return new Vector(a, b).normalize().equals(new Vector(a, this).normalize());	//implement equals()
		}
		
		// returns true if it is on the left side of Line pq
		// add EPS to LHS if on-line points are accepted
		static boolean ccw(Point p, Point q, Point r)
		{
			return new Vector(p, q).cross(new Vector(p, r)) > 0;
		}
		
		static boolean collinear(Point p, Point q, Point r)
		{
			return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
		}
		
		static double angle(Point a, Point o, Point b)  // angle AOB
		{
			Vector oa = new Vector(o, a), ob = new Vector(o, b);
			return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));
		}
		
		static Point distToLine(Point p, Point a, Point b) //distance between point p and a line defined by points a, b (a != b)
		{
			if(a.compareTo(b) == 0) p.dist(a);
			// formula: c = a + u * ab
			Vector ap = new Vector(a, p), ab = new Vector(a, b);
			double u = ap.dot(ab) / ab.norm2();
			Point c = a.translate(ab.scale(u)); 
			return c;
		}

		static Point distToLineSegment(Point p, Point a, Point b) 
		{
			Vector ap = new Vector(a, p), ab = new Vector(a, b);
			double u = ap.dot(ab) / ab.norm2();
			if (u < 0.0) return a;
			if (u > 1.0) return b;        
			return distToLine(p, a, b); 
		}
	}
	
	static class Vector {

		double x, y; 

		Vector(double a, double b) { x = a; y = b; }

		Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }

		Vector scale(double s) { return new Vector(x * s, y * s); }              //s is a non-negative value

		double dot(Vector v) { return (x * v.x + y * v.y); }

		double cross(Vector v) { return x * v.y - y * v.x; }

		double norm2() { return x * x + y * y; }

		Vector reverse() { return new Vector(-x, -y); }

		Vector normalize() 
		{ 
			double d = Math.sqrt(norm2());
			return scale(1 / d);
		}		
	}
	
	static class Line {

		static final double INF = 1e9, EPS = 1e-9;
		
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
		
		Point closestPoint(Point p)
		{
			if(Math.abs(b) < EPS) return new Point(-c, p.y);
			if(Math.abs(a) < EPS) return new Point(p.x, -c);
			return intersect(new Line(p, 1 / a));
		}
				
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}
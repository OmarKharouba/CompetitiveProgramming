package v_016;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class UVA1643 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		DecimalFormat df=new DecimalFormat("0.000");
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			Point o=new Point(0, 0);
			Point a=new Point(sc.nextDouble(), sc.nextDouble());
			Point b=new Point(sc.nextDouble(), sc.nextDouble());
			Line oa=new Line(o, a);
			Line ob=new Line(o, b);
			double len=0;
			double area=0;
			while(n-->0){
				double x=sc.nextDouble();
				len+=Math.sqrt(2*x*x);
				area+=x*x/2.0;
			}
			double start=0,end=1e18;
			for(int i=0;i<200;i++){
				double mid=(start+end)/2.0;
				Line l3=new Line(new Point(mid, 0),-1);
				double f=l3.intersect(oa).dis(l3.intersect(ob));
				if(f>len)
					end=mid;
				else
					start=mid;
			}
			Line l=new Line(new Point(start, 0), -1);
			Point p1=l.intersect(oa);
			Point p2=l.intersect(ob);
			double ans=new Triangle(o, p1, p2).area()-area;
			pw.println(df.format(ans));
		}
		pw.flush();
		pw.close();
	}
	
	static double eps=1e-9;
	
	static class Line {
		double a,b,c; //aX+bY+c=0
		Line(Point p,Point q){
			if(Math.abs(p.x-q.x)<eps){ //vertical line
				a=1;
				b=0;
				c=-p.x;
			}else{
				a=(q.y-p.y)/(p.x-q.x); //-slope
				b=1;
				c=-a*p.x-p.y;
			}
		}
		Line(Point p,double m){
			a=-m;
			b=1;
			c=m*p.x-p.y;
		}
		boolean parallel(Line l){
			return Math.abs(a-l.a)<eps && Math.abs(b-l.b)<eps;
		}
		boolean same(Line l){
			return parallel(l) && Math.abs(c-l.c)<eps;
		}
		Point intersect(Line l){
			//using determinants
			double x=(b*l.c-c*l.b)/(a*l.b-b*l.a);
			double y=0;
			if(b==1)
				y=-a*x-c;
			else
				y=-l.a*x-l.c;
			return new Point(x, y);
		}
	}
	
	static class Triangle{
		Point a, b, c;
		double ab, bc, ca;

		Triangle(Point p, Point q, Point r)
		{
			a = p;
			if(Point.ccw(p, q, r)) { b = q; c = r; }
			else { b = r; c = q; }

			ab = a.dis(b); bc = b.dis(c); ca = c.dis(a);
		}
		double area()
		{
			double s = (ab + bc + ca) / 2.0;
			return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
		}
	}
	
	static class Vector{
		double x,y;
		Vector(double a,double b){
			x=a;
			y=b;
		}
		Vector(Point a,Point b){
			this(b.x-a.x,b.y-a.y);
		}
		double cross(Vector v){
			return x*v.y-y*v.x;
		}
	}
	
	
	static class Point{
		double x,y;
		Point(double a,double b){
			x=a;
			y=b;
		}
		static boolean ccw(Point p, Point q, Point r)
		{
			return new Vector(p, q).cross(new Vector(p, r)) > 0;
		}
		double dis(Point p){
			return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
		}
		
		
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("football.in")));
			} catch (FileNotFoundException e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
			}
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
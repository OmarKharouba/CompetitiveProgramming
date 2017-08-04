
public class PointInPolygon {
	public static void main(String[] args) {
		
	}
	
	public static String testPoint(String[] vertices, int testPointX, int testPointY){
		int n=vertices.length;
		LineSegment [] a=new LineSegment [n];
		Point m=new Point(testPointX+" "+testPointY);
		boolean border=false;
		int c1=0,c2=0;
		for(int i=0;i<n;i++){
			Point p=new Point(vertices[i]),q=new Point(vertices[(i+1)%n]);
			a[i]=new LineSegment(p, q);
			if(a[i].onSegment(m))
				border=true;
			if(p.x==q.x){
				if(Math.max(p.y, q.y)>=m.y && Math.min(p.y, q.y)<m.y)
					if(p.x>m.x)
						c1++;
					else
						c2++;
			}
		}
		if(border)
			return "BOUNDARY";
		if(c1%2==1 && c2%2==1)
			return "INTERIOR";
		return "EXTERIOR";
	}
	
	static class Point{
		int x,y;
		Point(String s){
			String [] sa=s.split(" ");
			x=Integer.parseInt(sa[0]);
			y=Integer.parseInt(sa[1]);
		}
		
		
	}
	
	static class LineSegment{
		Point p,q;
		
		public LineSegment(Point a,Point b) {
			p=a;
			q=b;
		}
		
		public boolean onSegment(Point r){
			if(p.x==q.x)
				return r.x==p.x && r.y>=Math.min(p.y, q.y) && r.y<=Math.max(p.y, q.y);
			return r.y==p.y && r.x>=Math.min(p.x, q.x) && r.x<=Math.max(p.x, q.x);
		}
	}
}

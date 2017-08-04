
public class TVTower {
	static double eps=1e-9;
	
	public static double minRadius(int[] x, int[] y){
		
		int n=x.length;
		Point [] a=new Point[n];
		for(int i=0;i<n;i++)
			a[i]=new Point(x[i], y[i]);
		if(n==1)
			return 0.0;
		if(n==2)
			return a[0].dis(a[1])/2.0;
		double ans=Double.MAX_VALUE;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++){
				Point mid=new Point((a[i].x+a[j].x)/2.0, (a[i].y+a[j].y)/2.0);
				double r=mid.dis(a[i]);
				int cnt=0;
				for(int k=0;k<n;k++){
					if(mid.dis(a[k])<r+eps)
						cnt++;
				}
				if(cnt==n)
					ans=Math.min(ans, r);
				for(int k=j+1;k<n;k++){
					Triangle t=new Triangle(a[i], a[j], a[k]);
					Point p=t.circumCircle();
					if(p==null)
						continue;
					r=Math.max(p.dis(a[i]), Math.max(p.dis(a[j]), p.dis(a[k])));
					cnt=0;
					for(int h=0;h<n;h++){
						if(p.dis(a[h])<r+eps)
							cnt++;
					}
					if(cnt==n)
						ans=Math.min(ans, r);
				}
			}
		
		return ans;
	}
	
	static class Triangle{
		Point a, b, c;
		double ab, bc, ca;

		Triangle(Point p, Point q, Point r){
			a = p;
			if(Point.ccw(p, q, r)) { b = q; c = r; }
			else { b = r; c = q; }

			ab = a.dis(b); bc = b.dis(c); ca = c.dis(a);
		}
		
		Point circumCircle(){
			double bax = b.x - a.x, bay = b.y - a.y;
			double cax = c.x - a.x, cay = c.y - a.y;

			double e = bax * (a.x + b.x) + bay * (a.y + b.y);
			double f = cax * (a.x + c.x) + cay * (a.y + c.y);
			double g = 2.0 * (bax * (c.y - b.y) - bay * (c.x - b.x));

			if (Math.abs(g) < eps) return null;

			return new Point((cay*e - bay*f) / g, (bax*f - cax*e) / g);

		}
		
	}
	
	static class Point{
		double x,y;
		
		Point(double a,double b){
			x=a;
			y=b;
		}
		
		static boolean ccw(Point p,Point q,Point r){
			return new Vector(p, q).cross(new Vector(p, r))>0;  //if collinear is acceptable :: (> -eps) instead of (>0)
		}
		
		double dis(Point p){
			return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
		}
	}
	
	static class Vector{
		double x,y;
		
		Vector(double a,double b){
			x=a;
			y=b;
		}
		
		Vector(Point p,Point q){
			this(q.x-p.x,q.y-p.y);
		}
		
		double cross(Vector v){
			return x*v.y-y*v.x;
		}
	}
}


public class ConvexPolygon {
	
	public static void main(String[] args) {
		int [] a=	
			{-10000,-10000,10000,10000};
		int [] b={10000,-10000,-10000,10000};
		
		System.out.println(findArea(a, b));
	}
	
	public static double findArea(int[] x, int[] y){
		double ans=0;
		int n=x.length;
		for(int i=0;i<n;i++){
			Point p=new Point(x[i], y[i]);
			Point q=new Point(x[(i+1)%n], y[(i+1)%n]);
			Point o=new Point(0, 0);
			ans+=new Vector(o, p).cross(new Vector(o, q));
		}
		return Math.abs(ans)/2.0;
	}
	
	static class Point{
		int x,y;
		
		Point(int a,int b){
			x=a;
			y=b;
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

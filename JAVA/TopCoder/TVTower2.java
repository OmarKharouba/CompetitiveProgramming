public class TVTower2 {
	
	public static void main(String[] args) {
		int [] a={933, 743, 262, 529, 700, 508, 752, 256, 256, 119, 711, 351, 843, 705, 108, 393, 330, 366, 169, 932, 917, 847, 972, 868, 980, 223, 549, 592, 164, 169, 551, 427, 190, 624, 635, 920, 944, 310, 862, 484, 363, 301, 710, 236, 876, 431, 929, 397, 675, 491};
		int [] b={190, 344, 134, 425, 629, 30, 727, 126, 743, 334, 104, 760, 749, 620, 256, 932, 572, 613, 490, 509, 119, 405, 695, 49, 327, 719, 497, 824, 596, 649, 356, 184, 93, 245, 7, 306, 509, 754, 352, 665, 783, 738, 801, 690, 330, 337, 195, 656, 963, 11};
		System.out.println(minRadius(a, b));
	}
	
	public static double minRadius(int[] x, int[] y){
		
		int n=x.length;
		Point [] a=new Point[n];
		for(int i=0;i<n;i++)
			a[i]=new Point(x[i], y[i]);
		if(n==1)
			return 0.0;
		if(n==2)
			return a[0].dis(a[1])/2.0;
		double res=Double.MAX_VALUE;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				if(i==j)
					continue;
				Point p=a[i];
				Point q=a[j];
				Line l1=new Line(p, q);
				Point midPoint=new Point((p.x+q.x)/2, (p.y+q.y)/2);
				Line l2=new Line(midPoint,1/l1.a);
				if(l1.a==0)
					l2=new Line(midPoint, new Point(midPoint.x, midPoint.y+1));
				if(l1.b==0)
					l2=new Line(midPoint, new Point(midPoint.x+1, midPoint.y));
				Point p1=new Point(0, 0);
				Point p2=new Point(0, 0);
				if(l2.b!=0){
					p1=new Point(midPoint.x-1, l2.findY(midPoint.x-1));
					p2=new Point(midPoint.x+1, l2.findY(midPoint.x+1));
				}else{
					p1=new Point(l2.findX(), midPoint.y-1);
					p2=new Point(l2.findX(), midPoint.y+1);
				}
				Vector v1=new Vector(midPoint, p1).noramlize();
				Vector v2=new Vector(midPoint, p2).noramlize();
				
				double start=0,end=10000,ans=-1;
				while(Math.abs(end-start)>eps){
					double mid=(start+end)/2;
					Point c1=midPoint.translate(v1.scale(mid));
					double r=c1.dis(p);
					Circle circle1=new Circle(c1, r);
					int f2=0;
					for(int k=0;k<n;k++){
						if(!circle1.inside(a[k])){
							if(ccw(p, q, a[k]))
								f2=1;
							else
								f2=2;
						}
					}
					if(f2==0){
						ans=r;
						end=mid;
					}else{
						if(f2==1)
							end=mid;
						else
							start=mid;
					}
				}
				if(ans!=-1)
					res=Math.min(res, ans);
				////////////////////
				start=0;end=10000;ans=-1;
				while(Math.abs(end-start)>eps){
					double mid=(start+end)/2;
					Point c2=midPoint.translate(v2.scale(mid));
					double r=c2.dis(p);
					Circle circle2=new Circle(c2, r);
					int f2=0;
					for(int k=0;k<n;k++){
						if(!circle2.inside(a[k])){
							if(ccw(p, q, a[k]))
								f2=2;
							else
								f2=1;
						}
					}
					if(f2==0){
						ans=r;
						end=mid;
					}else{
						if(f2==1)
							end=mid;
						else
							start=mid;
					}
				}
				if(ans!=-1)
					res=Math.min(res, ans);
			}
		return res;
	}
	
	static boolean ccw(Point p, Point q, Point r){
		return new Vector(p, q).cross(new Vector(p, r)) > 0;
	}
	
	static class Line{
		double a,b,c;
		
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
		
		double findY(double x){ //b!=0
			return -a*x-c;
		}
		
		double findX(){ //b==0
			return -c/a;
		}
		
		Line(Point p,double m){
			a=-m;
			b=1;
			c=m*p.x-p.y;
		}
	}
	
	static double eps=1e-9;
	static class Circle{
		double r;
		Point c;
		Circle(Point p,double a){
			r=a;
			c=p;
		}
		
		boolean inside(Point p){
			return c.dis(p)<r+eps;
		}
	}
	
	static class Point{
		double x,y;
		
		Point(double a,double b){
			x=a;
			y=b;
		}
		
		double dis(Point p){
			return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
		}
		
		Point translate(Vector v){
			return new Point(x+v.x, y+v.y);
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
		
		double norm_sq(){
			return x*x+y*y;
		}
		Vector noramlize(){
			double d=Math.sqrt(norm_sq());
			return scale(1/d);
		}
		
		double cross(Vector v){
			return x*v.y-y*v.x;
		}
		
		Vector scale(double s){
			return new Vector(x*s, y*s);
		}
	}
}

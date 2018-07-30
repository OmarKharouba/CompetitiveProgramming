import java.util.ArrayList;
import java.util.Arrays;

public class Satellites {
	static double r=6400;
	public static void main(String[] args) {
		
		String [] a={"+0040.000 -0135.000"};
		String [] b={"+0090.000 +0000.000 +1200.000",
				 "-0090.000 +0000.000 +1200.000",
				 "+0000.000 +0000.000 +1200.000",
				 "+0000.000 -0090.000 +1200.000",
				 "+0000.000 +0180.000 +1200.000",
				 "-0000.000 -0045.000 +1200.000",
				 "-0000.000 -0135.000 +1000.000",
				 "-0011.000 -0136.000 +1086.828"};
		System.out.println(Arrays.toString(detectable(a, b)));;
	}
	
	public static int[] detectable(String[] rockets, String[] satellites){
		
		int n=rockets.length;
		int m=satellites.length;
		Point [] a=new Point [n];
		Point [] b=new Point [m];
		for(int i=0;i<n;i++){
			String [] sa=rockets[i].split(" ");
			double ang1=Double.parseDouble(sa[0])*Math.PI/180;
			double ang2=Double.parseDouble(sa[1])*Math.PI/180;
			double d=r+400;
			double s1=Math.sin(ang1);
			double c1=Math.cos(ang1);
			double s2=Math.sin(ang2);
			double c2=Math.cos(ang2);
			a[i]=new Point(d*c1*c2, d*c1*s2, d*s1);
		}
		for(int i=0;i<m;i++){
			String [] sa=satellites[i].split(" ");
			double ang1=Double.parseDouble(sa[0])*Math.PI/180;
			double ang2=Double.parseDouble(sa[1])*Math.PI/180;
			double d=Double.parseDouble(sa[2])+r;
			double s1=Math.sin(ang1);
			double c1=Math.cos(ang1);
			double s2=Math.sin(ang2);
			double c2=Math.cos(ang2);
			b[i]=new Point(d*c1*c2, d*c1*s2, d*s1);
		}
		ArrayList<Integer> ans=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			int cnt=0;
			for(int j=0;j<m;j++){
				LineSegment l=new LineSegment(a[i], b[j]);
				double d=l.shortestDistance();
				System.err.println(d);
				if(d>r+eps)
					cnt++;
			}
			if(cnt>2)
				ans.add(i);
		}
		
		
		
		int p=0;
		int sz=ans.size();
		int [] ret=new int [sz];
		for(int i : ans)
			ret[p++]=i;
		return ret;
	}
	static double eps=1e-9;
	static class Point{
		double x,y,z;
		
		Point(double a,double b,double c){
			x=a;
			y=b;
			z=c;
		}
		
		double dis(Point p){
			return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)+(z-p.z)*(z-p.z));
		}
		
		Point translate(Vector v){
			return new Point(x+v.x, y+v.y, z+v.z);
		}
	}
	
	static class LineSegment{
		Point p,q;
		
		public LineSegment(Point a,Point b) {
			p=a;
			q=b;
		}
		
		public double shortestDistance(){
			Point o=new Point(0, 0, 0);
			double ans=Double.MAX_VALUE;
			Point start=p,end=q;
			for(int i=0;i<300;i++){
				Vector pq=new Vector(start, end).scale(1/3.0);
				Vector qp=new Vector(end, start).scale(1/3.0);
				
				Point m1=start.translate(pq);
				Point m2=end.translate(qp);
				double d1=o.dis(m1);
				double d2=o.dis(m2);
				if(d1<d2){
					ans=Math.min(ans, d1);
					end=m2;
				}else{
					ans=Math.min(ans, d2);
					start=m1;
				}
			}
			
			return ans;
		}
	}
	
	static class Vector{
		double x,y,z;
		
		Vector(double a,double b,double c){
			x=a;
			y=b;
			z=c;
		}
		
		Vector(Point p,Point q){
			this(q.x-p.x, q.y-p.y, q.z-p.z);
		}
		
		double norm_sq(){
			return x*x+y*y+z*z;
		}
		Vector noramlize(){
			double d=Math.sqrt(norm_sq());
			return scale(1/d);
		}
		
		Vector scale(double s){
			return new Vector(x*s, y*s,z*s);
		}
		
	}

}

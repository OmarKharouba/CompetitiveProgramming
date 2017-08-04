
public class Surveyor {
	
	public static void main(String[] args) {
		int [] a={10,3,7,10,10};
		System.out.println(area("NWWSE", a));
	}
	
	public static int area(String direction, int[] length){
		int n=direction.length()+1;
		Point [] a=new Point [n];
		a[0]=new Point(0, 0);
		for(int i=1;i<n;i++){
			int d=length[i-1];
			int x=a[i-1].x;
			int y=a[i-1].y;
			char c=direction.charAt(i-1);
			if(c=='E')
				x+=d;
			else
				if(c=='W')
					x-=d;
				else
					if(c=='N')
						y+=d;
					else
						y-=d;
			a[i]=new Point(x, y);
		}
		int ans=0;
		for(int i=0;i<n-1;i++){
			Point o=new Point(0, 0);
			ans+=new Vector(o, a[i]).cross(new Vector(o, a[i+1]));
		}
		return Math.abs(ans/2);
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

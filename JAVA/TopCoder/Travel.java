import java.util.Arrays;


public class Travel {
	public static void main(String[] args) {
		String [] a={"40 -82","-27 -59","-40 48"
				,"26 -12","-31 -37","-30 42"
				,"-36 -23","-26 71","-19 83","8 63"};
		System.out.println(shortest(a, 698));
	}
	
	public static int shortest(String[] cities, int radius){
		n=cities.length;
		points=new point [n];
		for(int i=0;i<n;i++){
			String [] sa=cities[i].split(" ");
			double latitude=Double.parseDouble(sa[0])*Math.PI/180;
			double longitude=Double.parseDouble(sa[1])*Math.PI/180;
			double a=radius*Math.cos(latitude)*Math.cos(longitude);
			double b=radius*Math.cos(latitude)*Math.sin(longitude);
			double c=radius*Math.sin(latitude);
			points[i]=new point(a, b, c);
		}
		mem=new Double [n+1][1<<10];
		dis=new double [n][n];
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++){
				vector v1=new vector(points[i].x, points[i].y, points[i].z);
				vector v2=new vector(points[j].x, points[j].y, points[j].z);
				double ang=v1.dot(v2)/Math.sqrt(v1.norm2()*v2.norm2());
				dis[i][j]=dis[j][i]=Math.acos(ang)*radius;
			}
		return (int)(Math.round(dp(0,1)));
	}
	static int n;
	static point [] points;
	static Double [][] mem;
	static double [][] dis;
	
	public static double dp(int i,int msk){
		if(Integer.bitCount(msk)==n)
			return dis[0][i];
		
		if(mem[i][msk]!=null)
			return mem[i][msk];
		
		double ans=1e15;
		for(int j=0;j<n;j++)
			if((msk & (1<<j))==0)
				ans=Math.min(ans, dis[i][j]+dp(j, msk | (1<<j)));
		
		return mem[i][msk]=ans;
	}
	
	static class point{
		double x,y,z;
		point(double a,double b,double c){
			x=a;
			y=b;
			z=c;
		}
	}
	
	static class vector{
		double x,y,z;
		vector(double a,double b,double c){
			x=a;
			y=b;
			z=c;
		}
		double dot(vector v){
			return x*v.x+y*v.y+z*v.z;
		}
		double norm2(){
			return x*x+y*y+z*z;
		}
	}
}

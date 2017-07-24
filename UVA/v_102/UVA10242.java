package v_102;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class UVA10242 {
	public static void main(String[]args)throws Throwable{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out,true);
		DecimalFormat df=new DecimalFormat("#0.000");
		while(sc.ready()){
			int common=0;
			ArrayList<Point> a=new ArrayList<Point>();
			
			try{
				for(int i=0;i<4;i++){
					double x=sc.nextDouble();
					double y=sc.nextDouble();
					boolean exist=false;
					for(int j=0;j<a.size();j++)
						if(a.get(j).x==x && a.get(j).y==y){
							exist=true;
							common=j;
						}
					if(!exist)
						a.add(new Point(x, y));
				}
			}catch (Exception e){
				break;
			}
			Point p=a.get(common);
			a.remove(common);
			
			if(a.size()==0){
				pw.println(df.format(p.x)+" "+df.format(p.y));
				continue;
			}
			
			if(a.size()==1){
				pw.println(df.format(a.get(0).x)+" "+df.format(a.get(0).y));
				continue;
			}
			
			
			Vector v1=new Vector(p,a.get(0));
			Vector v2=new Vector(p,a.get(1));
			Vector v=new Vector(v1.x+v2.x, v1.y+v2.y);
			double ansX=v.x+p.x;
			double ansY=v.y+p.y;
			pw.println(df.format(ansX)+" "+df.format(ansY));
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Vector{
		double x, y; 

		Vector(double a, double b) { x = a; y = b; }

		Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }
	}
	
	static class Point{
		double x, y;                  

		Point(double a, double b) { x = a; y = b; } 
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Integer.parseInt(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			if(dec)
				res += Integer.parseInt(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		public boolean ready() throws IOException {return br.ready();}


	}
}

package v_003;
import java.io.*;
import java.util.*;
public class UVA356 {
	public static void main(String[] args) throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		boolean first=true;
		while(sc.br.ready()){
			int n=sc.nextInt();
			Point center=new Point(n, n);
			int cin=0,con=0;
			double d1=(2*n-1)*(2*n-1);
			for(int i=0;i<2*n;i++)
				for(int j=0;j<2*n;j++){
					Point p1=new Point(i, j);
					Point p2=new Point(i, j+1);
					Point p3=new Point(i+1, j);
					Point p4=new Point(i+1, j+1);
					Point [] p={p1,p2,p3,p4};
					int in=0;
					for(int k=0;k<4;k++){
						Point cur=p[k];
						double d2=4*center.dis2(cur);
						if(d2<=d1)
							in++;
					}
					if(in==4)
						cin++;
					else
						if(in>0)
							con++;
				}
			if(!first)
				pw.println();
			pw.println("In the case n = "+n+", "+con+" cells contain segments of the circle.");
			pw.println("There are "+cin+" cells completely contained in the circle.");
			first=false;
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Point{
		int x,y;
		Point(int a,int b){
			x=a;
			y=b;
		}
		long dis2(Point p){
			return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y);
		}
	}
	
	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;
		
		MyScanner(){
			try {
				br=new BufferedReader(new FileReader(new File("test.in")));
			} catch (FileNotFoundException e) {
				br=new BufferedReader(new InputStreamReader(System.in));
			}
		}
		
		String next(){
			while(st==null || !st.hasMoreTokens()){
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		String nextLine(){
			String ans="";
			try {
				ans=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return ans;
		}
		
		int nextInt(){
			return Integer.parseInt(next());
		}
		
		long nextLong(){
			return Long.parseLong(next());
		}
		
		double nextDouble(){
			return Double.parseDouble(next());
		}
	}
	
}

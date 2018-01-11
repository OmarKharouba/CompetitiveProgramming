import java.io.*;
import java.util.*;
public class UVa_11378 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(sc.br.ready()){			
			int n=sc.nextInt();
			Point [] a=new Point [n];
			for(int i=0;i<n;i++)
				a[i]=new Point(sc.nextInt(), sc.nextInt());
			pw.println(closest_pair(a));
		}
		
		pw.flush();
		pw.close();
	}

	static int inf=(int)1e9;
	
	public static int closest_pair(Point [] a){
		int n=a.length;
		int d=inf;
		Arrays.sort(a,new comX());
		TreeSet<Point> active=new TreeSet<Point>(new comY());
		active.add(a[0]);
		int left=0;
		for(int i=1;i<n;i++){
			while(left<i && a[i].x-a[left].x > d)
				active.remove(a[left++]);
			Point from=new Point(a[i].x, a[i].y-d);
			Point to=new Point(a[i].x, a[i].y+d);
			for(Point p : active.subSet(from, to))
				d=Math.min(d, p.dis(a[i]));
			active.add(a[i]);
		}
		return d;
	}
	
	static class Point{
		int x,y;
		Point(int a,int b){
			x=a;
			y=b;
		}
		int dis(Point p){
			return Math.max(Math.abs(p.x-x), Math.abs(p.y-y));
		}
	}
	
	static class comX implements Comparator<Point>{
		public int compare(Point a, Point b) {
			return a.x-b.x;
		}
	}
	static class comY implements Comparator<Point>{
		public int compare(Point a, Point b) {
			return a.y-b.y;
		}
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
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
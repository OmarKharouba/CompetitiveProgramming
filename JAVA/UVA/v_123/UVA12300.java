package v_123;

import java.io.*;
import java.util.*;

public class UVA12300 {

	/*
	 * dis -> the distance between the two points of the input 
	 * ang -> the angle between two sides of a regular polygon with N sides 
	 * s -> the side length of the polygon 
	 * area() function returns the polygon area given the number
	 * of sides and the side length 
	 * ==================================== 
	 * -in case N is even :-
	 * 
	 * Cos(ang/2)=(s/2)/(dis/2)
	 * Cos(ang/2)=s/dis 
	 * s=Cos(ang/2)*dis
	 * 
	 * -in case N is odd :-
	 * 
	 * theta = 0.5 * (N/2)* (2*PI)/N 
	 * theta = (N/2)* PI/N
	 * Sin(theta)=(dis/2)/hypot 
	 * hypot=dis/(2*Sin(theta))
	 * x=PI/n
	 * Sin(x)=(s/2)/hypot 
	 * s=2*hypot*Sin(x)
	 * 
	 * -in case N=3, it is just an Equilateral triangle with side length=the distance between the two points
	 *	
	 * an Image to make the solution clear => https://github.com/OmarKharouba/CompetitiveProgramming/blob/master/UVA/v_123/UVA12300.png 
	 */

	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out);

		while (true) {
			int xa = sc.nextInt();
			int ya = sc.nextInt();
			int xb = sc.nextInt();
			int yb = sc.nextInt();
			int n = sc.nextInt();
			if (xa + xb + ya + yb + n == 0)
				break;
			double dis = Math.sqrt((xa - xb) * (xa - xb) + (ya - yb)
					* (ya - yb));
			double ang = Math.PI / 2 - Math.PI / n;
			if (n % 2 == 0) {
				double s = dis * Math.cos(ang);
				pw.printf("%.6f\n", area(n, s));
			} else {
				if (n == 3)
					pw.printf("%.6f\n", 0.5 * Math.sin(Math.PI / 3) * dis * dis);
				else {
					double theta = (n / 2) * Math.PI / n;
					double hypot = dis / (2 * Math.sin(theta));
					double s = 2 * hypot * Math.sin(Math.PI / n);
					pw.printf("%.6f\n", area(n, s));
				}
			}
		}

		pw.flush();
		pw.close();
	}

	static double area(int n, double s) {
		return 0.25 * s * s * n / Math.tan(Math.PI / n);
	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
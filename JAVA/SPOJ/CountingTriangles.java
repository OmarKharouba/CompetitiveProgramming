
import java.io.PrintWriter;
import java.util.Scanner;
public class CountingTriangles {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		PrintWriter pr=new PrintWriter(System.out, true);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			long n=sc.nextInt();
			long r=n*(n+2)*(2*n+1)/8;
			pr.println(r);
		}
		sc.close();
	}
}
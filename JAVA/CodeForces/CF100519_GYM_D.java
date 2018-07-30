import java.util.Scanner;


public class CF100519_GYM_D {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int z=(int)Math.round(Math.sqrt(x*x+y*y));
		if(z*z==x*x+y*y)
			System.out.println("YES");
		else{
			int max=Math.max(x, y);
			int min=Math.min(x, y);
			z=(int)Math.round(Math.sqrt(max*max-min*min));
			if(z*z==max*max-min*min)
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
	}
}
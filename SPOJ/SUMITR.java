import java.util.*;
public class SUMITR {
	public static void main(String[]f){
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0){
			int n=s.nextInt();
			int [][] a=new int [n][];
			for(int i=0;i<n;i++){
				a[i]=new int [i+1];
				for(int j=0;j<=i;j++)
					a[i][j]=s.nextInt();
			}
			for(int i=n-2;i>=0;i--){
				for(int j=0;j<=i;j++)
					a[i][j]+=Math.max(a[i+1][j], a[i+1][j+1]);
			}
			System.out.println(a[0][0]);
		}
	}
}

package v_108;
import java.util.Scanner;


public class UVA10865 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			int []a=new int [n-1];
			int []b=new int [n-1];
			int x=0,y=0;
			int p=0;
			for(int i=0;i<n;i++){
				if(i==n/2){
					x=sc.nextInt();
					y=sc.nextInt();
				}else{
					a[p]=sc.nextInt();
					b[p]=sc.nextInt();
					p++;
				}
			}
			int c1=0,c2=0;
			for(int i=0;i<n-1;i++){
				if((a[i]>x && b[i]>y) || (a[i]<x && b[i]<y))
					c1++;
				else
					if((a[i]>x && b[i]<y) || (a[i]<x && b[i]>y))
						c2++;
			}
			System.out.println(c1+" "+c2);
		}
	}
}

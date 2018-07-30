import java.util.Arrays;


public class NumberofFiboCalls {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(fiboCallsMade(0)));
	}
	
	public static int[] fiboCallsMade(int n){
		int [] a=new int [n+2];
		int [] b=new int [n+2];
		a[0]=1;
		b[1]=1;
		for(int i=2;i<=n;i++){
			a[i]=a[i-1]+a[i-2];
			b[i]=b[i-1]+b[i-2];
		}
		return new int[]{a[n],b[n]};
	}
}

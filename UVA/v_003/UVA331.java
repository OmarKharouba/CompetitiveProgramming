package v_003;
import java.io.*;
import java.util.*;
public class UVA331 {
	static int n;
	static int[]a;
	static int cnt;
	static int max;
	public static void main(String[]args)throws Throwable{
		Scanner sc=new Scanner(System.in);
		int r=1;
		while(true){
			n=sc.nextInt();
			if(n==0)
				break;
			a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			max=n*(n-1)/2+1;
			cnt=0;
			if(!sorted())
				backtrack(0);
			System.out.println("There are "+cnt+" swap maps for input data set "+r+".");
			r++;
		}
	}
	
	public static boolean sorted(){
		for(int i=1;i<n;i++){
			if(a[i]<a[i-1])
				return false;
		}
		return true;
	}
	
	public static void backtrack(int c){
		if(sorted()){
			if(c==max)
				cnt++;
			else
				if(c<max){
					max=c;
					cnt=1;
				}
			return;
		}
		if(c>max-1)
			return;
		for(int i=0;i<n-1;i++){
			int j=i+1;
			int tmp=a[i];
			a[i]=a[j];
			a[j]=tmp;
			backtrack(c+1);
			tmp=a[i];
			a[i]=a[j];
			a[j]=tmp;
		}
	}
}

package v_100;

import java.io.*;
import java.util.*;
public class UVA10003 {
	static int[][]mem;
	static int[]a;
	public static void main(String[]args)throws Throwable{
		Scanner sc=new Scanner(System.in);
		while(true){
			int l=sc.nextInt();
			if(l==0)
				break;
			int n=sc.nextInt();
			mem=new int[n+2][n+2];
			a=new int[n+2];
			a[0]=0;
			a[n+1]=l;
			for(int i=0;i<n+2;i++){
				Arrays.fill(mem[i], -1);
			}
			for(int i=1;i<=n;i++){
				a[i]=sc.nextInt();
			}
			System.out.println("The minimum cutting is "+dp(0,n+1)+".");
		}
		sc.close();
	}
	
	public static int dp(int start,int end){
		if(start>=end-1)
			return 0;
		int ans=mem[start][end];
		if(ans!=-1)
			return ans;
		ans=Integer.MAX_VALUE;
		for(int i=start+1;i<end;i++){
			ans=Math.min(ans,a[end]-a[start]+dp(start, i)+dp(i, end));
		}
		return mem[start][end]=ans;
	}
}

import java.io.*;
import java.util.*;
public class BadNeighbors {
	public static void main(String[] args)throws Throwable {
		int [] a={ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
		System.out.println(maxDonations(a));
	}
	public static int maxDonations(int[] donations){
		int n=donations.length;
		int max=donations[0];
		for(int j=0;j<2;j++){
			int [][] dp=new int [n][2];
			if(j==0)
				dp[0][1]=donations[0];
			for(int i=1;i<n;i++){
				if(j==0 && i==n-1)
					break;
				dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]);
				dp[i][1]=donations[i]+dp[i-1][0];
				max=Math.max(max, Math.max(dp[i][0], dp[i][1]));
			}
		}
		return max;
	}
}
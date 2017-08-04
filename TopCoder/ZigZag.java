import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class ZigZag {
	public static void main(String[] args)throws Throwable {
		int [] a={ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		System.out.println(longestZigZag(a));
	}
	public static int longestZigZag(int[] sequence){
		int n=sequence.length;
		int [][] dp=new int [n][2];
		dp[0][0]=dp[0][1]=1;
		int max=1;
		for(int i=1;i<n;i++){
			dp[i][0]=dp[i][1]=1;
			for(int j=0;j<i;j++)
				if(sequence[j]>sequence[i])
					dp[i][0]=Math.max(dp[i][0], dp[j][1]+1);
				else
					if(sequence[j]<sequence[i])
						dp[i][1]=Math.max(dp[i][1], dp[j][0]+1);
			max=Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		return max;
	}
}
package v_110;

import java.io.*;
import java.util.*;
public class UVA11003 {
	static int n;
	static int[]weight;
	static int[]load;
	static int[][]mem;
	public static void main(String[]args)throws Throwable{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		while(true){
			n=sc.nextInt();
			if(n==0)
				break;
			weight=new int[n];
			load=new int[n];
			mem=new int[n][7001];
			for(int i=0;i<n;i++){
				Arrays.fill(mem[i], -1);
				weight[i]=sc.nextInt();
				load[i]=sc.nextInt();
			}
			System.out.println(dp(0, 7000));
		}
		sc.close();
	}
	
	public static int dp(int i,int l){
		if(l<0)
			return (int) (-1e9);
		if(i==n){
			if(l>=0)
				return 0;
			return (int) (-1e9);
		}
		if(mem[i][l]!=-1)
			return mem[i][l];
		return mem[i][l]=Math.max(1+dp(i+1, Math.min(load[i], l-weight[i])),dp(i+1, l));
	}
}

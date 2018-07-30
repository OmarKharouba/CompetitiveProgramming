package v_003;

import java.io.*;
import java.util.*;
public class UVA357 {
	static long[][]mem;
	static int[]a;
	public static void main(String[]args)throws Throwable{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		mem=new long[5][30001];
		for(int i=0;i<5;i++){
			Arrays.fill(mem[i], -1);
		}
		a=new int[]{1,5,10,25,50};
		String s="";
		for(int i=1000;i<=30000;i+=1000){
			dp(0,i);
		}
		while((s=bf.readLine())!=null){
			int n=Integer.parseInt(s);
			if(mem[0][n]>1)
				System.out.println("There are "+mem[0][n]+" ways to produce "+n+" cents change.");
			else
				System.out.println("There is only 1 way to produce "+n+" cents change.");
		}
	}
	
	public static long dp(int i,int sum){
		if(sum<0)
			return 0;
		if(i==5){
			if(sum==0)
				return 1;
			return 0;
		}
		if(mem[i][sum]!=-1)
			return mem[i][sum];
		return mem[i][sum]=dp(i, sum-a[i])+dp(i+1, sum);
	}
}

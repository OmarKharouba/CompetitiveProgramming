package v_005;

import java.io.*;
import java.util.*;
public class UVA562 {
	static int n;
	static int total;
	static int[][]mem;
	static int[] value;
	public static void main(String[]args)throws Throwable{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			n=Integer.parseInt(bf.readLine());
			mem=new int[n][n*500+1];
			value=new int[n];
			String s=bf.readLine();
			String [] sa=s.split(" ");
			total=0;
			for(int i=0;i<n;i++){
				value[i]=Integer.parseInt(sa[i]);
				Arrays.fill(mem[i], -1);
				total+=value[i];
			}
			pw.println(dp(0, 0));
		}
		pw.flush();
		pw.close();
		sc.close();
	}
	
	public static int dp(int i,int sum){
		if(i==n)
			return (Math.abs(2*sum-total));
		if(mem[i][sum]!=-1)
			return mem[i][sum];
		return mem[i][sum]=Math.min(dp(i+1, sum+value[i]),dp(i+1, sum));
	}
}

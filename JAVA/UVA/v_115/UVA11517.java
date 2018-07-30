package v_115;

import java.io.*;
import java.util.*;
public class UVA11517 {
	static int n;
	static int price;
	static int[][]mem;
	static int[] value;
	public static void main(String[]args)throws Throwable{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			price=Integer.parseInt(bf.readLine());
			n=Integer.parseInt(bf.readLine());
			mem=new int[n][20001];
			for(int i=0;i<n;i++)
				Arrays.fill(mem[i], -1);
			value=new int[n];
			for(int i=0;i<n;i++)
				value[i]=Integer.parseInt(bf.readLine());
			int ans=solve(0, 0);
			for(int i=0;i<n;i++)
				Arrays.fill(mem[i], -1);
			int c=solve2(0, ans);
			pw.println(ans+" "+c+"");
		}
		pw.flush();
		pw.close();
		sc.close();
	}
	
	public static int solve(int i,int money){
		if(money>=price)
			return money;
		if(i==n)
			return (int)(1e9);
		if(mem[i][money]!=-1)
			return mem[i][money];
		return mem[i][money]=Math.min(solve(i+1,money+value[i]),solve(i+1,money));
	}
	
	public static int solve2(int i,int money){
		if(money==0)
			return 0;
		if(money<0 || i==n)
			return (int)(1e9);
		if(mem[i][money]!=-1)
			return mem[i][money];
		return mem[i][money]=Math.min(solve2(i+1, money),1+solve2(i+1, money-value[i]));
	}
}

package v_108;

import java.io.*;
import java.util.*;
public class UVA10819 {
	static int n;
	static int m;
	static int[][]mem;
	static int[]price;
	static int[]value;
	public static void main(String[]args)throws Throwable{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		mem=new int[100][14000];
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			m=Integer.parseInt(sa[0]);
			n=Integer.parseInt(sa[1]);
			price=new int[n];
			value=new int[n];
			for(int i=0;i<n;i++){
				s=bf.readLine();
				sa=s.split(" ");
				price[i]=Integer.parseInt(sa[0]);
				value[i]=Integer.parseInt(sa[1]);
				Arrays.fill(mem[i], -1);
			}
			System.out.println(solve(0, 0));
		}
	}
	
	public static int solve(int i,int money){
		if(money>m+200)
			return (int)(-1e9);
		if(i==n){
			if(money>2000)
				money-=200;
			if(money>m)
				return (int)(-1e9);
			return 0;
		}
		int ans=mem[i][money];
		if(ans!=-1)
			return ans;
		ans=Math.max(value[i]+solve(i+1,money+price[i]), solve(i+1,money));
		return mem[i][money]=ans;
	}
}

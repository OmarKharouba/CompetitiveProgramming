package v_100;

import java.io.*;
import java.util.*;
public class UVA10036 {
	static int n;
	static int k;
	static boolean[][]mem;
	static boolean[][]v;
	static int[] value;
	public static void main(String[]args)throws Throwable{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			n=Integer.parseInt(sa[0]);
			k=Integer.parseInt(sa[1]);
			mem=new boolean[n+1][20001];
			v=new boolean[n+1][20001];
			value=new int[n];
			s=bf.readLine();
			sa=s.split(" ");
			for(int i=0;i<n;i++)
				value[i]=Integer.parseInt(sa[i]);
			boolean ans=solve(1,(value[0]%k+k)%k);
			pw.println(ans? "Divisible" : "Not divisible");
		}
		pw.flush();
		pw.close();
		sc.close();
	}
	
	public static boolean solve(int i,int mod){
		mod=(mod%k+k)%k;
		if(i==n)
			return (mod%k==0);
		if(v[i][mod])
			return mem[i][mod];
		v[i][mod]=true;
		return mem[i][mod]=solve(i+1,(mod+value[i])%k) || solve(i+1,((mod-value[i]+k)%k));
	}
}

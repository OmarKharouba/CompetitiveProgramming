package v_012;

import java.io.*;
import java.util.*;
public class UVA1213 {
	static int n;
	static int max;
	static int k;
	static int[][][]mem;
	static ArrayList<Integer> primes;
	public static void main(String[]args)throws Throwable{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		Scanner sc=new Scanner(System.in);
		primes =new ArrayList<Integer>();
		sieve(1121);
		max=primes.size();
		while(true){
			n=sc.nextInt();
			k=sc.nextInt();
			if(n==0 && k==0)
				break;
			mem=new int[max+1][1121][15];
			for(int i=0;i<=max;i++)
				for(int j=0;j<1121;j++)
					Arrays.fill(mem[i][j], -1);
			pw.println(dp(0,0,0));
		}
		pw.flush();
		pw.close();
		sc.close();
	}
	
	public static int dp(int i,int sum,int cnt){
		if(cnt==k){
			if(sum==n)
				return 1;
			return 0;
		}
		if(i==max || sum+primes.get(i)>n)
			return 0;
		if(mem[i][sum][cnt]!=-1)
			return mem[i][sum][cnt];
		int ans=dp(i+1, sum+primes.get(i),cnt+1)+dp(i+1,sum,cnt);
		return mem[i][sum][cnt]=ans;
	}
	
	public static void sieve(int n){
		boolean [] prime=new boolean[n];
		Arrays.fill(prime, true);
		prime[0]=false;
		prime[1]=false;
		for(int i=2;i*i<=n;i++){
			if(prime[i]){
				for(int j=2*i;j<n;j+=i){
					prime[j]=false;
				}
			}
		}
		for(int i=0;i<n;i++)
			if(prime[i])
				primes.add(i);
	}
}

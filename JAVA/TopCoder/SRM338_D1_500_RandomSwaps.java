package topcoder;

public class SRM338_D1_500_RandomSwaps {
	
	public static void main(String[] args) {
		System.out.println(getProbability(100, 500, 3, 3));
	}
	
	public static double getProbability(int arrayLength, int swapCount, int a, int b){
		n=arrayLength;
		k=swapCount;
		total=n*(n-1)/2;
		other=total-(n-1);
		mem=new Double [2][k];
		for(int i=k-1;i>=0;i-=10){
			dp(0, i);
			dp(1, i);
		}
		return dp(a==b? 1 : 0, 0);
	}
	static int n,k,total,other;
	static Double [][] mem;
	
	static double dp(int in,int i){
		if(i==k)
			return in;
		if(mem[in][i]!=null)
			return mem[in][i];
		double ans=(1.0*other/total)*dp(in, i+1);
		if(in==1){
			ans+=(1.0*(n-1)/total)*dp(0, i+1);
		}else{
			ans+=(1.0/total)*dp(1, i+1);
			ans+=(1.0*(n-2)/total)*dp(0, i+1);
		}
		return mem[in][i]=ans;
	}
}

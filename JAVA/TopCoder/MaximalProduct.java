import java.util.Arrays;


public class MaximalProduct {
	
	public static void main(String[] args) {
		System.out.println(maximalProduct(10, 10));
	}
	
	public static long maximalProduct(int s, int k){
		mem=new long [s+1][k+1];
		for(int i=0;i<=s;i++)
			Arrays.fill(mem[i], -1);
		return dp(s, k);
	}
	static long [][] mem;
	public static long dp(int s,int k){
		if(k==0)
			return 1;
		if(s<=0)
			return 0;
		if(mem[s][k]!=-1)
			return mem[s][k];
		
		long ans=0;
		for(int i=s;i>=1;i--)
			ans=Math.max(ans, 1L*i*dp(s-i, k-1));
		return mem[s][k]=ans;
	}
}

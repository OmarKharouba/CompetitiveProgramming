package topcoder;

public class TCO10_QR4_BankLottery {
	public static void main(String[] args) {
		int [] a={2,2,2};
		System.out.println(expectedAmount(a, 1, 2));
	}
	
	public static double expectedAmount(int[] accountBalance, int weeklyJackpot, int weekCount){
		n=weekCount;
		add=weeklyJackpot;
		me=accountBalance[0];
		for(int i=0;i<accountBalance.length;i++)
			total+=accountBalance[i];
		mem=new Double [n+1][n+1];
		return dp(0, 0);
	}
	static int total,me,n,add;
	static Double [][] mem;
	
	static double dp(int i,int c){
		if(i==n)
			return me+c*add;
		if(mem[i][c]!=null)
			return mem[i][c];
		double p=1.0*(me+c*add)/(total+i*add);
		double ans=p*dp(i+1, c+1)+(1-p)*dp(i+1, c);
		return mem[i][c]=ans;
	}
}

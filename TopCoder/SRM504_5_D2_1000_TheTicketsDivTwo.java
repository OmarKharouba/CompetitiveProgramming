package topcoder;

public class SRM504_5_D2_1000_TheTicketsDivTwo {
	
	public static void main(String[] args) {
		System.out.println(find(4, 2, 10));
	}
	
	public static double find(int n, int m, int k){
		nn=n;
		mm=m-1;
		kk=k;
		mem=new Double [k][n][1<<n];
		return dp(0, 0, (1<<n)-1);
	}
	static int nn,kk,mm;
	static Double [][][] mem;
	
	static double dp(int i,int last,int msk){
		if(i==kk || Integer.bitCount(msk)==1)
			return last==mm? 1 : 0;
		if(mem[i][last][msk]!=null)
			return mem[i][last][msk];
		double ans=0;
		if(last==mm)
			ans+=1.0/6;
		int newLast=(last+1)%nn;
		while((msk & (1<<newLast))==0)
			newLast=(newLast+1)%nn;
		ans+=0.5*dp(i+1, newLast, msk);
		ans+=(1.0/3)*dp(i+1, newLast, msk-(1<<last));
		return mem[i][last][msk]=ans;
	}

}

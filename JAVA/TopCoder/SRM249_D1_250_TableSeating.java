package topcoder;

public class SRM249_D1_250_TableSeating {
	public static void main(String[] args) {
		int [] a={0,100};
		System.out.println(getExpected(4, a));
	}
	
	public static double getExpected(int numTables, int[] probs){
		n=numTables;
		m=probs.length;
		mem=new Double [1<<n];
		p=new double [m];
		for(int i=0;i<m;i++)
			p[i]=probs[i]/100.0;
		return dp(0);
	}
	static Double [] mem;
	static int n,m;
	static double [] p;
	
	static double dp(int msk){
		if(mem[msk]!=null)
			return mem[msk];
		double ans=0;
		for(int i=0;i<m;i++){
			int ops=0;
			double tmp=0;
			for(int j=0;j+i<n;j++){
				boolean can=true;
				for(int k=0;k<=i;k++)
					if((msk & (1<<(j+k)))!=0)
							can=false;
				if(can){
					ops++;
					int newMsk=msk;
					for(int k=0;k<=i;k++)
						newMsk |=(1<<(j+k));
					tmp+=p[i]*(i+1+dp(newMsk));
				}
			}
			if(ops>0)
				ans+=tmp/ops;
		}
		return mem[msk]=ans;
	}
	
}

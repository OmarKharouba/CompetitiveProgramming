package topcoder;

public class SRM339_D1_500_TestBettingStrategy {
	
	public static void main(String[] args) {
		System.out.println(winProbability(990, 1000, 50, 50));
	}
	
	public static double winProbability(int initSum, int goalSum, int rounds, int prob){
		double [][][][] mem=new double [2][2][2*goalSum+1][11];
		int p=0;
		for(int w=0;w<2;w++)
			for(int t=goalSum;t<=2*goalSum;t++)
				for(int pre=0;pre<11;pre++)
					mem[0][w][t][pre]=1.0;
		for(int i=rounds-1;i>=0;i--){
			p=1-p;
			for(int w=0;w<2;w++)
				for(int t=0;t<=2*goalSum;t++)
					for(int pre=0;pre<11;pre++){
						if(t>=goalSum)
							mem[p][w][t][pre]=1.0;
						else{
							mem[p][w][t][pre]=0.0;
							if(w==1){
								if(t>0)
									mem[p][w][t][pre]+=(prob/100.0)*mem[1-p][1][t+1][0]+(1-prob/100.0)*mem[1-p][0][t-1][0];
							}else{
								if(t>=(1<<(pre+1)))
									mem[p][w][t][pre]+=(prob/100.0)*mem[1-p][1][t+(1<<(pre+1))][pre+1]+(1-prob/100.0)*mem[1-p][0][t-(1<<(pre+1))][pre+1];
							}
						}
					}
		}
		return mem[p][1][initSum][0];
	}	
}

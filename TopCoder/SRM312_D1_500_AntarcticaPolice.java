package topcoder;

public class SRM312_D1_500_AntarcticaPolice {
	public static void main(String[] args) {
		int [] a={1,99,100};
		String [] b={"NNN","NNN","YYN"};
		System.out.println(minAverageCost(a, b));
	}
	
	public static double minAverageCost(int[] costs, String[] roads){
		int n=costs.length;
		boolean [][] reach=new boolean [n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(roads[i].charAt(j)=='Y')
					reach[i][j]=true;
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					reach[i][j] |=(reach[i][k] && reach[k][j]);
		boolean [] vis=new boolean [n];
		int compIdx=0;
		int [] comp=new int [n];
		int [] compMin=new int [n];
		for(int i=0;i<n;i++){
			if(!vis[i]){
				comp[i]=compIdx;
				compMin[compIdx]=costs[i];
				for(int j=0;j<n;j++)
					if(reach[i][j] && reach[j][i]){
						vis[j]=true;
						comp[j]=compIdx;
						compMin[compIdx]=Math.min(compMin[compIdx], costs[j]);
					}
				compIdx++;
			}
		}
		int [] compDeg=new int [compIdx];
		int [] cntAll=new int [1001];
		for(int i=0;i<n;i++){
			cntAll[costs[i]]++;
			for(int j=0;j<n;j++)
				if(reach[i][j] && comp[i]!=comp[j])
					compDeg[comp[j]]++;
		}
		int [] cntTake=new int [1001];
		int sum=0,cnt=0;
		for(int i=0;i<compIdx;i++)
			if(compDeg[i]==0){
				cnt++;
				sum+=compMin[i];
				cntTake[compMin[i]]++;
			}
		double avg=1.0*sum/cnt;
		for(int i=1;i<=1000;i++){
			if(i<=avg){
				sum+=i*(cntAll[i]-cntTake[i]);
				cnt+=cntAll[i]-cntTake[i];
				avg=1.0*sum/cnt;
			}else
				break;
		}
		return avg;
	}
}

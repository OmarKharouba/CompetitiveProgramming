import java.util.Arrays;


public class BioScore {
	
	public static void main(String[] args) {
		String [] a ={"ACTGACTGACTG","GACTTGACCTGA"};
		System.out.println(maxAvg(a));
	}
	
	public static double maxAvg(String[] knownSet){
		int n=knownSet.length;
		int m=knownSet[0].length();
		int total=n*(n-1)/2;
		cnt=new int [4][4];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==j)
					continue;
				for(int k=0;k<m;k++){
					int x=Math.min(getNum(knownSet[i].charAt(k)), getNum(knownSet[j].charAt(k)));
					int y=Math.max(getNum(knownSet[i].charAt(k)), getNum(knownSet[j].charAt(k)));
					cnt[x][y]++;
				}
			}
		}
		mem=new int [11][500];
		for(int [] x : mem)
			Arrays.fill(x, 1000);
		return 0.5*dp(0,0)/total;
	}
	static int [][] cnt;
	static int [] a={0,0,0,0,1,1,1,2,2,3};
	static int [] b={0,1,2,3,1,2,3,2,3,3};
	static int [][] mem;
	static int offset=200;
	static int inf=(int)1e8;
	public static int dp(int i,int sum){
		if(i==10){
			if(sum==0)
				return 0;
			return -inf;
		}
		if(mem[i][sum+offset]!=1000)
			return mem[i][sum+offset];
		int ans=-inf;
		for(int j=-10;j<=10;j++){
			if(a[i]==b[i] && j<=0)
				continue;
			if(a[i]==b[i])
				ans=Math.max(ans, j*cnt[a[i]][b[i]]+dp(i+1, sum+j));
			else
				ans=Math.max(ans, j*cnt[a[i]][b[i]]+dp(i+1, sum+2*j));
		}
		return mem[i][sum+offset]=ans;
	}
	
	public static int getNum(char c){
		switch(c){
		case 'A' : return 0;
		case 'C' : return 1;
		case 'T' : return 2;
		case 'G' : return 3;
		}
		return -1;
	}
	

}

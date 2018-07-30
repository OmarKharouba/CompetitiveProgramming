import java.util.Arrays;


public class MarblesRegroupingHard {
	public static void main(String[] args) {
		String [] a={"97 94 0 99","1 72 46 45","0 10 47 75","0 92 76 20","2 25 98 22"};
		System.err.println(minMoves(a));
	}
	
	public static int minMoves(String[] boxes){
		n=boxes.length;
		m=boxes[0].split(" ").length;
		a=new int [n][m];
		sum=new int [n];
		boolean [] v=new boolean [m];
		for(int i=0;i<n;i++){
			String [] sa=boxes[i].split(" ");
			for(int j=0;j<m;j++){
				a[i][j]=Integer.parseInt(sa[j]);
				sum[i]+=a[i][j];
				if(a[i][j]>0){					
					if(!v[j])
						used++;
					v[j]=true;
				}
			}
		}
		mem=new int [n+1][1<<15];
		for(int [] x : mem)
			Arrays.fill(x, -1);
		return dp(0, 0);
	}
	static int [] sum;
	static int n,m,used;
	static int [][] a;
	static int [][] mem;
	static int inf=(int)1e8;
	
	public static int dp(int i,int msk){
		if(i==n){
			if(Integer.bitCount(msk)==used)
				return 0;
			return inf;
		}
		if(mem[i][msk]!=-1)
			return mem[i][msk];
		int ans=sum[i]+dp(i+1, msk);
		for(int j=0;j<m;j++){
			if((msk & (1<<j))==0)
				ans=Math.min(ans, sum[i]-a[i][j]+dp(i+1, msk | (1<<j)));
		}
		return mem[i][msk]=ans;
	}
}

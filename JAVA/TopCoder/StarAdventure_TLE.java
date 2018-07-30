import java.util.Arrays;


public class StarAdventure_TLE {
	public static void main(String[] args) {
		String [] a=	
			{"0123456789",
				 "1123456789",
				 "2223456789",
				 "3333456789",
				 "4444456789",
				 "5555556789",
				 "6666666789",
				 "7777777789",
				 "8888888889",
				 "9999999999"}
;
		
		System.out.println(mostStars(a));
		
	}
	
	public static int mostStars(String[] level){
		n=level.length;
		m=level[0].length();
		int sum=0;
		a=new int [n][m];
		cum=new int [n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				cum[i][j]=a[i][j]=Integer.parseInt(""+level[i].charAt(j));
				sum+=a[i][j];
			}
		for(int i=0;i<n;i++)
			for(int j=1;j<m;j++)
				cum[i][j]+=cum[i][j-1];
		mem=new int [n+1][m+1][m+1][m+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=m;j++)
				for(int k=0;k<=m;k++)
					Arrays.fill(mem[i][j][k],-1);
		if(n<3 || m<3)
			return sum;
		else{
			int [][][][] dp=new int [n][m][m][m];
			
			for(int i=0;i<m;i++)
				for(int j=i+1;j<m;j++)
					for(int k=j+1;k<m;k++)
						dp[n-1][i][j][k]=cum[n-1][m-1]-(i>0? cum[n-1][i-1] : 0);
			
			return dp(0, 0, 1, 2);
		}
	}
	static int [][] cum;
	static int [][]a;
	static int [][][][] mem;
	static int n,m;
	public static int dp(int r,int x,int y,int z){
		if(r==n-1){
			int sum=0;
			for(int i=x;i<m;i++)
				sum+=a[r][i];
			return sum;
		}
		if(mem[r][x][y][z]!=-1)
			return mem[r][x][y][z];
		int ans=0;
		for(int k=z;k<m;k++)
			for(int j=y;j<z;j++)
				for(int i=x;i<y;i++){
					int sum=0;
					sum+=cum[r][i]-(x>0? cum[r][x-1] : 0);
					sum+=cum[r][j]-cum[r][y-1];
					sum+=cum[r][k]-cum[r][z-1];
					sum+=dp(r+1, i, j, k);
					ans=Math.max(ans, sum);
				}
		return mem[r][x][y][z]=ans;
	}
	
}

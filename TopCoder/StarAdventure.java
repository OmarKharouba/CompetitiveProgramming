import java.util.Arrays;


public class StarAdventure {
	public static void main(String[] args) {
		String [] a={"012", "012", "012", "012", "012", "012", "012"};
		System.out.println(mostStars(a));
	}
	
	public static int mostStars(String[] level){
		n=level.length;
		m=level[0].length();
		a=new int [n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				a[i][j]=Integer.parseInt(""+level[i].charAt(j));
		mem=new int [n+1][m+1][n+1][n+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=m;j++)
				for(int k=0;k<=n;k++)
					Arrays.fill(mem[i][j][k],-1);
		return dp(0, 0, 0, 0);
	}
	static int [] dx={0,1},dy={1,0};
	static int [][]a;
	static int [][][][] mem;
	static int n,m;
	public static int dp(int r1,int c1,int r2,int r3){
		int c2=r1+c1-r2;
		int c3=r1+c1-r3;
		
		if(r1==n-1 && c1==m-1 && r2==n-1 && r3==n-1)
			return a[r1][c1];
		
		if(mem[r1][c1][r2][r3]!=-1)
			return mem[r1][c1][r2][r3];
		int ans=a[r1][c1];
		if(r2!=r1 || c2!=c1)
			ans+=a[r2][c2];
		if((r3!=r1 || c3!=c1) && (r3!=r2 || c3!=c2))
			ans+=a[r3][c3];
		int best=0;
		for(int i=0;i<2;i++)
			for(int j=0;j<2;j++)
				for(int k=0;k<2;k++){
					int r11=r1+dx[i],c11=c1+dy[i];
					int r22=r2+dx[j],c22=c2+dy[j];
					int r33=r3+dx[k],c33=c3+dy[k];
					if(valid(r11, c11) && valid(r22, c22) && valid(r33, c33))
						best=Math.max(best, dp(r11, c11, r22, r33));
				}
		
		return mem[r1][c1][r2][r3]=ans+best;
	}
	
	public static boolean valid(int r,int c){
		return r>=0 && r<n && c>=0 && c<m;
	}
	
}

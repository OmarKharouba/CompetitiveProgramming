import java.util.Arrays;


public class ChessMetric {
	public static void main(String[] args) {
		int [] a={0,0};
		int [] b={0,99};
		System.out.println(howMany(100, a, b, 50));
	}
	
	public static long howMany(int size, int[] start, int[] end, int numMoves){
		n=size;
		endX=end[0];
		endY=end[1];
		mem=new long [n+1][n+1][numMoves+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=n;j++)
				Arrays.fill(mem[i][j], -1);
		return dp(start[0], start[1], numMoves);
	}
	static int endX,endY;
	static int [] dx={0,0,1,1,1,-1,-1,-1,2,2,1,1,-2,-2,-1,-1};
	static int [] dy={1,-1,0,1,-1,0,1,-1,1,-1,2,-2,1,-1,2,-2};
	static int n;
	static long [][][] mem;
	public static long dp(int i,int j,int c){
		if(c==0)
			return (i==endX && j==endY)? 1 : 0;
		if(mem[i][j][c]!=-1)
			return mem[i][j][c];
		long ans=0;
		for(int k=0;k<dx.length;k++){
			int x=i+dx[k];
			int y=j+dy[k];
			if(x>=0 && x<n && y>=0 && y<n)
				ans+=dp(x, y, c-1);
		}
		return mem[i][j][c]=ans;
	}
	
}

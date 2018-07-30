package topcoder;

import java.util.Arrays;

public class PalindromePartition {
	
	public static void main(String[] args) {
		String [] a={"QWERTY","TREWQWERT"};
		System.out.println(partition(a));
	}
	
	public static int partition(String[] s){
		String t="";
		for(String tt : s)
			t+=tt;
		int ans=0;
		a=t.toCharArray();
		n=t.length();
		pal=new boolean [n][n];
		for(int i=0;i<n;i++){
			pal[i][i]=true;
			if(i<n-1)
				pal[i][i+1]=a[i]==a[i+1];
		}
		for(int i=n-1;i>=0;i--)
			for(int j=i+2;j<n;j++)
				pal[i][j]=a[i]==a[j] && pal[i+1][j-1];
		mem=new int [n][n];
		for(int [] x : mem)
			Arrays.fill(x, -1);
		return dp(0, 0);
	}
	static int n;
	static char [] a;
	static boolean [][] pal;
	static int [][] mem;
	static int inf=(int)1e8;
	static int dp(int i,int j){
		if(i==n)
			return 0;
		if(mem[i][j]!=-1)
			return mem[i][j];
		int ans=inf;
		if(pal[j][i])
			ans=Math.min(ans, 1+dp(i+1, i+1));
		if(i<n-1)
			ans=Math.min(ans, dp(i+1, j));
		return mem[i][j]=ans;
	}
	
}

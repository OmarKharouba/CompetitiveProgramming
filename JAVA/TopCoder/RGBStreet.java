import java.util.Arrays;


public class RGBStreet {
	
	static int [] a,b,c;
	static int n;
	static int [][]mem;
	static int inf=(int)(1e8);
	public static int estimateCost(String[] houses){
		n=houses.length;
		a=new int [n];
		b=new int [n];
		c=new int [n];
		
		for(int i=0;i<n;i++){
			String [] sa=houses[i].split(" ");
			a[i]=Integer.parseInt(sa[0]);
			b[i]=Integer.parseInt(sa[1]);
			c[i]=Integer.parseInt(sa[2]);
		}
		mem=new int [5][n+1];
		for(int i=0;i<5;i++)
			Arrays.fill(mem[i], -1);
		return dp(0, 3);
	}
	
	public static int dp(int i,int last){
		if(i==n)
			return 0;
		if(mem[last][i]!=-1)
			return mem[last][i];
		int ans=inf;
		if(last!=0)
			ans=Math.min(ans, a[i]+dp(i+1, 0));
		if(last!=1)
			ans=Math.min(ans, b[i]+dp(i+1, 1));
		if(last!=2)
			ans=Math.min(ans, c[i]+dp(i+1, 2));
		return mem[last][i]=ans;
	}
}

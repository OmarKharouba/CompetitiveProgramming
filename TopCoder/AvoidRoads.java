import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;


public class AvoidRoads {
	public static void main(String[] args) {
		String [] a={};
		System.out.println(numWays(35, 31, a));
	}
	
	public static long numWays(int width, int height, String[] bad){
		w=width;
		h=height;
		set=new HashSet<String>();
		mem=new long [w+1][h+1];
		for(int i=0;i<=w;i++)
			Arrays.fill(mem[i], -1);
		for(String s : bad)
			set.add(s);
		return dp(0, 0);
	}
	static long [][]mem;
	static int w,h;
	static HashSet<String> set;
	public static long dp(int i,int j){
		if(i==w && j==h)
			return 1;
		if(mem[i][j]!=-1)
			return mem[i][j];
		long ans=0;
		if(i<w && !set.contains(i+" "+j+" "+(i+1)+" "+j) && !set.contains((i+1)+" "+j+" "+i+" "+j))
			ans+=dp(i+1, j);
		if(j<h  && !set.contains(i+" "+j+" "+i+" "+(j+1)) && !set.contains(i+" "+(j+1)+" "+i+" "+j))
			ans+=dp(i, j+1);
		return mem[i][j]=ans;
			
	}

}

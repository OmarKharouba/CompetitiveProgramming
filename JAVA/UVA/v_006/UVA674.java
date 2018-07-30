package v_006;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
public class UVA674 {
	static int[] arr={50,25,10,5,1};
	static int n;
	static int [][]mem;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		mem=new int[5][8001];
		for(int i=0;i<5;i++)
			Arrays.fill(mem[i], -1);
		for(int i=1000;i<=8000;i+=1000)
			dp(0,i);
		String s="";
		while((s=bf.readLine())!=null){
			n=Integer.parseInt(s);
			System.out.println(dp(0,n));
		}
	}
	
	public static int dp(int i,int sum){
		if(sum==0)
			return 1;
		if(i==5)
			return 0;
		if(mem[i][sum]!=-1)
			return mem[i][sum];
		int ans=dp(i+1, sum);
		if(sum-arr[i]>=0)
			ans+=dp(i,sum-arr[i]);
		return mem[i][sum]=ans;
	}
}

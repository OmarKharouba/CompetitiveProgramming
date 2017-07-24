package v_103;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA10313 {
	
	static int n=300;
	static long [][][]mem;
	
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		String s="";
		
		mem=new long [301][301][301];
		for(int i=0;i<=300;i++)
			for(int j=0;j<=300;j++)
				Arrays.fill(mem[i][j], -1);
		
		while((s=br.readLine())!=null){
			String []sa=s.split(" ");
			
			int x=Integer.parseInt(sa[0]);
			int start=0,end=x;
			
			if(sa.length==2)
				end=Integer.parseInt(sa[1]);
			else
				if(sa.length==3){
					start=Integer.parseInt(sa[1]);
					end=Integer.parseInt(sa[2]);
				}
			
			long ans=0;
			for(int i=Math.min(start, 300);i<=Math.min(end, 300);i++)
				ans+=dp(0, x, i);
			pw.println(ans);
		}
		
		pw.flush();
		pw.close();
	}
	
	public static long dp(int i,int value,int cnt){
		
		if(i==n){
			if(cnt==0 && value==0)
				return 1;
			return 0;
		}
		
		
		if(mem[i][value][cnt]!=-1)
			return mem[i][value][cnt];
		
		
		long ans=0;
		
		if(cnt>0 && value>=(i+1))
			ans+=dp(i, value-i-1, cnt-1);
		
		ans+=dp(i+1, value, cnt);
		
		
		return mem[i][value][cnt]=ans;
		
	}
}

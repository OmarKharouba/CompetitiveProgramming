package codeforces;
import java.io.*;
import java.util.*;
public class CF752_D2_E {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int k=sc.nextInt();
		int mx=(int)1e7+5;
		long [] c=new long [mx];
		long sum=0;
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			sum+=x;
			c[x]++;
		}
		int ans=-1;
		if(sum>=k){
			int idxMax=0;
			int idxAns=0;
			long cnt=0;
			boolean f=true;
			for(int i=mx-1;i>=0;i--){
				if(c[i]>0){
					if(f)
						idxMax=i;
					f=false;
					cnt+=c[i];
				}
			}
			while(cnt<k){
				long replace=Math.min(c[idxMax], k-cnt);
				cnt+=replace;
				c[idxMax/2]+=replace;
				c[(idxMax+1)/2]+=replace;
				c[idxMax]-=replace;
				while(c[idxMax]==0)
					idxMax--;
			}
			cnt=0;
			for(int i=mx-1;i>=0;i--){
				if(cnt+c[i]<k)
					cnt+=c[i];
				else{
					c[i]=k-cnt;
					idxAns=i;
					break;
				}
			}
			ans=idxAns;
			while(idxMax/2>=ans){
				c[idxMax/2]+=c[idxMax];
				c[(idxMax+1)/2]+=c[idxMax];
				long remove=c[idxMax];
				c[idxMax]=0;
				while(remove>0){
					if(c[idxAns]<=remove){
						remove-=c[idxAns];
						c[idxAns]=0;
						while(c[idxAns]==0)
							idxAns++;
					}else{
						c[idxAns]-=remove;
						remove=0;
					}
				}
				while(c[idxMax]==0)
					idxMax--;
				ans=idxAns;
			}
		}
		
		pw.println(ans);
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}
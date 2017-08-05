package PKU;

import java.io.*;
import java.util.*;
public class PKU3145 {
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out, true);
		int id=1;
		while(true){
			int t=sc.nextInt();
			if(t==0)
				break;
			if(id>1)
				pw.println();
			pw.println("Case "+(id++)+":");
			ft=new int [mx];
			int [] time=new int [mx];
			int [] best=new int [1001];
			int [] ans=new int [1001];
			for(int i=0;i<=1000;i++)
				best[i]=i;
			Arrays.fill(ans, -1);
			int tt=0;
			for(int i=1;i<=t;i++){
				char c=sc.next().charAt(0);
				int x=sc.nextInt();
				if(c=='B'){
					tt++;
					for(int j=1;j<=1000;j++){
						int mod=x%j;
						if(mod<=best[j]){
							best[j]=mod;
							ans[j]=tt;
						}
					}
					update(x, 1);
					time[x]=tt;
				}else{
					if(x<=1000)
						pw.println(ans[x]);
					else{
						int ret=-1;
						int low=x;
						for(int j=0;x*j<mx;j++){
							int sum=j>0? get(j*x-1) : 0;
							int start=j*x,end=Math.min(mx-1, (j+1)*x-1),tmp=-1;
							while(start<=end){
								int mid=((start+end)>>1);
								if(get(mid)>sum){
									tmp=mid;
									end=mid-1;
								}else
									start=mid+1;
							}
							if(tmp!=-1){
								int mod=tmp%x;
								if(mod<low){
									low=mod;
									ret=time[tmp];
								}
								if(mod==low && time[tmp]>ret)
									ret=time[tmp];
							}
						}
						pw.println(ret);
					}
				}
			}
			
			
		}
		
		pw.flush();
		pw.close();
	}
	
	static int mx=(int)1e6+5;
	static int [] ft;
	
	static void update(int idx,int val){
		while(idx<mx){
			ft[idx]+=val;
			idx+=(idx & -idx);
		}
	}
	static int get(int idx){
		int ans=0;
		while(idx>0){
			ans+=ft[idx];
			idx-=(idx & -idx);
		}
		return ans;
	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			try {
				br = new BufferedReader(new FileReader(new File("test.in")));
			} catch (Exception e) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
}
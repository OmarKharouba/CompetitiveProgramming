package v_113;

import java.io.*;
import java.util.*;

public class UVA11381H {
	public static void main(String[] args) throws Throwable {
		MyScanner sc = new MyScanner();
		PrintWriter pw = new PrintWriter(System.out, true);

		int tc = sc.nextInt();
		while (tc-- > 0) {
			int[][] map = new int[26][26];
			char[] s = sc.next().toCharArray();
			char[] t = sc.next().toCharArray();
			int n = s.length;
			int m = t.length;
			for (int i = 0; i < n - 1; i++) {
				if (map[s[i] - 'a'][s[i + 1] - 'a'] == 0)
					map[s[i] - 'a'][s[i + 1] - 'a'] = (i + 1) * (i + 1);
			}
			N=m;
			M=m;
			init();
			int NO=(int)1e8;
			for (int i = 0; i <N; i++) {
				Arrays.fill(a[i+1], NO);
				for (int j = i + 1; j < N; j++)
					if (map[t[i] - 'a'][t[j] - 'a'] > 0)
						a[i+1][j+1] =map[t[i] - 'a'][t[j] - 'a'];
			}
			hungarian();
			long cost=0,match=0;
			for(int i=1;i<=N;i++)
				if(a[i][ans[i]]!=NO){
					match++;
					cost+=a[i][ans[i]];
				}
			pw.println((N-match)+" "+cost);
		}

		pw.flush();
		pw.close();
	}

	// N<=M
		static int N,M;
		static int inf=(int)1e9;
		static int [][] a;
		static int [] u,v,p,way,minv,ans;
		static boolean [] used;
		
		static void init(){
			a=new int [N+1][M+1];
			u=new int [N+1];
			ans=new int [N+1];
			v=new int [M+1];
			p=new int [M+1];
			way=new int [M+1];
			minv=new int [M+1];
			used=new boolean [M+1];
		}
		
		static void hungarian(){
			for(int i=1;i<=N;i++){
				p[0]=i;
				int j0=0;
				Arrays.fill(minv, inf);
				Arrays.fill(used, false);
				do {
					used[j0]=true;
					int i0=p[j0],delta=inf,j1=0;
					for(int j=1;j<=M;j++)
						if(!used[j]){
							int cur=a[i0][j]-u[i0]-v[j];
							if(cur<minv[j]){
								minv[j]=cur;
								way[j]=j0;
							}
							if(minv[j]<delta){
								delta=minv[j];
								j1=j;
							}
						}
					for(int j=0;j<=M;j++)
						if(used[j]){
							u[p[j]]+=delta;
							v[j]-=delta;
						}
						else
							minv[j]-=delta;
					j0=j1;
				} while (p[j0]!=0);
				do {
					int j1=way[j0];
					p[j0]=p[j1];
					j0=j1;
				} while (j0!=0);
			}
			for(int j=1;j<=M;j++)
				ans[p[j]]=j;
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
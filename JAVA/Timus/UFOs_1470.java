
import java.io.*;
import java.util.*;
public class UFOs_1470 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		ft=new long [n+1][n+1][n+1];
		
		while(true){
			int m=sc.nextInt();
			if(m==3)
				break;
			if(m==1){
				int x=sc.nextInt()+1;
				int y=sc.nextInt()+1;
				int z=sc.nextInt()+1;
				int k=sc.nextInt();
				update(x, y, z, k);
			}else{
				int x1=sc.nextInt()+1;
				int y1=sc.nextInt()+1;
				int z1=sc.nextInt()+1;
				int x2=sc.nextInt()+1;
				int y2=sc.nextInt()+1;
				int z2=sc.nextInt()+1;
				
				long ans=get(x2, y2, z2);
				
				if(x1>1)
					ans-=get(x1-1, y2, z2);

				if(y1>1)
					ans-=get(x2, y1-1, z2);

				if(z1>1)
					ans-=get(x2, y2, z1-1);

				if(y1>1 && z1>1)
					ans+=get(x2, y1-1, z1-1);
				
				if(x1>1 && z1>1)
					ans+=get(x1-1, y2, z1-1);

				if(x1>1 && y1>1)
					ans+=get(x1-1, y1-1, z2);

				if(x1>1 && y1>1 && z1>1)
					ans-=get(x1-1, y1-1, z1-1);

				pw.println(ans);
			}
		}
		
		pw.flush();
		pw.close();
	}
	static int n;
	static long [][][] ft;
	
	public static void update(int x,int y,int z,int val){
		while(x<=n){
			updateY(x, y, z, val);
			x+=(x & -x);
		}
	}
	
	public static void updateY(int x,int y,int z,int val){
		while(y<=n){
			updateZ(x, y, z, val);
			y+=(y & -y);
		}
	}
	
	public static void updateZ(int x,int y,int z,int val){
		while(z<=n){
			ft[x][y][z]+=val;
			z+=(z & -z);
		}
	}
	
	public static long get(int x,int y,int z){
		long ans=0;
		while(x>0){
			ans+=getY(x,y,z);
			x-=(x & -x);
		}
		return ans;
	}
	
	public static long getY(int x,int y,int z){
		long ans=0;
		while(y>0){
			ans+=getZ(x,y,z);
			y-=(y & -y);
		}
		return ans;
	}
	
	public static long getZ(int x,int y,int z){
		long ans=0;
		while(z>0){
			ans+=ft[x][y][z];
			z-=(z & -z);
		}
		return ans;
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
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
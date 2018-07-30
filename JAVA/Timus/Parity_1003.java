
import java.io.*;
import java.util.*;
public class Parity_1003 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		while(true){
			int l=sc.nextInt();
			if(l==-1)
				break;
			int n=sc.nextInt();
			int [] a=new int [n];
			int [] b=new int [n];
			int [] p=new int [n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
				b[i]=sc.nextInt();
				p[i]=sc.next().equals("even")? 0 : 1;
				for(int j=0;j<i;j++){
					if(b[i]>=a[j] && b[j]>=a[i]){
						
					}
				}
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
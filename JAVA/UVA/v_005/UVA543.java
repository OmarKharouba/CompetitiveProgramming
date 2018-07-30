package v_005;
import java.io.*;
import java.util.*;
public class UVA543 {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		int max=(int)1e6+5;
		sieve(max);
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			int x=-1,y=-1;
			for(int i=0;i<primes.size() && primes.get(i)<n;i++){
				if(isPrime[n-primes.get(i)]){
					x=primes.get(i);
					y=n-primes.get(i);
					break;
				}
			}
			if(x==-1)
				pw.println("‘Goldbach's conjecture is wrong.");
			else
				pw.println(n+" = "+x+" + "+y);
		}
		
		pw.flush();
		pw.close();
	}
	
	static ArrayList<Integer> primes;
	static boolean [] isPrime;
	
	static void sieve(int n){
		primes=new ArrayList<Integer>();
		isPrime=new boolean [n+1];
		Arrays.fill(isPrime, true);
		isPrime[0]=isPrime[1]=false;
		for(int i=2;i<=n;i++)
			if(isPrime[i]){
				primes.add(i);
				if(1L*i*i<=n)
					for(int j=i*i;j<=n;j+=i)
						isPrime[j]=false;
			}
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
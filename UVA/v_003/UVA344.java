package v_003;
import java.io.*;
import java.util.*;
public class UVA344 {
	public static void main(String[]args)throws Throwable{
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		int [][] cnt=new int [101][5];
		for(int i=1;i<=100;i++)
			cnt[i]=toRoman(i);
		for(int i=1;i<=100;i++){
			for(int j=0;j<5;j++)
				cnt[i][j]+=cnt[i-1][j];
		}
		while(true){
			int n=sc.nextInt();
			if(n==0)
				break;
			System.out.printf("%d: %d i, %d v, %d x, %d l, %d c\n",n,cnt[n][0],cnt[n][1],cnt[n][2],cnt[n][3],cnt[n][4]);
		}
		
		pw.flush();
		pw.close();
	}
	
	public static int [] toRoman(int n){
		int tens=n/10;
		int [] ans=new int [5];
		switch(tens){
		case 10 : {
			ans[4]++;
			break;
		}
		case 9 : {
			ans[2]++;
			ans[4]++;
			break;
		}
		case 8 : {
			ans[3]++;
			ans[2]+=3;
			break;
		}
		case 7 : {
			ans[3]++;
			ans[2]+=2;
			break;
		}
		case 6 : {
			ans[3]++;
			ans[2]++;
			break;
		}
		case 5 : {
			ans[3]++;
			break;
		}
		case 4 : {
			ans[3]++;
			ans[2]++;
			break;
		}
		case 3 : {
			ans[2]+=3;
			break;
		}
		case 2 : {
			ans[2]+=2;
			break;
		}
		case 1 : {
			ans[2]++;
			break;
		}
		}
		int units=n%10;
		switch(units){
		case 9 : {
			ans[0]++;
			ans[2]++;
			break;
		}
		case 8 : {
			ans[1]++;
			ans[0]+=3;
			break;
		}
		case 7 : {
			ans[1]++;
			ans[0]+=2;
			break;
		}
		case 6 : {
			ans[1]++;
			ans[0]++;
			break;
		}
		case 5 : {
			ans[1]++;
			break;
		}
		case 4 : {
			ans[1]++;
			ans[0]++;
			break;
		}
		case 3 : {
			ans[0]+=3;
			break;
		}
		case 2 : {
			ans[0]+=2;
			break;
		}
		case 1 : {
			ans[0]++;
			break;
		}
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

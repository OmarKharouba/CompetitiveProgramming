import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class CF101306_GYM_C {
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int [] c=new int [26];
		int max=0;
		while(n-->0){
			String [] sa=br.readLine().split(" ");
			int a=Integer.parseInt(sa[0]);
			int b=Integer.parseInt(sa[1])-1;
			for(int i=a;i<=b;i++){
				c[i]++;
				max=Math.max(max, c[i]);
			}
		}
		System.out.println(max);
	}
}
package v_112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class UVA11292 {
	static int n;
	static int[] value;
	static boolean [] visited;
	static ArrayList<Integer> [] arr;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int m=Integer.parseInt(sa[1]);
			if(n==0 && m==0)
				break;
			int []a=new int[n];
			int []b=new int[m];
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(bf.readLine());
			}
			for(int i=0;i<m;i++){
				b[i]=Integer.parseInt(bf.readLine());
			}
			Arrays.sort(a);
			Arrays.sort(b);
			boolean flag=true;
			int j=0;
			long sum=0;
			for(int i=0;i<n && flag;i++){
				while(j<m && b[j]<a[i])
					j++;
				if(j<m)
					sum+=b[j];
				else
					flag=false;
				j++;
			}
			System.out.println((flag)? sum : "Loowater is doomed!");
		}
	}
}
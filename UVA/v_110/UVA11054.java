package v_110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVA11054 {
	static int n;
	static int[] value;
	static boolean [] visited;
	static ArrayList<Integer> [] arr;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int[]a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(sa[i]);
			}
			long total=a[0];
			long r=Math.abs(total);
			for(int i=1;i<n;i++){
				total+=a[i];
				r+=Math.abs(total);
			}
			System.out.println(r);
		}
	}
}
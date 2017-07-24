package v_117;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
public class UVA11727 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		int cnt=1;
		while(n-->0){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int a=Integer.parseInt(sa[0]);
			int b=Integer.parseInt(sa[1]);
			int c=Integer.parseInt(sa[2]);
			int[] arr=new int[]{a,b,c};
			Arrays.sort(arr);
			System.out.println("Case "+cnt+": "+arr[1]);
			cnt++;
		}
	}
}

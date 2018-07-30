package v_104;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
public class UVA10474 {
	static int n;
	static ArrayList<Integer> a;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		while(true){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			n=Integer.parseInt(sa[0]);
			int m=Integer.parseInt(sa[1]);
			if(m==0 && n==0)
				break;
			a=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				a.add(Integer.parseInt(bf.readLine()));
			}
			Collections.shuffle(a);
			Collections.sort(a);
			System.out.println("CASE# "+cnt+":");
			while(m-->0){
				int x=Integer.parseInt(bf.readLine());
				int r=search(x)+1;
				if(r==0)
					System.out.println(x+" not found");
				else
					System.out.println(x+" found at "+r);
			}
			cnt++;
		}
	}
	
	public static int search(int x){
		int res=-1,start=0,end=n-1;
		while(start<=end){
			int mid=(start+end)>>1;
			if(a.get(mid)<x)
				start=mid+1;
			else{
				end=mid-1;
				if(a.get(mid)==x)
					res=mid;
			}
		}
		return res;
	}
}
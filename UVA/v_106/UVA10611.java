package v_106;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10611 {
	static int n;
	static int[] a;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(bf.readLine());
		String s=bf.readLine();
		String[]sa=s.split(" ");
		a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(sa[i]);
		}
		int q=Integer.parseInt(bf.readLine());
		s=bf.readLine();
		sa=s.split(" ");
		for(int i=0;i<q;i++){
			int x=Integer.parseInt(sa[i]);
			int r1=searchS(x);
			int r2=searchL(x);
			System.out.println((r1>0? r1 : "X")+" "+(r2>0? r2 : "X"));
		}
		
	}
	
	public static int searchL(int x){
		int res=0,start=0,end=n-1;
		while(start<=end){
			int mid=(start+end)>>1;
			if(a[mid]<=x)
				start=mid+1;
			else{
				end=mid-1;
				res=a[mid];
			}
		}
		return res;
	}
	public static int searchS(int x){
		int res=0,start=0,end=n-1;
		while(start<=end){
			int mid=(start+end)>>1;
			if(a[mid]>=x)
				end=mid-1;
			else{
				start=mid+1;
				res=a[mid];
			}
		}
		return res;
	}
}
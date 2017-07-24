package v_005;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA524 {
	static ArrayList<String> arr;
	static boolean[] v;
	static int n;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		int cnt=1;
		while((s=bf.readLine())!=null){
			arr=new ArrayList<String>();
			n=Integer.parseInt(s);
			v=new boolean[n];
			v[0]=true;
			f(" 1",1);
			if(cnt>1)
				System.out.println();
			System.out.println("Case "+cnt+":");
			for(String st : arr){
				System.out.println(st.substring(1));
			}
			cnt++;
		}
	}
	
	public static void f(String s,int c){
		String[]sa=s.substring(1).split(" ");
		if(c==n){
			if(prime(Integer.parseInt(sa[c-1])+Integer.parseInt(sa[0])))
				arr.add(s);
			return;
		}
		for(int i=0;i<n;i++){
			int x=i+1;
			boolean flag=c==0 || (c>0 && prime(Integer.parseInt(sa[c-1])+x));
			if(flag && !v[i]){
				v[i]=true;
				f(s+" "+(i+1),c+1);
				v[i]=false;
			}
		}
	}
	
	public static boolean prime(int x){
		for(int i=2;i<x;i++)
			if(x%i==0)
				return false;
		return true;
	}
}

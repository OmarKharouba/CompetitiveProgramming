package v_116;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
public class UVA11621 {
	static int n;
	static ArrayList<Long> a;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		a=new ArrayList<Long>();
		long x=1L;
		while(x<=(1L << 31)){
			long y=1L;
			while(x*y<=(1L << 32)){
				a.add(x*y);
				y*=3;
			}
			x*=2;
		}
		Collections.shuffle(a);
		Collections.sort(a);
		n=a.size();
		while(true){
			long m=Long.parseLong(bf.readLine());
			if(m==0)
				break;
			PrintWriter pw=new PrintWriter(System.out,true);
			pw.println((m==1)? 1 :searchL(m));
		}
	}
	
	public static long searchL(long x){
		long res=0;
		int start=0,end=n-1;
		while(start<=end){
			int mid=(start+end)>>1;
			if(a.get(mid)<x)
				start=mid+1;
			else{
				end=mid-1;
				res=a.get(mid);
			}
		}
		return res;
	}
}
package v_110;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
public class UVA11057 {
	static int n;
	static ArrayList<Integer> a;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			n=Integer.parseInt(s);
			s=bf.readLine();
			String[]sa=s.split(" ");
			a=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				a.add(Integer.parseInt(sa[i]));
			}
			Collections.shuffle(a);
			Collections.sort(a);
			int r=0,min=Integer.MAX_VALUE;
			int m=Integer.parseInt(bf.readLine());
			bf.readLine();
			for(int i=0;i<n;i++){
				if(search(m-a.get(i),i) && Math.abs(a.get(i)-(m-a.get(i)))<min){
					r=a.get(i);
					min=Math.abs(a.get(i)-(m-a.get(i)));
				}
			}
			int r1=Math.min(r, m-r);
			int r2=Math.max(r, m-r);
			System.out.println("Peter should buy books whose prices are "+r1+" and "+r2+".");
			System.out.println();
		}
	}
	
	public static boolean search(int x,int i){
		int start=0,end=n-1;
		while(start<=end){
			int mid=(start+end)>>1;
			if(a.get(mid)<x)
				start=mid+1;
			else{
				end=mid-1;
				if(a.get(mid)==x && mid!=i)
					return true;
			}
		}
		return false;
	}
}
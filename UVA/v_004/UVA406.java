package v_004;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA406 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int c=Integer.parseInt(sa[1]);
			ArrayList<Integer> primes=new ArrayList<Integer>();
			int cnt=0;
			for(int i=1;i<=n;i++){
				if(prime(i)){
					primes.add(i);
					cnt++;
				}
			}
			System.out.print(n+" "+c+":");
			int num=(cnt%2==0)? c*2 : c*2-1;
			int start=0;
			if(cnt>num)
				start=(cnt-num)/2;
			for(int i=0;i<num && start+i<cnt;i++){
				System.out.print(" "+primes.get(start+i));
			}
			System.out.println();
			System.out.println();
		}
		bf.close();
	}
	
	public static boolean prime(int x){
		if(x==2 || x==3 || x==1)
			return true;
		if(x<1 || x%2==0 || x%3==0)
			return false;
		for(int i=5;i*i<=x;i+=6){
			if(x%(i)==0 || x%(i+2)==0)
				return false;
		}
		return true;
	}
}

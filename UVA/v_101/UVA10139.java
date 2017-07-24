package v_101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVA10139 {
	static ArrayList<pair> a=new ArrayList<pair>();
	public static void main(String[] args) throws Throwable{
		String s="";
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while((s=bf.readLine())!=null){
			String [] sa=s.split(" ");
			long n=Long.parseLong(sa[0]);
			long m=Long.parseLong(sa[1]);
			a.clear();
			factorize(m);
			boolean flag=true;
			for(int i=0;i<a.size() && flag;i++){
				long x=a.get(i).prime;
				long y=a.get(i).pow;
				long z=maxpowerprime(x, n);
				if(z<y)
					flag=false;
			}
			System.out.println(m+(flag? " divides " : " does not divide ")+n+"!");
		}
	}
	
	public static long maxpowerprime(long p,long n){
		long cnt=0;
		for(long i=p;i<=n;i*=p)
			cnt+=n/i;
		return cnt;
	}
	
	static void factorize(long x){
		int i=0;
		for(i=2;i*i<=x;i++){
			int c=0;
			while(x%i==0){
				c++;
				x/=i;
			}
			if(c>0)
				a.add(new pair(i,c));
		}
		if(x>1)
			a.add(new pair(x,1));
	}
	
	static class pair{
		long prime;
		int pow;
		
		pair(long prime,int pow){
			this.prime=prime;
			this.pow=pow;
		}
		
		public String toString(){
			return "("+prime+"--> "+pow+")";
		}
	}
}

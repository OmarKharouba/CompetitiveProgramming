package v_101;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA10168 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		boolean[] p=new boolean[10000001];
		p[0]=true;
		p[1]=true;
		for(int i=2;i*i<p.length;i++){
			if(!p[i]){
				for(int j=i*2;j<p.length;j+=i){
					p[j]=true;
				}
			}
		}
		ArrayList<Integer> primes=new ArrayList<Integer>();
		primes.add(2);
		for(int i=3;i<p.length;i+=2){
			if(!p[i])
				primes.add(i);
		}
		String s="";
		while((s=bf.readLine())!=null){
			int n=Integer.parseInt(s);
			if(n<8)
				System.out.println("Impossible.");
			else{
				int x=2;
				int y=2+n%2;
				int z=0,w=0;
				n-=(x+y);
				for(int i=0;i<primes.size();i++){
					z=primes.get(i);
					int r=n-z;
					if(!p[r]){
						w=r;
						break;
					}
				}
				if(w!=0)
					System.out.println(x+" "+y+" "+z+" "+w);
				else
					System.out.println("Impossible.");
			}
		}
		bf.close();
	}
	
	public static boolean prime(int x){
		if(x==2 || x==3)
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

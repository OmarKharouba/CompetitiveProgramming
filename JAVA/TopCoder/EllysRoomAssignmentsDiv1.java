package topcoder;
import java.util.Arrays;


public class EllysRoomAssignmentsDiv1 {
	
	public static void main(String[] args) {
		String [] a={"3380 3413 3254 3515 2885 2946 2790 3140"};
		System.out.println(getAverage(a));
	}
	
	public static double getAverage(String[] ratings){
		String t="";
		for(String s : ratings)
			t+=s;
		String [] sa=t.split(" ");
		n=sa.length;
		a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=-Integer.parseInt(sa[i]);
		int rate=-a[0];
		idx=0;
		Arrays.sort(a);
		for(int i=0;i<n;i++){
			a[i]*=-1;
			if(a[i]==rate)
				idx=i;
		}
		r=(int)Math.ceil(n/20.0);
		start=idx-idx%r;
		p=1.0/r;
		pr=1.0/(n%r);
		double ans=0;
		if(n%r==0){
			mem=new Double [n];
			ans=dp1(0)/(n/r);
		}else{
			if(start+r>=n){ // in the last group
				mem=new Double [n];
				ans=(dp2(0)+a[idx])/(n/r+1);
			}else{ // in an intermediate group
				mem=new Double [n];
				double pp=1.0*(n%r)/r;
				ans=pp*dp3(0)/(n/r+1);
				mem=new Double [n];
				ans+=(1-pp)*dp4(0)/(n/r);
			}
		}
		return ans;
	}
	static int n,r,idx,start;
	static int [] a;
	static double p,pr;
	static Double [] mem;
	
	static double dp1(int i){
		if(i==start)
			return a[idx]+dp1(i+r);
		if(i>=n)
			return 0;
		if(mem[i]!=null)
			return mem[i];
		double ans=0;
		for(int j=i;j<i+r;j++){
			ans+=p*(a[j]+dp1(i+r));
		}
		return mem[i]=ans;
	}
	
	static double dp2(int i){
		if(i==start)
			return 0;
		if(mem[i]!=null)
			return mem[i];
		double ans=0;
		for(int j=i;j<i+r;j++){
			ans+=p*(a[j]+dp2(i+r));
		}
		return mem[i]=ans;
	}
	
	static double dp3(int i){
		if(i==start)
			return a[idx]+dp3(i+r);
		if(i>=n)
			return 0;
		if(mem[i]!=null)
			return mem[i];
		double ans=0;
		if(i+r>=n){
			for(int j=i;j<n;j++){
				ans+=pr*(a[j]+dp3(i+r));
			}
		}else{			
			for(int j=i;j<i+r;j++){
				ans+=p*(a[j]+dp3(i+r));
			}
		}
		return mem[i]=ans;
	}
	
	static double dp4(int i){
		if(i==start)
			return a[idx]+dp4(i+r);
		if(mem[i]!=null)
			return mem[i];
		double ans=0;
		if(i+r>=n)
			return 0;
		else{			
			for(int j=i;j<i+r;j++){
				ans+=p*(a[j]+dp4(i+r));
			}
		}
		return mem[i]=ans;
	}
	
}

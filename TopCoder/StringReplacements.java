package topcoder;

import java.util.Arrays;

public class StringReplacements {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(substringCounter("a", 2, 6, 2)));
	}
	public static int[] substringCounter(String letter, int left, int right, int nSeconds){
		l=left;
		r=right;
		n=nSeconds;
		long len=1;
		int t=nSeconds;
		while(t-->0)
			len*=3;
		solve(letter.charAt(0),0,len-1,0);
		int [] ans={ca,cb,cc};
		return ans;
	}
	static int l,r,n;
	static int ca,cb,cc;
	
	static void solve(char c ,long i, long j, int steps){
		if(i>r || j<l)
			return;
		if(i>=l && j<=r){
			int c1=0,c2=0,c3=0;
			if(c=='a')
				c1++;
			else
				if(c=='b')
					c2++;
				else
					c3++;
			while(steps<n){
				int t1=c1+2*c2,t2=c1+c2+2*c3,t3=c1+c3;
				steps++;
				c1=t1;
				c2=t2;
				c3=t3;
			}
			ca+=c1;
			cb+=c2;
			cc+=c3;
			return;
		}
		char nc1=(c=='a'? 'a' : 'b');
		char nc2=(c=='b'? 'a' : 'c');
		char nc3=(c=='b'? 'a' : 'b');
		long d=(j-i+1)/3;
		solve(nc1, i, i+d-1, steps+1);
		solve(nc2, i+d, i+2*d-1, steps+1);
		solve(nc3, i+2*d, j, steps+1);
	}

}

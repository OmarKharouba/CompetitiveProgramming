import java.util.Arrays;


public class FloatingMedian {
	
	public static void main(String[] args) {
		System.out.println(sumOfMedians(4123, 2341, 1231, 7, 3));
	}
	static int max=65537;
	static int k;
	static long [] ft; 
	public static long sumOfMedians(int seed, int mul, int add, int N, int K){
		k=K;
		int [] a=new int [N];
		a[0]=seed;
		for(int i=1;i<N;i++)
			a[i]=(int)((1L*a[i-1]*mul+add)%65536);
		ft=new long [max];
		int i=0;
		for(i=0;i<K;i++)
			update(a[i]+1, 1);
		long sum=getIndex();
		while(i<N){
			update(a[i]+1, 1);
			update(a[i-k]+1, -1);
			sum+=getIndex();
			i++;
		}
		return sum;
	}
	
	public static int getIndex(){
		int start=0,end=max,ans=-1;
		int median=(k+1)/2;
		while(start<=end){
			int mid=((start+end)>>1);
			if(get(mid+1)>=median){
				ans=mid;
				end=mid-1;
			}else
				start=mid+1;
		}
		return ans;
	}
	
	public static void update(int idx,int val){
		while(idx<=max){
			ft[idx]+=val;
			idx+=(idx & -idx);
		}
	}
	
	public static long get(int idx){
		long ans=0;
		while(idx>0){
			ans+=ft[idx];
			idx-=(idx & -idx);
		}
		return ans;
	}

}

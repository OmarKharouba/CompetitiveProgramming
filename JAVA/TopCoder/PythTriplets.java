package topcoder;
import java.util.ArrayList;
import java.util.Arrays;


public class PythTriplets {
	
	public static void main(String[] args) {
		String [] a={"28 19", "5 1035 21412 37995"};
		System.out.println(findMax(a));
	}
	
	public static int findMax(String[] stick){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		String t="";
		for(String s : stick){
			t+=s;
		}
		String [] sa=t.split(" ");
		for(String ss : sa)
			if(ss.length()>0)
				arr.add(Integer.parseInt(ss));
		n=m=arr.size();
		adj=new ArrayList [n];
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++){
				int x=arr.get(i);
				int y=arr.get(j);
				if(gcd(x, y)==1){
					int z=(int)Math.round(Math.sqrt(1L*x*x+1L*y*y));
					if(1L*x*x+1L*y*y==1L*z*z){
						if(x%2==0)
							adj[i].add(j);
						else
							adj[j].add(i);
					}
				}
			}
		int ans=maxMatching();
		return ans;
	}
	
	static int gcd(int a,int b){
		return b==0? a : gcd(b,a%b);
	}
	
	static int n,m,vid;
	static int [] match;
	static ArrayList<Integer> [] adj;
	static int [] vis;
	
	static int maxMatching(){
		int ans=0;
		match=new int [m];
		vis=new int [n];
		Arrays.fill(match, -1);
		for(int i=0;i<n;i++){
			vid++;
			if(canMatch(i))
				ans++;
		}
		return ans;
	}
	
	static boolean canMatch(int u){
		vis[u]=vid;
		for(int v : adj[u])
			if(match[v]==-1 || (vis[match[v]]!=vid && canMatch(match[v]) )){
				match[v]=u;
				return true;
			}
		return false;
	}
}

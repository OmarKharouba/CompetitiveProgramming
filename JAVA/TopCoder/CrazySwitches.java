
public class CrazySwitches {
	
	public static void main(String[] args) {
		int [] a={7, 11, 1, 12, 6, 3, 0, 2, 6, 0, 0, 5, 9};
		System.out.println(minimumActions(a));
	}
	
	public static int minimumActions(int[] switches){
		int ans=0;
		int n=switches.length;
		boolean [] vis=new boolean [n];
		int cur=switches[n-1];
		boolean f=true;
		while(!vis[cur]){
			vis[cur]=true;
			ans++;
			if(!f && !vis[switches[cur]])
				ans++;
			f=false;
			
			cur=switches[cur];
		}
		if(vis[0] && vis[n-1])
			return ans-1;
		return -1;
	}
	
}

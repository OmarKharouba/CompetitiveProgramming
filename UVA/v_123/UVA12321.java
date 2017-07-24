package v_123;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
class UVA12321 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		Scanner sc=new Scanner(System.in);
		while(true){
			int l=sc.nextInt();
			int n=sc.nextInt();
			if(l==0)
				break;
			pair[] a=new pair[n];
			for(int i=0;i<n;i++){
				int p=sc.nextInt();
				int r=sc.nextInt();
				int x=Math.max(0, p-r);
				int y=Math.min(l, p+r);
				a[i]=new pair(x, y);
			}
			Arrays.sort(a);
			int cnt=0;
			int end=0;
			boolean flag=false;
			for(int i=0;i<n;i++){
				int max=0;
				while(i<n && a[i].x<=end){
					if(a[i].y>=max)
						max=a[i].y;
					i++;
				}
				if(max==0){
					flag=false;
					break;
				}else{
					cnt++;
					i--;
				}
				end=max;
				if(end==l){
					flag=true;
					break;
				}
			}
			flag =flag && (end==l);
			System.out.println((flag)? (n-cnt) : -1);
		}
		sc.close();
	}
}

class pair implements Comparable<pair>{
	int x;
	int y;
	
	pair(int x,int y){
		this.x=x;
		this.y=y;
	}

	public int compareTo(pair o) {
		if(this.x!=o.x)
			return this.x - o.x;
		return o.y - this.y;
	}

	
}

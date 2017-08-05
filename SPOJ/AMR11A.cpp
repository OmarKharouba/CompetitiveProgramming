#include <bits/stdc++.h>
using namespace std;
 
int main() {
	int t;
	scanf("%d",&t);
	while(t--){
		int n,m;
		scanf("%d",&n);
		scanf("%d",&m);
		int a[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				scanf("%d",&a[i][j]);
		int start=0,end=(int)(1e6+1),ans=-1;
		while(start<=end){
			int mid=((start+end)>>1);
			int b[n][m];
			bool ok[n][m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					ok[i][j]=false;
			b[0][0]=a[0][0]+mid;
			ok[0][0]=b[0][0]>0;
			bool can=b[0][0]>0;
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++){
					if(i==0 && j==0)
						continue;
					b[i][j]=a[i][j];
					int mx=(int)-(1e9+5);
					if(i>0 && ok[i-1][j])
						mx=b[i-1][j];
					if(j>0 && ok[i][j-1])
						mx=max(mx, b[i][j-1]);
					b[i][j]+=mx;
					if(b[i][j]>0)
						ok[i][j]=true;
				}
			can &=ok[n-1][m-1];
			if(can){
				ans=mid;
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
		printf("%d\n",ans);
	}
    return 0;
}
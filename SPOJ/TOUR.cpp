#include <bits/stdc++.h>
using namespace std;
 
const int N=1000;
int cur;
vector<int> adj[N];
bool reach [N][N];
int vis[N];
void dfs(int u){
	reach[cur][u]=true;
	vis[u]=cur;
	for(int i=0;i<adj[u].size();i++){
		int v=adj[u][i];
		if(vis[v]!=cur)
			dfs(v);
	}
}
 
 
int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		int n;
		scanf("%d",&n);
		memset(vis, -1,sizeof vis);
		for(int i=0;i<n;i++)
			adj[i].clear();
		for(int i=0;i<n;i++){
			int c;
			scanf("%d",&c);
			while(c--){
				int v;
				scanf("%d",&v);
				v--;
				adj[v].push_back(i);
			}
		}
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				reach[i][j]=false;
		for(int i=0;i<n;i++){
			cur=i;
			dfs(i);
		}
		int ans=0;
		for(int i=0;i<n;i++){
			bool ok=true;
			for(int j=0;j<n;j++)
				if(!reach[i][j])
					ok=false;
			if(ok)
				ans++;
		}
 
		printf("%d\n",ans);
	}
}
 
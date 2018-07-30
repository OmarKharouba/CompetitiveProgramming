#include <bits/stdc++.h>
using namespace std;
 
const int N=5000;
vector<int> adj[N];
int cntSCC,tim,n;
stack<int> st;
int dfs_num[N],dfs_low[N],comp[N];
bool inSCC[N];
 
void SCC(int u){
	dfs_num[u]=dfs_low[u]=++tim;
	st.push(u);
	for(int i=0;i<adj[u].size();i++){
		int v=adj[u][i];
		if(dfs_num[v]==0)
			SCC(v);
		if(!inSCC[v])
			dfs_low[u]=min(dfs_low[u], dfs_low[v]);
	}
 
	if(dfs_low[u]==dfs_num[u]){
		while(true){
			int x=st.top();
			st.pop();
			inSCC[x]=true;
			comp[x]=cntSCC;
			if(x==u)
				break;
		}
		cntSCC++;
	}
}
 
void SCC(){
	for(int i=0;i<n;i++)
		if(dfs_num[i]==0)
			SCC(i);
}
 
int main(){
	while(1){
		scanf("%d",&n);
		if(n==0)
			break;
		int m;
		scanf("%d",&m);
		int x[m];
		int y[m];
		for(int i=0;i<n;i++)
			adj[i].clear();
		for(int i=0;i<m;i++){
			scanf("%d",&x[i]);
			scanf("%d",&y[i]);
			x[i]--;
			y[i]--;
			adj[x[i]].push_back(y[i]);
		}
		memset(dfs_low,0,sizeof dfs_low);
		memset(dfs_num,0,sizeof dfs_num);
		memset(comp,0,sizeof comp);
		memset(inSCC,false,sizeof inSCC);
		SCC();
		int compDeg[cntSCC];
		memset(compDeg,0,sizeof compDeg);
		for(int i=0;i<m;i++){
			int c1=comp[x[i]];
			int c2=comp[y[i]];
			if(c1!=c2)
				compDeg[c1]++;
		}
		vector<int> ans;
		for(int i=0;i<n;i++)
			if(compDeg[comp[i]]==0)
				ans.push_back(i+1);
		bool f=true;
		for(int i=0;i<ans.size();i++){
			int x=ans[i];
			if(!f)
				printf(" ");
			f=false;
			printf("%d",x);
		}
		printf("\n");
	}
}
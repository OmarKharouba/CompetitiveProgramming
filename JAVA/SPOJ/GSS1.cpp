#include <bits/stdc++.h>
#include <iostream>
#include <stdio.h>
using namespace std;
 
#define pi pair<int  ,int >
#define T pair<pi  ,pi >
#define mk make_pair
 
const int inf =(int)(1e9);
const int N=50010;
T st [4*N];
int a [N];
 
T merge(T a, T b){
    if(a.second.first==-inf)
        return b;
    if(b.second.first==-inf)
        return a;
	int rr=max(b.first.first,b.second.first+a.first.first);
	int ll=max(a.first.second,a.second.first+b.first.second);
	int tt=a.second.first+b.second.first;
	int bb=max(a.first.first+b.first.second, max(a.second.second, b.second.second));
	return mk(mk(rr,ll),mk(tt,bb));
}
 
T build2(int s,int e,int p){
		if(s==e)
			return st[p]=mk(mk(a[s], a[s]), mk(a[s], a[s]));
		else
			return st[p]=merge(build2(s, (s+e)/2, 2*p),build2((s+e)/2+1, e, 2*p+1));
	}
 
void build(){
		build2(1,N,1);
	}
 
T query(int s,int e,int p,int i,int j){
		if(j<s || i>e)
			return mk(mk(-inf,-inf),mk(-inf,-inf));
		if(s>=i && e<=j)
			return st[p];
		T q1=query(s, (s+e)/2, 2*p, i, j);
		T q2=query((s+e)/2+1, e, 2*p+1, i, j);
		return merge(q1,q2);
	}
 
T query(int i,int j){
	return query(1,N,1,i,j);
}
 
int main(){
	int n;
	cin >> n;
	for(int i=0;i<N;i++)
	    a[i]=-inf;
	for(int i=1;i<=n;i++)
		cin >> a[i];
	build();
	int m;
	cin >> m;
	while(m--){
		int x,y;
		cin >> x >> y;
		T ans=query(x, y);
		cout << ans.second.second << endl;
	}
 
 	return 0;
}
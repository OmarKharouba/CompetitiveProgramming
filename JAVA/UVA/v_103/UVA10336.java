package v_103;
import java.io.*;
import java.util.*;
public class UVA10336 {
	
	static class pair implements Comparable<pair>{
		char c;
		int x;
		pair(char c,int x){
			this.c=c;
			this.x=x;
		}
		@Override
		public int compareTo(pair o) {
			if(this.x>o.x || (this.x==o.x && this.c<o.c))
				return -1;
			else
				return 1;
		}
		
		
	}
	static int n;
	static int m;
	static char[][]a;
	static boolean[][]v;
	static int[] b;
	static ArrayList<pair> ans;
	public static void main(String[]args) throws Throwable{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=1;i<=t;i++){
			b=new int[26];
			String s=bf.readLine();
			String[]sa=s.split(" ");
			n=Integer.parseInt(sa[0]);
			m=Integer.parseInt(sa[1]);
			v=new boolean[n][m];
			a=new char[n][];
			for(int j=0;j<n;j++){
				a[j]=bf.readLine().toCharArray();
			}
			for(int j=0;j<n;j++){
				for(int k=0;k<m;k++){
					if(!v[j][k]){
						floodFill(j,k,a[j][k]);
						b[a[j][k]-97]++;
					}
				}
			}
			ans=new ArrayList<pair>();
			for(int j=0;j<26;j++){
				if(b[j]!=0)
					ans.add(new pair((char)(j+97), b[j]));
			}
			Collections.shuffle(ans);
			Collections.sort(ans);
			System.out.println("World #"+i);
			for(int j=0;j<ans.size();j++){
				System.out.println(ans.get(j).c+": "+ans.get(j).x);
			}
		}
	}
	
	public static void floodFill(int r,int c,char s){
		if(r>=0 && r<n && c>=0 && c<m && !v[r][c] && a[r][c]==s){
			v[r][c]=true;
			floodFill(r, c+1, s);
			floodFill(r, c-1, s);
			floodFill(r+1, c, s);
			floodFill(r-1, c, s);
		}
	}
}

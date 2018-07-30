package v_109;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
class pair implements Comparable<pair>{
	char s;
	int x;
	pair(char c,int y){
		s=c;
		x=y;
	}
	
	public int compareTo(pair o) {
		if(o.x!=this.x)
			return o.x-this.x;
		return this.s-o.s;
	}
}

public class UVA10946 {
	static int n;
	static int m;
	static char[][] b;
	static ArrayList<pair> a;
	static int si;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		while(true) {
			String s=bf.readLine();
			String[]sa=s.split(" ");
			n=Integer.parseInt(sa[0]);
			m=Integer.parseInt(sa[1]);
			if(n==0 && m==0)
				break;
			b=new char[n][];
			for(int i=0;i<n;i++){
				b[i]=bf.readLine().toCharArray();
			}
			a=new ArrayList<pair>(n*m);
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					char c=b[i][j];
					if(c!='.'){
						si=0;
						floodFill(i, j, c);
						a.add(new pair(c, si));
					}
				}
			}
			Collections.sort(a);
			System.out.println("Problem "+cnt+":");
			for(int i=0;i<a.size();i++){
				System.out.println(a.get(i).s+" "+a.get(i).x);
			}
			cnt++;
		}
	}
	
	public static void floodFill(int r,int c,char s){
		if(valid(r,c) && b[r][c]==s){
			si++;
			b[r][c]='.';
			int[]dr=new int[]{0,0,1,-1};
			int[]dc=new int[]{1,-1,0,0};
			for(int i=0;i<4;i++){
				floodFill(r+dr[i], c+dc[i],s);
			}
		}
	}
	
	public static boolean valid(int r,int c){
		return (r>=0 && r<n && c>=0 && c<m);
	}
}
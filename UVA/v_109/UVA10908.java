package v_109;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA10908 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			String s=bf.readLine();
			System.out.println(s);
			String[]sa=s.split(" ");
			int m=Integer.parseInt(sa[0]);
			int n=Integer.parseInt(sa[1]);
			int q=Integer.parseInt(sa[2]);
			char[][] a=new char[m][n]; 
			for(int j=0;j<m;j++){
				s=bf.readLine();
				for(int k=0;k<n;k++){
					a[j][k]=s.charAt(k);
				}
			}
			for(int j=0;j<q;j++){
				s=bf.readLine(); 
				sa=s.split(" ");
				int r=Integer.parseInt(sa[0]);
				int c=Integer.parseInt(sa[1]);
				char ch=a[r][c];
				int x=1;
				int cnt=0;
				boolean flag=true;
				while(r+x<m && r-x>=0&& c+x<n && c-x>=0 && flag){
					for(int k=c-x;k<=c+x;k++){
						if(a[r-x][k]!=ch || a[r+x][k]!=ch){
							flag=false;
						}
					}
					if(flag){
						for(int k=r-x;k<=r+x;k++){
							if(a[k][c-x]!=ch || a[k][c+x]!=ch){
								flag=false;
							}
						}
					}
					if(flag)
						cnt++;
					else
						break;
					x++;
				}
				System.out.println(2*cnt+1);
			}
		}
	}
}
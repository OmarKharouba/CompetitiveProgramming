package v_100;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA10016 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(bf.readLine());
		for(int i=0;i<m;i++){
			int n=Integer.parseInt(bf.readLine());
			int[][]a=new int [n][n];
			for(int j=0;j<n;j++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				for(int k=0;k<n;k++){
					a[j][k]=Integer.parseInt(sa[k]);
				}
			}
			int x=n/2+n%2;
			for(int j=0;j<x;j++){
				String s=bf.readLine();
				String[]sa=s.split(" ");
				for(int k=1;k<sa.length;k++){
					int y=Integer.parseInt(sa[k]);
					a=f(a,j,y);
				}
			}
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					if(k<n-1)
						System.out.print(a[j][k]+" ");
					else
						System.out.println(a[j][k]);
				}
			}
		}
	}
	
	public static int[][] f(int[][]a,int ring,int move){
		int n=a.length;
		int[][]b=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if((i==ring || i==n-1-ring) && j>=ring && j<=n-1-ring || (j==ring || j==n-1-ring) && i>=ring && i<=n-1-ring){
					switch(move){
					case 1: b[i][j]=a[n-1-i][j]; break;
					case 2: b[i][j]=a[i][n-1-j]; break;
					case 3: b[i][j]=a[j][i]; break;
					case 4: b[i][j]=a[n-1-j][n-1-i]; break;
					}
				}
				else
					b[i][j]=a[i][j];
			}
		}
		return b;
	}
}
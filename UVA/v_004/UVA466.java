package v_004;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA466 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		String s="";
		while((s=bf.readLine())!=null){
			int n=Integer.parseInt(s);
			char[][]a=new char[n][n];
			char[][]b=new char[n][n];
			for(int i=0;i<n;i++){
				s=bf.readLine();
				String[]sa=s.split(" ");
				for(int j=0;j<n;j++){
					a[i][j]=sa[0].charAt(j);
					b[i][j]=sa[1].charAt(j);
				}
			}
			System.out.print("Pattern "+cnt+" was ");
			cnt++;
			if(same(a,b))
				s="preserved.";
			else
				if(rot90(a, b))
					s="rotated 90 degrees.";
				else
					if(rot180(a, b))
						s="rotated 180 degrees.";
					else
						if(rot270(a, b))
							s="rotated 270 degrees.";
						else
							if(same(reflect(a), b))
								s="reflected vertically.";
							else
								if(rot90(reflect(a), b))
									s="reflected vertically and rotated 90 degrees.";
								else
									if(rot180(reflect(a), b))
										s="reflected vertically and rotated 180 degrees.";
									else
										if(rot270(reflect(a), b))
											s="reflected vertically and rotated 270 degrees.";
										else
											s="improperly transformed.";
			System.out.println(s);
				
		}
	}
	
	public static boolean same(char[][]a,char[][]b){
		int n=a.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]!=b[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static boolean rot90(char[][]a,char[][]b){
		int n=a.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]!=b[j][n-1-i])
					return false;
			}
		}
		return true;
	}
	
	public static boolean rot180(char[][]a,char[][]b){
		int n=a.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]!=b[n-1-i][n-1-j])
					return false;
			}
		}
		return true;
	}
	
	public static boolean rot270(char[][]a,char[][]b){
		int n=a.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]!=b[n-1-j][i])
					return false;
			}
		}
		return true;
	}
	
	public static char[][]reflect(char[][]a){
		int n=a.length;
		char[][]b=new char[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				b[i][j]=a[n-1-i][j];
			}
		}
		return b;
	}
}
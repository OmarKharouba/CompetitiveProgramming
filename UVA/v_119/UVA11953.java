package v_119;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11953 {
	static int n;
	static char[][]a;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for (int i = 1; i <=t; i++) {
			n=Integer.parseInt(bf.readLine());
			a=new char[n][n];
			for(int j=0;j<n;j++){
				String s=bf.readLine();
				for(int k=0;k<n;k++){
					a[j][k]=s.charAt(k);
				}
			}
			int cnt=0;
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					if(a[j][k]=='x'){
						floodFill(j,k);
						cnt++;
					}
				}
			}
			System.out.println("Case "+i+": "+cnt);
		}
	}
	
	public static void floodFill(int r,int c){
		if(valid(r,c)){
			a[r][c]='.';
			floodFill(r, c+1);
			floodFill(r, c-1);
			floodFill(r+1, c);
			floodFill(r-1, c);
		}
	}
	
	public static boolean valid(int r,int c){
		return (r>=0 && r<n && c>=0 && c<n && a[r][c]!='.');
	}
}

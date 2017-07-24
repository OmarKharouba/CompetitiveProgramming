package v_104;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA10443 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine().charAt(0)+"");
		while(t-->0){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int r=Integer.parseInt(sa[0]);
			int c=Integer.parseInt(sa[1]);
			int n=Integer.parseInt(sa[2]);
			char[][] a=new char[r][c];
			for(int i=0;i<r;i++){
				s=bf.readLine();
				for(int j=0;j<c;j++){
					a[i][j]=s.charAt(j);
				}
			}
			while(n-->0){
				char[][]b=new char[r][c];
				for(int i=0;i<r;i++){
					for(int j=0;j<c;j++){
						b[i][j]=a[i][j];
						if(i>0 && win(a[i-1][j],a[i][j]))
							b[i][j]=a[i-1][j];
						else
							if(j>0 && win(a[i][j-1],a[i][j]))
								b[i][j]=a[i][j-1];
							else
								if(i<r-1 && win(a[i+1][j],a[i][j]))
									b[i][j]=a[i+1][j];
								else
									if(j<c-1 && win(a[i][j+1],a[i][j]))
										b[i][j]=a[i][j+1];
					}
				}
				a=b;
			}
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					System.out.print(a[i][j]);
				}
				System.out.println();
			}
			if(t>0)
				System.out.println();
		}
	}
	
	public static boolean win(char x,char y){
		return ((x=='R' && y=='S') || (x=='S' && y=='P') || (x=='P' && y=='R'));
	}
}
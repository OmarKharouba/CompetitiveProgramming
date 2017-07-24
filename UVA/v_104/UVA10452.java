package v_104;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA10452 {
	public static void main(String[]args)throws IOException,NumberFormatException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int m=Integer.parseInt(sa[1]);
			char[][]a=new char[n][m];
			int x=0,y=0;
			int x2=0,y2=0;
			for(int j=0;j<n;j++){
				s=bf.readLine();
				for(int k=0;k<m;k++){
					a[j][k]=s.charAt(k);
					if(a[j][k]=='@'){
						x=j;
						y=k;
					}
					if(a[j][k]=='#'){
						x2=j;
						y2=k;
					}
				}
			}
			String v="@IEHOVA#";
			int j=x,k=y;
			while(j!=x2 || k!=y2){
				if(j>0 && v.contains(""+a[j][k]+a[j-1][k])){
					if(a[j][k]!='@')
						System.out.print(" ");
					a[j][k]=' ';
					j--;
					System.out.print("forth");
				}
				else
					if(k>0 && v.contains(""+a[j][k]+a[j][k-1])){
						if(a[j][k]!='@')
							System.out.print(" ");
						a[j][k]=' ';
						k--;
						System.out.print("left");
					}
					else
						if(k<m-1 && v.contains(""+a[j][k]+a[j][k+1])){
							if(a[j][k]!='@')
								System.out.print(" ");
							a[j][k]=' ';
							k++;
							System.out.print("right");
						}
			}
			System.out.println();
		}
	}
}

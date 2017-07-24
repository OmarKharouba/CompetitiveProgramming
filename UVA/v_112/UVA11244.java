package v_112;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class UVA11244 {
	static int n;
	static int m;
	static char[][] b;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
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
			int cnt=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					char c=b[i][j];
					if(c=='*'){
						int []dr={0,0,1,1,1,-1,-1,-1};
						int []dc={1,-1,0,1,-1,0,1,-1};
						boolean f=true;
						for(int k=0;k<8 && f;k++){
							if(valid(i+dr[k], j+dc[k]) && b[i+dr[k]][j+dc[k]]!='.')
								f=false;
						}
						if(f)
							cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static boolean valid(int r,int c){
		return (r>=0 && r<n && c>=0 && c<m);
	}
}
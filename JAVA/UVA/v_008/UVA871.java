package v_008;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA871 {
	static int n;
	static int m;
	static ArrayList<String>a;
	static boolean[][]v;
	static int cnt;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		bf.readLine();
		while(t-->0) {
			a=new ArrayList<String>();
			String s="";
			n=0;
			while(true){
				if((s=bf.readLine())==null || s.length()<1)
					break;
				a.add(s);
				n++;
				m=s.length();
			}
			int max=0;
			v=new boolean[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					cnt=0;
					floodFill(i, j);
					if(cnt>max)
						max=cnt;
				}
			}
			System.out.println(max);
			if(t>0)
				System.out.println();
		}
	}
	
	public static void floodFill(int r,int c){
		if(valid(r,c)){
			cnt++;
			v[r][c]=true;
			int [] dr={0,0,1,1,1,-1,-1,-1};
			int [] dc={1,-1,0,1,-1,0,1,-1};
			for(int i=0;i<8;i++){
				floodFill(r+dr[i], c+dc[i]);
			}
		}
	}
	
	public static boolean valid(int r,int c){
		return (r>=0 && r<n && c>=0 && c<m && !v[r][c] && a.get(r).charAt(c)=='1');
	}
}

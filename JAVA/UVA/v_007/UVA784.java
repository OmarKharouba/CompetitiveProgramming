package v_007;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA784 {
	static int n;
	static ArrayList<String>a;
	static char[][] b;
	static int cnt;
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0) {
			a=new ArrayList<String>();
			n=0;
			String u="";
			while(true){
				String s=bf.readLine();
				if(s.charAt(0)=='_'){
					u=s;
					break;
				}
				a.add(s);
				n++;
			}
			b=new char[n][];
			for(int i=0;i<n;i++){
				b[i]=a.get(i).toCharArray();
			}
			boolean f=true;
			for(int i=0;i<n && f;i++){
				for(int j=0;j<b[i].length&& f;j++){
					if(b[i][j]=='*'){
						floodFill(i, j);
						f=false;
					}
				}
			}
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<n;i++){
				for(int j=0;j<b[i].length;j++){
					sb.append(b[i][j]);
				}
				sb.append("\n");
			}
			sb.append(u);
			System.out.println(sb);
		}
	}
	
	public static void floodFill(int r,int c){
		if(valid(r,c)){
			cnt++;
			b[r][c]='#';
			int[]dr={0,0,1,1,1,-1,-1,-1};
			int[]dc={1,-1,1,0,-1,1,0,-1};
			for(int i=0;i<8;i++){
				floodFill(r+dr[i], c+dc[i]);
			}
		}
	}
	
	public static boolean valid(int r,int c){
		return (r>=0 && r<n && c>=0 && c<b[r].length && (b[r][c]==' ' || b[r][c]=='*'));
	}
}

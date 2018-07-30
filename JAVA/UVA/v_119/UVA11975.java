package v_119;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UVA11975 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=1;i<=t;i++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int l=Integer.parseInt(sa[1]);
			int[] a=new int[n];
			s=bf.readLine();
			sa=s.split(" ");
			for(int j=0;j<n;j++){
				a[j]=Integer.parseInt(sa[j]);
			}
			int[] v=new int[4];
			s=bf.readLine();
			sa=s.split(" ");
			for(int j=0;j<4;j++){
				v[j]=Integer.parseInt(sa[j]);
			}
			if(i>1)
				System.out.println();
			System.out.println("Case "+i+":");
			for(int r=0;r<l;r++){
				int[][]b=new int[5][5];
				boolean[][] c=new boolean[5][5];
				for(int j=0;j<5;j++){
					s=bf.readLine();
					sa=s.split(" ");
					for(int k=0;k<5;k++){
						b[j][k]=Integer.parseInt(sa[k]);
					}
				}
				boolean corners=false,mid=false,diagonal=false,table=false;
				for(int j=0;j<n;j++){
					boolean flag=true;
					for(int k=0;k<5 && flag;k++){
						for(int h=0;h<5 && flag;h++){
							if(b[k][h]==a[j]){
								c[k][h]=true;
								flag=false;
							}
						}
					}
					if(!corners && j<35)
						corners=c[0][0] && c[0][4] && c[4][0] && c[4][4];
					if(!mid && j<40)
						mid=c[2][0] && c[2][1] && c[2][2] && c[2][3] && c[2][4];
					if(!diagonal && j<45)
						diagonal=c[0][0] && c[1][1] && c[2][2] && c[3][3] && c[4][4] && c[0][4] && c[1][3] && c[3][1] && c[4][0];
					if(!table){
						flag=true;
						for(int k=0;k<5 && flag;k++){
							for(int h=0;h<5 && flag;h++){
								if(!c[k][h]){
									flag=false;
								}
							}
						}
						table=flag;
					}
				}
				int cnt=0;
				if(corners)
					cnt+=v[0];
				if(mid)
					cnt+=v[1];
				if(diagonal)
					cnt+=v[2];
				if(table)
					cnt+=v[3];
				System.out.println(cnt);
			}
		}
	}
}
package v_101;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA10152 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(bf.readLine());
		while(x-->0){
			int n=Integer.parseInt(bf.readLine());
			String[] a=new String[n];
			String[] b=new String[n];
			for(int i=0;i<n;i++){
				a[i]=bf.readLine();
			}
			for(int i=0;i<n;i++){
				b[i]=bf.readLine();
			}
			int j=n-1;
			int i=n-1;
			while(i>=0 && j>=0){
				if(j>=0 && !a[i].equals(b[j])){
					i--;
				}else{
					i--;
					j--;
				}
			}
			while(j>=0){
				System.out.println(b[j--]);
			}
			System.out.println();
		}
	}
}

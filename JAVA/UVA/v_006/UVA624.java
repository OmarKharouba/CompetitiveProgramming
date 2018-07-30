package v_006;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA624 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			String[]sa=s.split(" ");
			int n=Integer.parseInt(sa[0]);
			int t=Integer.parseInt(sa[1]);
			int[]a=new int[t];
			for(int i=0;i<t;i++){
				a[i]=Integer.parseInt(sa[i+2]);
			}
			int max=0;
			ArrayList<Integer> r=new ArrayList<Integer>();
			for(int mask=(1 << t)-1;mask>=0;mask--){
				int sum=0;
				ArrayList<Integer> arr=new ArrayList<Integer>();
				for(int j=0;j<t;j++){
					if((mask & (1 << j))!=0){
						sum+=a[j];
						arr.add(a[j]);
					}
				}
				if(sum>max && sum<=n){
					r=arr;
					max=sum;
				}
			}
			for(int i=0;i<r.size();i++){
				System.out.print(r.get(i)+" ");
			}
			System.out.println("sum:"+max);
		}
	}
}
package v_005;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class UVA574 {
	public static void main(String[]args)throws NumberFormatException,IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s=bf.readLine();
			String []sa=s.split(" ");
			int t=Integer.parseInt(sa[0]);
			int n=Integer.parseInt(sa[1]);
			if(n==0)
				break;
			int[]a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(sa[i+2]);
			}
			ArrayList<String> r=new ArrayList<String>();
			for(int mask=(1 << n)-1;mask>=0;mask--){
				StringBuilder sb=new StringBuilder();
				int sum=0;
				boolean f=false;
				for(int i=0;i<n;i++){
					if((mask & (1 << n-1-i))!=0){
						if(f)
							sb.append("+");
						sb.append(a[i]);
						f=true;
						sum+=a[i];
					}
				}
				if(sum==t && (r.isEmpty() || !r.contains(sb.toString())))
					r.add(sb.toString());
			}
			System.out.println("Sums of "+t+":");
			if(r.size()==0)
				System.out.println("NONE");
			for(int i=0;i<r.size();i++){
				System.out.println(r.get(i));
			}
		}
	}
}

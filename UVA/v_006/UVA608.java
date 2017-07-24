package v_006;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class UVA608 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int[]a=new int[12];
			Arrays.fill(a, 5);
			
			for(int i=0;i<3;i++){
				String s=bf.readLine();
				s=s.toLowerCase();
				String [] sa=s.split(" ");
				int r1=0,r2=0;
				switch(sa[2]){
				case "even" : r1=0; r2=0; break;
				case "down" : r1=-1; r2=1; break;
				default : r1=1; r2=-1; break;
				}
				for(int j=0;j<sa[0].length();j++){
					if(a[sa[0].charAt(j)-97]!=0){
						if(a[sa[0].charAt(j)-97]==5 || r1==0)
							a[sa[0].charAt(j)-97]=r1;
						else
							a[sa[0].charAt(j)-97]+=r1;
					}
				}
				for(int j=0;j<sa[1].length();j++){
					if(a[sa[1].charAt(j)-97]!=0){
						if(a[sa[1].charAt(j)-97]==5 || r2==0)
							a[sa[1].charAt(j)-97]=r2;
						else
							a[sa[1].charAt(j)-97]+=r2;
					}
				}
			}
			int max=0,min=0;
			int maxP=0,minP=0;
			int maxC=0,minC=0;
			for(int i=0;i<12;i++){
				if(a[i]!=5 && a[i]!=0){
					if(a[i]>max){
						maxP=i;
						max=a[i];
					}
					if(a[i]<min){
						minP=i;
						min=a[i];
					}
						
				}
			}
			for(int i=0;i<12;i++){
				if(a[i]==max){
					maxP=i;
					maxC++;
				}
				if(a[i]==min){
					minP=i;
					minC++;
				}
			}
			if(maxC==1 && Math.abs(max)>Math.abs(min)){
				char c=(char)(maxP+65);
				System.out.println(c+" is the counterfeit coin and it is heavy.");
			}else
			if(minC==1 && Math.abs(min)>Math.abs(max)){
				char c=(char)(minP+65);
				System.out.println(c+" is the counterfeit coin and it is light.");
			}
		}
	}
}
import java.util.Scanner;


public class PLD {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		String s=sc.next();
		String rev=new StringBuilder(s).reverse().toString();
		compute_z((s+"$"+rev).toCharArray());
		
		
		
		
	}
	
	static int n;
	static int [] z;
	
	static void compute_z(char [] s){
		n=s.length;
		int l=0,r=0,k=0;
		
		for(int i=1;i<n;i++){
			if(i>r){
				l=r=i;
				while(r<n && s[r-l]==s[r])
					r++;
				z[i]=r-l;
				r--;
			}else{
				k=i-l;
				if(z[k]<r-i+1)
					z[i]=z[k];
				else{
					l=i;
					while(r<n && s[r-l]==s[r])
						r++;
					z[i]=r-l;
					r--;
				}				
			}
		}
	}
}

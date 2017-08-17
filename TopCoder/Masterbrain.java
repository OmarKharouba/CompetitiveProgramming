package topcoder;

public class Masterbrain {
	public static void main(String[] args) {
		String [] a={"6172","6162","3617"};
		String [] b={"3b 0w","2b 1w","0b 3w"};
		System.out.println(possibleSecrets(a, b));
	}
	public static int possibleSecrets(String[] guesses, String[] results){
		int n=results.length;
		int [] cb=new int [n];
		int [] cw=new int [n];
		for(int i=0;i<n;i++){
			String [] sa=results[i].split(" ");
			cb[i]=Integer.parseInt(sa[0].substring(0, sa[0].length()-1));
			cw[i]=Integer.parseInt(sa[1].substring(0, sa[1].length()-1));
		}
		int ans=0;
		for(int i1=1;i1<=7;i1++)
			for(int i2=1;i2<=7;i2++)
				for(int i3=1;i3<=7;i3++)
					for(int i4=1;i4<=7;i4++){
						int [] a={i1,i2,i3,i4};
						int cntTrue=0;
						for(int j=0;j<n;j++){
							int cb2=0,cw2=0;
							boolean [] vis=new boolean [4];
							boolean [] vis2=new boolean [4];
							for(int k=0;k<4;k++)
								if(guesses[j].charAt(k)-'0'==a[k]){
									cb2++;
									vis[k]=true;
									vis2[k]=true;
								}
							for(int k=0;k<4;k++) // guess
								if(!vis[k])
									for(int k2=0;k2<4;k2++) // secret
										if(!vis2[k2] && guesses[j].charAt(k)-'0'==a[k2]){
											vis[k]=true;
											vis2[k2]=true;
											cw2++;
											break;
										}
							if(cb2==cb[j] && cw2==cw[j])
								cntTrue++;
						}
						if(cntTrue==n-1)
							ans++;
					}
		return ans;
	}
	
}

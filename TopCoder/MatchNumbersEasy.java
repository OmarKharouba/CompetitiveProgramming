
public class MatchNumbersEasy {
	
	public static void main(String[] args) {
		int [] a={6,7,8};
		System.out.println(maxNumber(a, 21));
	}
	
	public static String maxNumber(int[] matches, int n){
		int sz=matches.length;
		int min=-1;
		int minC=Integer.MAX_VALUE;
		for(int i=1;i<sz;i++){
			if(matches[i]<minC){
				minC=matches[i];
				min=i;
			}
		}
		if(minC>n){
			return "0";
		}
		String ans=min+"";
		n-=minC;
		min=-1;
		minC=Integer.MAX_VALUE;
		for(int i=0;i<sz;i++){
			if(matches[i]<minC){
				minC=matches[i];
				min=i;
			}
		}
		while(n-minC>=0){
			n-=minC;
			ans+=min;
		}
		char [] a=ans.toCharArray();
		for(int i=0;i<a.length;i++){
			for(int j=sz-1;j>a[i]-'0';j--){
				if(matches[j]<=n+matches[a[i]-'0']){
					n+=matches[a[i]-'0'];
					n-=matches[j];
					a[i]=(char)('0'+j);
					break;
				}
			}
		}
		
		StringBuilder ret=new StringBuilder();
		for(char c : a)
			ret.append(c);
		return ret.toString();
	}

}

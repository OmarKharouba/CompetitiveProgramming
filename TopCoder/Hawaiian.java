import java.util.Arrays;


public class Hawaiian {
	
	public static String[] getWords(String sentence){
		String [] sa=sentence.split(" ");
		int n=sa.length;
		boolean [] ok=new boolean [n];
		Arrays.fill(ok, true);
		String letters="aeiouAEIOUhklmnpwHKLMNPW";
		int cnt=0;
		for(int i=0;i<n;i++){
			for(char c : sa[i].toCharArray())
				if(!letters.contains(""+c))
					ok[i]=false;
			if(ok[i])
				cnt++;
		}
		int p=0;
		String [] ans=new String [cnt];
		for(int i=0;i<n;i++)
			if(ok[i])
				ans[p++]=sa[i];
		return ans;
	}
}

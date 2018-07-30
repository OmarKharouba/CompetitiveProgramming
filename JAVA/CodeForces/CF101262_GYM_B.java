import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CF101262_GYM_B {
	public static void main(String[] args) throws Throwable{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		String [] sa=br.readLine().split(" ");
		int n=Integer.parseInt(sa[0]);
		int k=Integer.parseInt(sa[1]);
		String s=br.readLine();
		if(k>n)
			pw.println("WRONGANSWER");
		else
			if(k==n)
				pw.println(s);
			else{
				int [] c=new int [26];
				for(int i=0;i<n;i++)
					c[s.charAt(i)-'a']++;
				int min=n;
				char minCh=0;
				for(int i=0;i<26;i++)
					if(c[i]<min){
						min=c[i];
						minCh=(char)('a'+i);
					}
				if(min>k)
					pw.println("WRONGANSWER");
				else{
					int p=0;
					char [] ans=new char [n];
					for(int i=k;i<n;i++)
						ans[i]=minCh;
					for(int i=0;i<n;i++){
						if(s.charAt(i)==minCh){
							ans[p++]=minCh;
							min--;
						}
						else
							if(k-1-p>=min)
								ans[p++]=s.charAt(i);
					}

					pw.println(new String(ans));
				}
			}
		
		
		pw.flush();
		pw.close();
	}
}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class ANARC09A {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		while(true){
			String s=bf.readLine();
			if(s.charAt(0)=='-')
				break;
			Stack<Character> st=new Stack<Character>();
			for(int i=0;i<s.length();i++){
				char c=s.charAt(i);
				if(!st.isEmpty() && st.peek()=='{' && c=='}')
					st.pop();
				else
					st.push(c);
			}
			int r=0;
			while(!st.isEmpty()){
				char x=st.pop();
				char y=st.pop();
				if(x==y)
					r++;
				else
					r+=2;
			}
			System.out.println(cnt+". "+r);
			cnt++;
		}
	}

}
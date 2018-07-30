package v_119;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class UVA11988 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		while((s=bf.readLine())!=null){
			LinkedList<String> ll=new LinkedList<String>();
			int start=0;
			char last=']';
			int i;
			for(i=0;i<s.length();i++){
				char c=s.charAt(i);
				if(c=='[' || c==']'){
					String word=s.substring(start, i);
					if(last==']')
						ll.addLast(word);
					else
						ll.addFirst(word);
					if(c=='[')
						last='[';
					else
						last=']';
					start=i+1;
				}
			}
			String word=s.substring(start, i);
			if(last==']')
				ll.addLast(word);
			else
				ll.addFirst(word);
			
			StringBuilder r2=new StringBuilder();
			while(!ll.isEmpty()){
				r2.append(ll.remove());
			}
			System.out.println(r2);
		}
	}
}

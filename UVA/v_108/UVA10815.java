package v_108;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVA10815 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		ArrayList<String> r=new ArrayList<String>();
		while((s=bf.readLine())!=null){
			s=s.toLowerCase();
			int n=s.length();
			StringBuilder t=new StringBuilder();
			for(int i=0;i<n;i++){
				char c=s.charAt(i);
				if(Character.isLetter(c)){
					t.append(c);
				}else{
					if(t.length()>0){
						int p=0;
						boolean flag=true;
						for(int k=0;k<r.size() && r.get(k).compareTo(t.toString())<=0 && flag;k++){
							if(r.get(k).equals(t.toString()))
								flag=false;
							p++;
						}
						if(flag)
							r.add(p,t.toString());
						t=new StringBuilder();
					}
				}
				
			}
			if(t.length()>0){
				int p=0;
				boolean flag=true;
				for(int k=0;k<r.size() && r.get(k).compareTo(t.toString())<=0 && flag;k++){
					if(r.get(k).equals(t.toString()))
						flag=false;
					p++;
				}
				if(flag)
					r.add(p,t.toString());
				t=new StringBuilder();
			}
		}
		for(int i=0;i<r.size();i++){
			System.out.println(r.get(i));
		}
	}
}
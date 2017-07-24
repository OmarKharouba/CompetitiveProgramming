package v_009;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
public class UVA939 {
	static TreeMap<String, String> status=new TreeMap<String, String>();
	static TreeMap<String, ArrayList<String>> parent=new TreeMap<String, ArrayList<String>>();
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(bf.readLine());
		for(int i=1;i<=k;i++){
			String s=bf.readLine();
			String[]sa=s.split(" ");
			if(sa[1].equals("dominant") || sa[1].equals("recessive") || sa[1].equals("non-existent"))
				status.put(sa[0], sa[1]);
			else
				if(parent.containsKey(sa[1])){
					ArrayList<String> a=parent.get(sa[1]);
					a.add(sa[0]);
					parent.put(sa[1],a);
				}else{
					ArrayList<String> a=new ArrayList<String>();
					a.add(sa[0]);
					parent.put(sa[1],a);
				}
		}
		for(Map.Entry e : parent.entrySet()){
			String r=f((String)e.getKey());
			status.put((String)e.getKey(), r);
		}
		for(Map.Entry e : status.entrySet()){
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}
	
	public static String f(String s){
		if(status.containsKey(s))
			return status.get(s);
		ArrayList<String> e=parent.get(s);
		String s1=f(e.get(0));
		String s2=f(e.get(1));
		boolean exist=s1.equals("dominant") || s2.equals("dominant") || (!s1.equals("non-existent") && !s2.equals("non-existent"));
		boolean dominant=false;
		if(exist){
			dominant=!s1.equals("non-existent") && !s2.equals("non-existent") && (s1.equals("dominant") || s2.equals("dominant"));
		}
		String r=(!exist)? "non-existent" : (dominant)? "dominant" : "recessive";
		return r;
	}
}
package v_002;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class UVA230 {
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<book> books=new ArrayList<book>();
		ArrayList<book> in=new ArrayList<book>();
		ArrayList<book> out=new ArrayList<book>();
		while(true){
			String s=bf.readLine();
			if(s.equals("END"))
				break;
			String[]sa=s.split(" by ");
			int p=0;
			for(int k=0;k<books.size() && ((books.get(k).a.compareTo(sa[1])<0) || ((books.get(k).a.equals(sa[1])) && (books.get(k).n.compareTo(sa[0])<0)));k++){
				p++;
			}
			books.add(p,new book(sa[0],sa[1]));
		}
		while(true){
			String s=bf.readLine();
			if(s.equals("END"))
				break;
			if(s.equals("SHELVE")){
				for(int i=0;i<in.size();i++){
					int p=0;
					for(int k=0;k<books.size() && ((books.get(k).a.compareTo(in.get(i).a)<0) || ((books.get(k).a.equals(in.get(i).a)) && (books.get(k).n.compareTo(in.get(i).n)<0)));k++){
						p++;
					}
					books.add(p,in.get(i));
					if(p==0)
						System.out.println("Put "+books.get(p).n+" first");
					else
						System.out.println("Put "+books.get(p).n+" after "+books.get(p-1).n);
				}
				in.clear();
				System.out.println("END");
			}else{
				String x=s.substring(0, 6);
				String y=s.substring(7);
				if(x.equals("BORROW")){
					for(int j=0;j<books.size();j++){
						if(books.get(j).n.equals(y)){
							out.add(books.remove(j));
							break;
						}
					}
				}else{
					for(int j=0;j<out.size();j++){
						if(out.get(j).n.equals(y)){
							int p=0;
							for(int k=0;k<in.size() && ((in.get(k).a.compareTo(out.get(j).a)<0) || ((in.get(k).a.equals(out.get(j).a)) && (in.get(k).n.compareTo(out.get(j).n)<0)));k++){
								p++;
							}
							in.add(p,out.remove(j));
							break;
						}
					}
				}
			}
		}
	}
}

class book{
	String n;
	String a;
	book(String n,String a){
		this.n=n;
		this.a=a;
	}
}
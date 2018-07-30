
public class UnLinker {
	public static void main(String[] args) {
		System.out.println(clean("espihttp://www.tv.org.superwww.cali.comaladocious"));
	}
	
	public static String clean(String text){
		String s=text.replaceAll("(http://)", "$");
		System.out.println(s);
		String ret="";
		
		
		return ret;
	}
}

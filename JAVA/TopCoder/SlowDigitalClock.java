package topcoder;

public class SlowDigitalClock {
	public static void main(String[] args) throws Throwable {
		System.out.println(firstCorrectTime("12:34", "23:45", 197));
	}
	public static String firstCorrectTime(String currentTime, String clockTime, int secsPerMinute){
		int s1=Integer.parseInt(currentTime.substring(0, 2))*3600+Integer.parseInt(currentTime.substring(3))*60;
		int s2=Integer.parseInt(clockTime.substring(0, 2))*60*secsPerMinute+Integer.parseInt(clockTime.substring(3))*secsPerMinute;
		int t=0;
		int d=0;
		while(true){
			s1+=d;
			s2+=d;
			if(t>2e6)
				break;
			int mins1=s1/60;
			int mins2=s2/secsPerMinute;
			int x=mins1%(24*60);
			int y=mins2%(24*60);
			String xx=convert(x,true);
			String yy=convert(y,false);
			if(xx.equals(yy))
				return xx;
			d=(s1/60+1)*60-s1;
			d=Math.min(d, (s2/secsPerMinute+1)*secsPerMinute-s2);
			t++;
		}
		return "";
	}
	
	static String convert(int mins,boolean real){
		String h=""+mins/60;
		String m=""+mins%60;
		if(h.length()==1)
			h="0"+h;
		if(m.length()==1)
			m="0"+m;
		if(real)
			return h+":"+m;
		else
			return ""+clk(m.charAt(1))+clk(m.charAt(0))+":"+clk(h.charAt(1))+clk(h.charAt(0));
	}
	
	static char clk(char i){
		if(i<='2' || i=='5' || i=='8' )
			return i;
		if(i=='6')
			return '9';
		if(i=='9')
			return '6';
		return '-';
	}
}

package project;

 

import java.util.Arrays;

import java.util.Comparator;

 

public class webLog {

	public String IP;

	public String Time;

	public String URL;

	public String Status;

	

	public webLog(String IP, String Time, String URL, String Status) {

		this.IP = IP;

		this.Status = Status;

		this.Time = Time;

		this.URL= URL;

	}

	public static Comparator<webLog> timeComparator = new Comparator<webLog>() {

		public int compare(webLog log1, webLog log2) {

		

				String[] front = log1.Time.substring(1).split("/|:");

				String[] back = log2.Time.substring(1).split("/|:");

				int year1=Integer.parseInt(front[2]),year2=Integer.parseInt(back[2]);

				

				if(year1 != year2) {

					return year1 - year2;

				}

				int month1 = month(front[1]), month2 = month(back[1]);

				if(month1 != month2) {

					return month1 - month2;	

				}

				int day1 = Integer.parseInt(front[0]),day2 = Integer.parseInt(back[0]);

				if(day1 != day2) {

					return day1 - day2; 

				}

				int hour1 = Integer.parseInt(front[3]),hour2 = Integer.parseInt(back[3]);

				if(hour1 != hour2) {

					return hour1 - hour2; 

				}

				int min1 = Integer.parseInt(front[4]),min2 = Integer.parseInt(back[4]);

				if(min1 != min2) {

					return min1 - min2; 

				}

 

				int s1 = Integer.parseInt(front[5]),  s2 = Integer.parseInt(back[5]);

				return s1 - s2; 

		}

	};

	public static Comparator<webLog> ipComparator = new Comparator<webLog>(){

		public int compare(webLog log1, webLog log2) {

				String[] front = log1.IP.split("\\.");

				String[] back = log2.IP.split("\\.");

				int i = 0;

				while(i < 4) {

					int f = Integer.parseInt(front[i]);

					int b = Integer.parseInt(back[i]);

					if(f != b) return f - b;

					i++;

				}

			return timeComparator.compare(log1, log2);

		}

	};

	public static int month(String str)

	{

		if(str.equals("Jan"))

			return 1;

		else if(str.equals("Feb"))

			return 2;

		else if(str.equals("Mar"))

			return 3;

		else if(str.equals("Apr"))

			return 4;

		else if(str.equals("May"))

			return 5;

		else if(str.equals("Jone"))

			return 6;

		else if(str.equals("July"))

			return 7;

		else if(str.equals("Aug"))

			return 8;

		else if(str.equals("Sept"))

			return 9;

		else if(str.equals("Oct"))

			return 10;

		else if(str.equals("Nov"))

			return 11;

		else if(str.equals("Dec"))

			return 12;		

		

		return -1;

	}

}
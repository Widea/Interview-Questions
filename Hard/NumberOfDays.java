// Program to calculate the number of days between two given dates, without using any date functions

import java.io.*;
public class NumberOfDays
{ 

    public static int daysCount(String input1,String input2)
    {
        if(input1 == input2)
        	return 0;
        
    // Getting the values of dd/mm/yyyy    
    int y1 = Integer.valueOf(input1.substring(input1.length() - 4, input1.length()));
    int y2 = Integer.valueOf(input2.substring(input2.length() - 4, input2.length()));   
    int m1 = Integer.valueOf(input1.substring(3,5));
    int m2 = Integer.valueOf(input2.substring(3,5));
    int d1 = Integer.valueOf(input1.substring(0,2));
    int d2 = Integer.valueOf(input2.substring(0,2));
    
    if(y2 < y1) {
      return 0;
     }
    if(y2 == y1 && m1 == m2 && d2 < d1) {
       return 0;
    }
    if(y2 == y1 && m1 < m2) {
       return 0;
    }
    
    int year_count = (y2 - y1 - 1) * 365;
   
   // Checking for leap years
   for(int i = y1+1 ; i < y2 ; i++) {
	   if(i % 4 == 0)
		   year_count++;
   }
   
   // Number of days each month 
   int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
   
   int month_days= 0;
   for(int i = m1+1 ; i <= 12 ; i++) {
	   month_days+=month[i-1];
   }
  
   for(int i = 1 ; i < m2 ; i++) {
	   month_days+=month[i-1];
   }
   
   int days1 = month[m1] - d1+1;
   int days2 = d2;
   
    return (days1+days2+month_days+year_count);
}
    public static void main(String[] args) {
    	System.out.println(daysCount("10-06-2012","15-10-2015"));
    	System.out.println(daysCount("10-10-2015","15-10-2015"));
    	System.out.println(daysCount("10-10-2015","15-10-2014"));
    	System.out.println(daysCount("17-10-2015","15-10-2015"));
    }
}

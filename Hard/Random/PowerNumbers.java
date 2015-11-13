// Reference : https://ideone.com/dyTbZF

// Program to generate all possible power numbers between a given range.
// A power number is defined as a number that can represented as a power of two numbers.
// i.e. p = a^b + c^d
// where, p is the power number
// 0 <= a,b < 500
// b,d > 1


import java.util.HashSet;
import java.util.Set;

public class PowerNumbers {
    int countPowerNumbers(int l, int r) {    	
    	
    	Set<Integer> powers = new HashSet<Integer>();
        Set<Integer> ans = new HashSet<Integer>();
    	int i, j;  	
    	
    	powers.add(0);
    	powers.add(1);
    	
    	for(i = 2; i < 500 ; i++) {
    	        int b = i;
    	        for(j = 0 ; j < 10; j++) {
    	        	powers.add(b);
    	            b = b * i;
    	            if(b > Integer.MAX_VALUE) 
    	            	break;
    	        }
    	   }
    	 
    	 Object[] temp = powers.toArray();
    	 Integer p = 0;
    	 for(i = 0 ; i < temp.length ; i++) {
    		 for(j = i ; j < temp.length ; j++) {
    			 p = (Integer)temp[i] + (Integer)temp[j];
    		 
    		 if((int) p >= l && (int)p <= r) {
    			// System.out.println(p);
    			 ans.add(p);
    		 }}
    	 }
    return ans.size();
    }

    public static void main(String[] args) {
    	PowerNumbers PN = new PowerNumbers();
    	System.out.println(PN.countPowerNumbers(25,30));
    	System.out.println(PN.countPowerNumbers(0,1));
    }
}

// Checking the divisibility of a binary number by 3, using bit manipulation.

public class numberDivisibility{
	
static int number ;	
public static void padNumber(int bitValue)	
{
	 number = (number << 1) | bitValue;
}

public static boolean isDivisibleBy3(){
int n = number;
	int oddCount = 0, evenCount = 0;
if(n < 0)   n = -n;
if(n == 0) return true;
if(n == 1) return false;

while(n != 0)
{
    if((n & 1) == 1) 
       oddCount++;
    n = n>>1;
    if((n & 1) == 1)
        evenCount++;
    n = n>>1;
}
return ((Math.abs(oddCount - evenCount)) % 3 == 0 );	
}	

public static void main(String[] args){
java.util.Scanner inputScanner = new java.util.Scanner(System.in);
System.out.println();
int input;
do{
	System.out.print("Enter the bit value: ");
	int bitValue = inputScanner.nextInt();
	padNumber(bitValue);
	System.out.print("Do you want to continue adding bits(respond in 0/1)? :");
	input = inputScanner.nextInt();
} while(input == 1);
System.out.println("Is divisible by three: " +isDivisibleBy3());
inputScanner.close();
}	
}

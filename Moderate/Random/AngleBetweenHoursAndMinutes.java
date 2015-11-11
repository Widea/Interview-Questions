// Program to calculate the angle between the hour and the minute hands of an analog clock.

public class AngleBetweenHoursAndMinutes {
	static int calculateAngle(int h, int m) {
		if(h < 0 || h > 12 || m > 60 || m < 0) {
			System.out.println("Invalid input");
			return -1;
		}
		
		if(h == 12) h = 0;
		if(m == 60) m = 0;
		
		// Hours hand with respect to '12': An hour hand covers 360 deg in 12 hours, or 720 minutes 
		// i.e. 0.5 degrees per minutes
		int hour_angle = (60 * h + m)/2;
		
		// Minutes hand with respect to '12': A minute hand covers 360 deg in 60 minutes
		// i.e. 6 degrees per minutes
		int min_angle = m * 6;
		
		int output = Math.abs(hour_angle - min_angle);
		output = output > (360-output) ? 360-output : output;
		
		return output;
		
	}
	
	public static void main(String[] args) {
		System.out.println("The angle between the two hands of the clock is: " +calculateAngle(03,16));
	}
}

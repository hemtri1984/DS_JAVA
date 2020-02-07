

public class UniqueCharsInString {

	public static void main(String[] args) {
		int checker = 0;
		String str = "HEMANTTRIPATHI";
		boolean isDuplicate = false;

		for(int i=0; i < str.length(); i++) {
			int charValue = str.charAt(i) - 'A';
			System.out.println("Checking Character: "+str.charAt(i));
			int leftShiftOneValue = 1 << charValue;
			if((checker & leftShiftOneValue) > 0) {
				System.out.println("Duplicate Found!");
				isDuplicate = true;
				break;
			}
			checker |= leftShiftOneValue;
		}
		if(!isDuplicate) {
			System.out.println("Unique String Detected!");
		}
	}
}

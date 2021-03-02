package week3.day1;

public class Iphone extends IosDevices {
	public void faceRecognition(int mode) {
		System.out.println("If dark mode, your answer will be 1 and if is light mode, ur answer is 2------>you are in" + mode);
	}
	
	public void faceRecognition(String mode) {
		System.out.println("You are in mode: " + mode);
	}
	
	public void faceRecognition(String mode, String anotherMode) {
		System.out.println("You are in mode:" + mode + " and " + anotherMode);
	}

}

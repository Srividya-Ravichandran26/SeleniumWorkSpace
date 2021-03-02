package week3.day1;

public class MyPhone {

	public static void main(String[] args) {
		Iphone myMobile = new Iphone();
		System.out.println(myMobile.swipeLeft());
		myMobile.faceRecognition(1);
		myMobile.faceRecognition("light mode");
		myMobile.faceRecognition("dark mode","light mode");
		myMobile.fingerPrint("Right Hand - Index Finger");

	}

}

package week1.day1;

public class Mobile {

	

	// To get the mobile model
	public String getModel() {

		return "OnePlus 6t";
	}

	// To Print the picture of whom in the wall paper (do not return and
	// confidential)
	private void printPicure() {
		System.out.println("My own picture");

	}
	
	// Price of the mobile
		public int getPrice(int whichMobile) {
			if(whichMobile == 1)
			{
				return 10000;
			}
			else if(whichMobile == 2)
			{
				return 20000;
			}
			else if(whichMobile == 3)
			{
				return 30000;
			}
			else
			{
				return 40000;
			}
		}
	
	public static void main(String[] args) {
		
		System.out.println("I am in main method");
		
		Mobile myMobile = new Mobile();
		System.out.println(myMobile.getPrice(4));
		System.out.println(myMobile.getModel());
		myMobile.printPicure();		
	}

}

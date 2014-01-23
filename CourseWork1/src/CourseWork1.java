
import java.util.Scanner;

public class CourseWork1 {

	static Scanner sc = new Scanner(System.in);
	private int[] myNums;
	private int choice;

	// This method asks to input the amount of numbers the user wants to input.
	// It receives the numbers into a global array (myNums)
	// Handling exceptions if the input not an integer

	public void amountOfnum() {
		System.out.print("How many numbers you wish to enter?");
		int count = sc.nextInt();
		if (count < 0) {
			System.err.println("This should be greater than 0!");
		}
		myNums = new int[count];

		System.out.println("Please enter these numbers:");
		for (int i = 0; i < myNums.length; i++) {
			if (sc.hasNextInt()) {
				myNums[i] = sc.nextInt();
			} else {
				System.out.println("Should be integer numbers!");
				sc.close();
			}
		}
	}

	// The user can choose from the following options.
	// the chosen number will be stored in global variable (choice)

	public void operations() {

		System.out.println("Please select from the options below:\n");
		System.out.println("1. Calculate the sum of the numbers.");
		System.out.println("2. Find the largest and the smallest numbers.");
		System.out.println("3. Find the indices of the largest and the smallest numbers.");
		System.out.println("4. Count the number of distinct values.");
		System.out.print("Your choice is: ");
		choice = sc.nextInt();
		System.out.println("");

	}

	// Sum method which add the numbers together in the array what we can give
	// to the method.
	// This way we can use it anywhere else with a different int array as well.

	private void sum(int[] myNums) {
		int sum = 0;
		for (int numsOfarray : myNums) {
			sum = sum + numsOfarray;
		}
		System.out.println("The sum of the numbers is: " + sum);
	}

	// It allocates the smallest and the largest number in the given array
	// by running trough the arrays numbers. Can be reused with int array.

	private void smallestLargest(int[] myNums) {
		int smallest = myNums[0];
		int largest = myNums[0];
		for (int i = 0; i < myNums.length; i++) {
			if (smallest > myNums[i]) {
				smallest = myNums[i];
			}
			if (largest < myNums[i]) {
				largest = myNums[i];
			}
		}
		System.out.println("The smallest number is " + smallest
				+ " and the largest is " + largest);
	}

	// This method uses the smallestLargest method's code to
	// allocate the smallest and largest number first.
	// and looking for these in the array and adding their indices to
	// a variable each. Can be reused with int array.

	private void onWhichIndex(int[] myNums) {
		int smallest = myNums[0];
		int largest = myNums[0];
		for (int i = 0; i < myNums.length; i++) {
			if (smallest > myNums[i]) {
				smallest = myNums[i];
			}
			if (largest < myNums[i]) {
				largest = myNums[i];
			}
		}
		String smallsIndx = "";
		String largesIndx = "";
		for (int j = 0; j < myNums.length; j++) {
			if (myNums[j] == smallest) {
				smallsIndx = smallsIndx + Integer.toString(j) + " ";
			}
			if (myNums[j] == largest) {
				largesIndx = largesIndx + Integer.toString(j) + " ";
			}
		}
		System.out.println("The smallest number can be found on " + smallsIndx
				+ " place.");
		System.out.println("The largest number can be found on " + largesIndx
				+ " place.");

	}

	// Counting the distinct value of the array by sorting it to ascending order
	// and compare the numbers together. It increments our variable if they do
	// not equal.
	// distinct starts at value 1 because of the first element of the array.

	private void numOfdistinct(int[] myNums) {
		int distinct = 0;
		for (int i = 0; i < myNums.length - 1; i++) {
			for (int j = 1; j < myNums.length; j++) {
				if (myNums[i] < myNums[j]) {
					int temp = myNums[i];
					myNums[i] = myNums[j];
					myNums[j] = temp;

				}
			}
		}
		if (myNums.length > 0) {
			distinct = 1;
		}
		int temp2 = myNums[0];
		for (int i = 0; i < myNums.length; i++) {
			if (myNums[i] != temp2) {
				temp2 = myNums[i];
				++distinct;
			}
		}

		System.out.println("The number of distinct value is " + distinct);
	}

	// Calling in the methods with a default constructor.
	// A switch selector for choosing the operation from 1-4.
	// default handles any input other than 1-4.

	public static void main(String[] args) throws IllegalArgumentException {
		CourseWork1 cw1 = new CourseWork1();
		cw1.amountOfnum();
		cw1.operations();
		switch (cw1.choice) {

		case 1:
			cw1.sum(cw1.myNums);
			break;
		case 2:
			cw1.smallestLargest(cw1.myNums);
			break;
		case 3:
			cw1.onWhichIndex(cw1.myNums);
			break;
		case 4:
			cw1.numOfdistinct(cw1.myNums);
			break;

		default:
			System.out.println("Please choose from 1-4. options above");

		}
	}
}

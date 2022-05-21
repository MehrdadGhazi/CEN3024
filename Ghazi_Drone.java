//Author Name: Mehrdad Ghazi
//Date: 5/14/2022
//Program Name: Ghazi_Drone
//Purpose: Simulate drone movements in x, y, z plane

import java.util.Scanner;

public class Ghazi_Drone {

	public static void main(String[] args) {
		
		//Create drone object
		Drone drone = new Drone();
		System.out.println("Drone Created");
		System.out.println(drone.toString() + "\n");
		
		//Menu
		Scanner input = new Scanner(System.in);
		String strUserInput = null;
		int intUserInput = 0;
		
		do {
			System.out.println("Which direction would you like to move the drone?");
			System.out.println("1. Move Up");
			System.out.println("2. Move Down");
			System.out.println("3. Move Forward");
			System.out.println("4. Move Backward");
			System.out.println("5. Turn Left");
			System.out.println("6. Turn Right");
			System.out.println("7. Display Position");
			System.out.println("8. Exit Navigation");
			strUserInput = input.nextLine();
			try {
				intUserInput = Integer.parseInt(strUserInput);
			} catch (NumberFormatException e) {
				intUserInput = 9;
			}
			
			switch (intUserInput) {
			case 1:
				//option 1 code
				drone.moveUp();
				System.out.println("You have moved up");
				break;
			case 2:
				//option 2 code
				drone.moveDown();
				System.out.println("You have moved down");
				break;
			case 3:
				//option 3 code
				drone.moveForward();
				System.out.println("You have moved forward");
				break;
			case 4:
				//option 4 code
				drone.moveBackward();
				System.out.println("You have moved backward");
				break;
			case 5:
				//option 5 code
				drone.turnLeft();
				System.out.println("You have turned left");
				break;
			case 6:
				//option 6 code
				drone.turnRight();
				System.out.println("You have turned right");
				break;
			case 7:
				//option 7 code
				System.out.println(drone.toString());
				break;
			case 8:
				//option 8 code
				System.out.println("Thank you for using Drone Navigator");
				input.close();
				break;
			default:
				System.out.println("Invalid menu option entered. Please try again.");
			}
			
		} while (intUserInput != 8);

	}

}
class Drone {
	
	private int xPos = 0;
	private int yPos = 0;
	private int zPos = 0;
	private String orientation = "North";

	//Drone starts at the same coordinates so only default constructor is needed
	public Drone() {
	}
	
	public void moveUp() {
		zPos++;
	}
	
	public void moveDown() {
		zPos--;
	}
	
	public void moveForward() {
		if (orientation == "North")
			yPos++;
		else if (orientation == "West")
			xPos--;
		else if (orientation == "South")
			yPos--;
		else if (orientation == "East")
			xPos++;
	}
	
	public void moveBackward() {
		if (orientation == "North")
			yPos--;
		else if (orientation == "West")
			xPos++;
		else if (orientation == "South")
			yPos++;
		else if (orientation == "East")
			xPos--;
	}
	
	public void turnLeft() {
		if (orientation == "North")
			orientation = "West";
		else if (orientation == "West")
			orientation = "South";
		else if (orientation == "South")
			orientation = "East";
		else if (orientation == "East")
			orientation = "North";
	}
	
	public void turnRight() {
		if (orientation == "North")
			orientation = "East";
		else if (orientation == "East")
			orientation = "South";
		else if (orientation == "South")
			orientation = "West";
		else if (orientation == "West")
			orientation = "North";
	}

	@Override
	public String toString() {
		return "Drone [xPos=" + xPos + ", yPos=" + yPos + ", zPos=" + zPos + ", orientation=" + orientation + "]";
	}
	
}

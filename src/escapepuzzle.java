package escape_puzzle;
import java.util.Scanner;

public class escapepuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("The door to this room opens with a creaking sound, your heart pounds to think of what this sound could attract.\n"
				+ "You quickly slip inside of the room and close the door behind you, trying to close the door as quietly and\n"
				+ "swiftly as you can. It doesn't strike you to be a very sturdy door.\n"
				+ "It is when you turn around is when you realize there are four dark figures in the room with you.\n"
				+ "Your heart leaps out of its chest as your body slams back against the door you just closed, your hands\n"
				+ "trying to reach for the door knob, when you blink and realize that these figures aren't moving.\n"
				+ "They're statues.\n"
				+ "...You could've sworn you saw movement when you first looked at them, though. It's probably nothing.\n"
				+ "In front of you are four statues of young ladies, the room otherwise is furnished in dark wood furniture.\n"
				+ "You seem to be able to push the statues if you tried hard enough.\n"
				+ "In the back of the room there is a door with a button beside it.\n"
				+ "What will you do?");
		
		int choice;

		String StatueOne = "Wolf";
		String StatueTwo = "Dragon";
		String StatueThree = "Mouth";
		String StatueFour = "Eye";
		String temp = null;
		boolean exit = false;
		
		do {
			
			System.out.println("1. Examine the statues closer.\n"
					+ "2. Look at the position of the statues.\n"
					+ "3. Swap the 1st and 2nd statues.\n"
					+ "4. Swap the 2nd and 3rd statues.\n"
					+ "5. Swap the 3rd and 4th statues.\n"
					+ "6. Try the button in the back of the room.\n");
			choice = in.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("The first statue appears to be a young girl in a cloak, upon further inspection it looks like there's a\n"
						+ "pair of wolf ears growing out of her head, as well as patches of fur growing from her skin. She\n"
						+ "smiles sweetly at you. She appears to be holding a basket with four apples in it.\n\n"
						+ "The second statue is a woman with long hair, there are scales growing on her face, as well as four\n"
						+ "horns growing out of her head. It looks like one of the horns fell off.\n\n"
						+ "The third statue is a woman with short curled hair. She smiles at you with two mouths.\n\n"
						+ "The fourth statue appears to be a woman in a long gown. One of the statues eyes seems to have been\n"
						+ "broken off of it, leaving a large hole in her head. Her one eye is looking down at the ground,\n"
						+ "almost entirely closed.\n\n");
				break;
			case 2:
				System.out.println("You looked at the statues.\n"
						/**+ "The statue of the girl with the wolf ears is in position "+ WPos + ".\n"
								+ "The statue of the lady with the scales is in position " + DPos + ".\n"
										+ "The statue of the lady with two mouths is in position " + MPos + ".\n"
												+ "The statue of the lady with one eye is in position " + EPos + ".\n\n"**/);
				System.out.println("The first statue is the " + StatueOne + " statue.\n"
						+ "The second statue is the " + StatueTwo + " statue.\n"
								+ "The third statue is the " + StatueThree + " statue.\n"
										+ "The forth statue is the " + StatueFour + " statue.\n");
				break;
			case 3:
				System.out.println("You managed to swap the 1st and 2nd statues.\n");
				System.out.println("Statue 1: " + StatueOne + ", statue 2: " + StatueTwo);
				temp = StatueOne;
				StatueOne = StatueTwo;
				StatueTwo = temp;
				System.out.println("AFTER SWAP: Statue 1: " + StatueOne + ", statue 2: " + StatueTwo);
				break;
			case 4:
				System.out.println("You swapped the 2nd and 3rd statues.\n");
				System.out.println("Statue 2: " + StatueTwo + ", statue 3: " + StatueThree);
				temp = StatueTwo;
				StatueTwo = StatueThree;
				StatueThree = temp;
				System.out.println("AFTER SWAP: Statue 2: " + StatueTwo + ", statue 3: " + StatueThree);
				break;
			case 5: 
				System.out.println("With effort you swapped the 3rd and 4th statues.\n");
				System.out.println("Statue 3: " + StatueThree + ", statue 4: " + StatueFour);
				temp = StatueThree;
				StatueThree = StatueFour;
				StatueFour = temp;
				System.out.println("AFTER SWAP: Statue 3: " + StatueThree + ", statue 4: " + StatueFour);
				break;
			case 6:
				System.out.println("You pressed the button.");
				if (StatueOne == "Eye" && StatueTwo == "Mouth" && StatueThree == "Dragon" && StatueFour == "Wolf") {
					System.out.println("As you press the button the door opens!");
					exit = true;
				}else {
					System.out.println("The button doesn't seem to do anything. You feel as if you could hear a growling noise behind the door you came in...");
				}
				break;
				default:
					System.out.println("That's not an option.\n");
					
			}
		}while(exit!=true);
	}

}
